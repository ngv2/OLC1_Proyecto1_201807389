/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;
import OLC1_Proyecto1_201807389.Inicial;
import javax.swing.*;
import java.awt.*;
public class Analisis {
    public static void analizarContenido(JTabbedPane tabbedPane, JTextArea resultadoTextArea) {
        int index = tabbedPane.getSelectedIndex();
        if (index != -1) {
            Component selectedComponent = tabbedPane.getComponentAt(index);
            if (selectedComponent instanceof JPanel) {
                JPanel selectedPanel = (JPanel) selectedComponent;
                JTextArea textArea = encontrarJTextArea(selectedPanel);
                if (textArea != null) {
                    Inicial ejecuta = new Inicial();
                    String contenido = textArea.getText();
                    ejecuta.analizar(contenido); 
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
