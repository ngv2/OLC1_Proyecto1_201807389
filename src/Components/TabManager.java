/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;
import Util.FileInput;
import Util.StateFiles;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class TabManager {
    public static void agregarPestanaDinamica(JTabbedPane tabbedPane) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String nombreArchivo = fileChooser.getSelectedFile().getName();
            String contenidoArchivo = leerContenidoArchivo(fileChooser.getSelectedFile().getPath());

            JPanel newPanel = new JPanel(new BorderLayout());

            JTextArea textArea = new JTextArea(contenidoArchivo);
            newPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
            
            FileInput fi = new FileInput(nombreArchivo,fileChooser.getSelectedFile().getPath() ,true);
            StateFiles.estadoGuardado.add(fi);
            
            tabbedPane.addTab(nombreArchivo, newPanel);
        }
    }

    private static String leerContenidoArchivo(String rutaArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
        return contenido.toString();
    }
    
    
    public static void agregarNuevaPestana(JTabbedPane tabbedPane) {
            JPanel newPanel = new JPanel(new BorderLayout());
            JTextArea textArea = new JTextArea();
            newPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
             
            FileInput fi = new FileInput("Archivo"+(tabbedPane.getTabCount() + 1), "" ,false);
            StateFiles.estadoGuardado.add(fi);
            
            tabbedPane.addTab("Archivo"+(tabbedPane.getTabCount() + 1), newPanel);

    }
 
    
 public static void guardarArchivo(JTabbedPane tabbedPane) {
    int index = tabbedPane.getSelectedIndex();
    if (index != -1) {

        Component selectedComponent = tabbedPane.getComponentAt(index);
        
        
        boolean archivoYaGuardado = false;
        String pathArchGuar = "";
        
        LinkedList<FileInput> fi = StateFiles.estadoGuardado;
        
        
         for (FileInput elemento : fi) {
            if(elemento.getName().equals( tabbedPane.getTitleAt(index))){
                System.out.println("pestaña de nombre: " + tabbedPane.getTitleAt(index));
                System.out.println("guardado: " + elemento.isExist());
                archivoYaGuardado = elemento.isExist();
                pathArchGuar = elemento.getDir();
            }
        }

        if (selectedComponent instanceof JPanel) {
            JPanel selectedPanel = (JPanel) selectedComponent;

            JTextArea textArea = encontrarJTextArea(selectedPanel);

            if (textArea != null) {
                String contenido = textArea.getText();

		if (!archivoYaGuardado) {
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showSaveDialog(null);

                    if (result == JFileChooser.APPROVE_OPTION) {
                            File archivo = fileChooser.getSelectedFile();
                            String rutaArchivo = archivo.getAbsolutePath();

                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
                                    
                                    writer.write(contenido);
                                    for (FileInput elemento : fi) {
                                            if(elemento.getName().equals( tabbedPane.getTitleAt(index))){
                                                elemento.setExist(true);
                                                elemento.setDir(rutaArchivo);
                                                elemento.setName(archivo.getName());
                                                
                                            }
                                        }
                                    tabbedPane.setTitleAt(index, archivo.getName());
                                    JOptionPane.showMessageDialog(null, "Archivo guardado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            } catch (IOException ex) {
                              JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                    }
		} else {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathArchGuar))) {
				writer.write(contenido);
                                
                                 JOptionPane.showMessageDialog(null, "Archivo guardado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException ex) {
                               JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
						
			}
		}
            }
        }
    }
}   
    



    private static JTextArea encontrarJTextArea(Container container) {
    for (Component component : container.getComponents()) {
        if (component instanceof JTextArea) {
            return (JTextArea) component;
        } else if (component instanceof Container) {
            JTextArea nestedTextArea = encontrarJTextArea((Container) component);
            if (nestedTextArea != null) {
                return nestedTextArea;
            }
        }
    }
    return null;
}

}
