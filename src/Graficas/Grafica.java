/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficas;

import Components.Consola;
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

public class Grafica {
    
    public static HashMap<String, Object> parametros = new HashMap<>();
    
    public Grafica(){
    
    
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
        dataset.addValue(valores.get(i), " ", ejex.get(i));
    }

    JFreeChart grafica =
            ChartFactory.createBarChart(
                    Titulo, 
                    TituloX, TituloY,
                    dataset,
                    org.jfree.chart.plot.PlotOrientation.VERTICAL,
                    true, true, true);

    ChartFrame frame = new ChartFrame("Grafica de Barras", grafica);
    frame.setSize(700, 500);
    frame.setVisible(true);

    parametros.clear();
    } 
    
    public static void Pie() {
        
        String Titulo = parametros.get("titulo").toString();
        LinkedList<Double> valores = convertirListaDouble(parametros.get("values"));
        LinkedList<String> ejex = convertirListaString(parametros.get("label"));
        
        if (valores.size() != ejex.size()) {
            System.out.println("Las listas deben tener el mismo tamaño.");
            return;
        }

        DefaultPieDataset dataset = new DefaultPieDataset();

        for (int i = 0; i < valores.size(); i++) {
            dataset.setValue(ejex.get(i), valores.get(i));
        }

        JFreeChart grafica = ChartFactory.createPieChart(Titulo, dataset);

        ChartFrame frame = new ChartFrame("Grafica de Pie", grafica);
        frame.setSize(700, 500);
        
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
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < valores.size(); i++) {
            dataset.addValue(valores.get(i), "Valor", ejex.get(i));
        }
        JFreeChart grafica =
            ChartFactory.createLineChart(
                    Titulo,
                    TituloX,
                    TituloY,
                    dataset);
        ChartFrame frame = new ChartFrame("Linea", grafica);
        frame.setSize(700, 500);
        frame.setVisible(true);
        parametros.clear();
    }
    
      public static void Histograma() {
        String Titulo = parametros.get("titulo").toString();
        LinkedList<Double> valores = convertirListaDouble(parametros.get("values"));
        HistogramDataset dataset = new HistogramDataset();
        double[] valoresArray = valores.stream().mapToDouble(Double::doubleValue).toArray();
        dataset.addSeries("Histograma", valoresArray, 18);
        JFreeChart grafica =
                ChartFactory.createHistogram(
                        Titulo,
                        null,
                        null,
                        dataset);
          analisisArreglo(valores);
        ChartFrame frame = new ChartFrame("Grafica de Histograma", grafica);
        frame.setSize(700,500);
        frame.setVisible(true);
        parametros.clear();
    }
      
      
      
      
      
    private static void analisisArreglo(LinkedList<Double> datos) {

            JTextArea consola = Consola.getConsola();
            consola.append("   >>output:\n");
            consola.append("   __________________________\n");
            consola.append("   Valor      Fb        Fa         Fr\n");
            consola.append("   ------------------------------------------\n");

            Collections.sort(datos);

            Map<Double, Integer> frecuencias = new HashMap<>();

            int totalDatos = datos.size();
            int indice = 0;

            while (indice < totalDatos) {
                double valorActual = datos.get(indice);
                int frecuenciaAbsoluta = 0;

                while (indice < totalDatos && datos.get(indice) == valorActual) {
                    frecuenciaAbsoluta++;
                    indice++;
                }

                frecuencias.put(valorActual, frecuenciaAbsoluta);

                double frecuenciaRelativa = (double) frecuenciaAbsoluta / totalDatos * 100;

                consola.append(String.format("   %-10.1f%-10d%-12d%-6.2f%s%n", valorActual, frecuenciaAbsoluta, indice, frecuenciaRelativa, "%"));
            }
            
            consola.append("   --------------------------------------------\n");
            consola.append("  Totales:  " + totalDatos + "        " + totalDatos + "          100%"+"\n");
            consola.append("   ---------------------------------------------\n");
    }
    
public static void agregarOActualizar(String clave, Object valor) {
    if (parametros.containsKey(clave)) {
        return;
    } else {
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
