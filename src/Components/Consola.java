/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.JTextArea;

public class Consola {
    private static JTextArea consola;

    public static void setConsola(JTextArea consolaInstance) {
        consola = consolaInstance;
    }

    public static JTextArea getConsola() {
        return consola;
    }
}