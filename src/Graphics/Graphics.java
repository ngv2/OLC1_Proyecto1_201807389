/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graphics;

import Components.ConsolaManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JTextArea;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

/**
 *
 * @author lets
 */
public class Graphics {
    
    public static HashMap<String, Object> parametros = new HashMap<>();
    
    public Graphics(){
    
    
    }
    
    public static void Barras() {
    // Ingreso de datos
    String Titulo = parametros.get("titulo").toString();
    String TituloX = parametros.get("tituloX").toString();
    String TituloY = parametros.get("tituloY").toString();
    LinkedList<String> ejex = convertirListaString(parametros.get("ejeX"));
    LinkedList<Double> valores = convertirListaDouble(parametros.get("ejeY"));
    
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    for (int i = 0; i < valores.size(); i++) {
        dataset.addValue(valores.get(i), "Valor", ejex.get(i));
    }

    // Creación de gráfica
    JFreeChart grafica =
            ChartFactory.createBarChart(
                    Titulo, //TITULO
                    TituloX, TituloY,
                    dataset,
                    org.jfree.chart.plot.PlotOrientation.VERTICAL,
                    true, true, true);


    // Mostrar
    ChartFrame frame = new ChartFrame("Barras", grafica);
    frame.setSize(600, 400);
    frame.setVisible(true);
    
    //limpiamos los parámetros
    parametros.clear();
    } 
    
    public static void Pie() {
        
        String Titulo = parametros.get("titulo").toString();
        LinkedList<Double> valores = convertirListaDouble(parametros.get("values"));
        LinkedList<String> ejex = convertirListaString(parametros.get("label"));
        
        
        // Verificar que las listas tengan el mismo tamaño
        if (valores.size() != ejex.size()) {
            System.out.println("Las listas deben tener el mismo tamaño.");
            return;
        }

        // Ingreso de datos
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Crear gráfico
        for (int i = 0; i < valores.size(); i++) {
            dataset.setValue(ejex.get(i), valores.get(i));
        }

        JFreeChart grafica = ChartFactory.createPieChart(Titulo, dataset);

        // Mostrar
        ChartFrame frame = new ChartFrame("Pie", grafica);
        frame.setSize(600, 400);
        
        frame.setVisible(true);
        parametros.clear();
    }
    
    public static void Linea()
    {
        String Titulo = parametros.get("titulo").toString();
        String TituloX = parametros.get("tituloX").toString();
        String TituloY = parametros.get("tituloY").toString();
        LinkedList<String> ejex = convertirListaString(parametros.get("ejeX"));
        LinkedList<Double> valores = convertirListaDouble(parametros.get("ejeY"));
        // Ingreso de datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Agregar valores al dataset
        for (int i = 0; i < valores.size(); i++) {
            dataset.addValue(valores.get(i), "Valor", ejex.get(i));
        }

        // Creación de gráfica
        JFreeChart grafica =
            ChartFactory.createLineChart(
                    Titulo,
                    TituloX,
                    TituloY,
                    dataset);

        // Mostrar
        ChartFrame frame = new ChartFrame("Linea", grafica);
        frame.setSize(600, 400);
        frame.setVisible(true);
        parametros.clear();
    }
    
      public static void Histograma() {
        String Titulo = parametros.get("titulo").toString();
        LinkedList<Double> valores = convertirListaDouble(parametros.get("values"));
        
        // Crear un conjunto de datos de histograma
        HistogramDataset dataset = new HistogramDataset();
        double[] valoresArray = valores.stream().mapToDouble(Double::doubleValue).toArray();
        dataset.addSeries("Histograma", valoresArray, 18);

        // Crear gráfica de histograma
        JFreeChart grafica =
                ChartFactory.createHistogram(
                        Titulo,
                        null,
                        null,
                        dataset);
          analisisArreglo(valores);
        // Mostrar
        ChartFrame frame = new ChartFrame("Histograma", grafica);
        frame.setSize(600,400);
        frame.setVisible(true);
        parametros.clear();
    }
      
      
      
      
      
