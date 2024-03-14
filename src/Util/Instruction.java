/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JTextArea;
import Components.Consola;

public class Instruction {
    public static HashMap<String, Object> tablaVariables = new HashMap<>();
    public static LinkedList<Object> listaPrint = new LinkedList<Object>();
    
    public static void Print(Object lista) {
        System.out.print(">>output: ");
        LinkedList<?> listaPrint = (LinkedList<?>) lista;
        JTextArea consola = Consola.getConsola();
        if (consola != null) {
             consola.append("   >>output:");
             consola.append("\n");
            for (Object elemento : listaPrint) {

                consola.append("   "+elemento.toString() + " , ");
            }

            System.out.println("");
            consola.append("\n");
        } else {
            for (Object elemento : listaPrint) {
                System.out.print(quitarComillas(elemento.toString()) + " , ");
            }

            System.out.println("");
        }
    }
    
  public static void PrintArr(Object listaO, String name) {
        JTextArea consola = Consola.getConsola();
        if (consola != null) {
            consola.append("   >>output:\n");
            consola.append("   -----------------\n");
            consola.append("   "+quitarComillas(name) + "\n");
            consola.append("   -----------------\n");
        }

        if (listaO instanceof LinkedList<?>) {
            LinkedList<?> lista = (LinkedList<?>) listaO;

            for (Object elemento : lista) {
                String elementoString = quitarComillas(elemento.toString());

                if (consola != null) {
                    consola.append("   "+elementoString + "\n");
                }
            }
        } else {
            System.out.println("El objeto no es una LinkedList<Object>.");
        }

        if (consola != null) {
            consola.append("\n");
        }
    }
        
    public static String quitarComillas(String entrada) {
        return entrada.replaceAll("\"", "");
    }
}