    private static void analisisArreglo(LinkedList<Double> datos) {
        // Verifica si la lista es un LinkedList de tipo Double
            
            JTextArea consola = ConsolaManager.getConsola();
            consola.append("   >>output:\n");
            System.out.println("Analisis Arreglo");
            consola.append("   __________________________\n");
            System.out.println("__________________________________________");
            consola.append("   Valor      Fb        Fa         Fr\n");
            System.out.println("Valor      Fb        Fa         Fr");
            consola.append("   ------------------------------------------\n");
            System.out.println("------------------------------------------");

            // Ordena la lista de datos
            Collections.sort(datos);

            // Mapa para almacenar las frecuencias
            Map<Double, Integer> frecuencias = new HashMap<>();

            int totalDatos = datos.size();
            int indice = 0;

            // Calcula las frecuencias
            while (indice < totalDatos) {
                double valorActual = datos.get(indice);
                int frecuenciaAbsoluta = 0;

                while (indice < totalDatos && datos.get(indice) == valorActual) {
                    frecuenciaAbsoluta++;
                    indice++;
                }

                frecuencias.put(valorActual, frecuenciaAbsoluta);

                // Calcula frecuencia relativa
                double frecuenciaRelativa = (double) frecuenciaAbsoluta / totalDatos * 100;

                // Imprime la fila de la tabla
                consola.append(String.format("   %-10.1f%-10d%-12d%-6.2f%s%n", valorActual, frecuenciaAbsoluta, indice, frecuenciaRelativa, "%"));
                System.out.printf("%-10.1f%-10d%-12d%-6.2f%s%n", valorActual, frecuenciaAbsoluta,
                        indice, frecuenciaRelativa, "%");
            }
            
            consola.append("   --------------------------------------------\n");
            
            System.out.println("-------------------------------------------");
            consola.append("  Totales:  " + totalDatos + "        " + totalDatos + "          100%"+"\n");
            System.out.println("Totales:  " + totalDatos + "           " + totalDatos + "             100%");
            consola.append("   ---------------------------------------------\n");
            System.out.println("---------------------------------------");
        
    }
    
public static void agregarOActualizar(String clave, Object valor) {
    if (parametros.containsKey(clave)) {
        // Si la clave ya existe no pasa nada
        return;
    } else {
        // Si la clave no existe, agrega la nueva clave-valor
        System.out.println("Agrega nuevo valor: " + clave + " a: " + valor.toString());
        parametros.put(clave, valor);
    }
}
   
   
   private static LinkedList<Double> convertirListaDouble(Object lista) {
    LinkedList<Double> listaDoubles = new LinkedList<>();

    if (lista instanceof LinkedList<?>) {
        LinkedList<?> listaOriginal = (LinkedList<?>) lista;

        for (Object valor : listaOriginal) {
            try {
                if (valor instanceof Number) {
                    listaDoubles.add(((Number) valor).doubleValue());
                } else {
                    double valorDouble = Double.parseDouble(valor.toString());
                    listaDoubles.add(valorDouble);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir el valor: " + valor + ". Se omite.");
            }
        }
    } else {
        System.out.println("Error: El objeto no es una LinkedList.");
    }

    return listaDoubles;
   }
   
   
   private static LinkedList<String> convertirListaString(Object lista) {
        LinkedList<String> listaStrings = new LinkedList<>();

        if (lista instanceof LinkedList<?>) {
            LinkedList<?> listaOriginal = (LinkedList<?>) lista;

            for (Object valor : listaOriginal) {
                try {
                    String valorString = valor.toString();
                    listaStrings.add(valorString);
                } catch (Exception e) {
                    System.out.println("Error al convertir el valor: " + valor + ". Se omite.");
                }
            }
        } else {
            System.out.println("Error: El objeto no es una LinkedList.");
        }

        return listaStrings;
    }
}
