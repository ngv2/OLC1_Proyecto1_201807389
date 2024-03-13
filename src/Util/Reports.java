/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Token;
import java.util.LinkedList;

/**
 *
 * @author argonzalez
 */
public class Reports {
    
    public static LinkedList<Token> listaTokens = new LinkedList <Token>();
    public static LinkedList<Token> listaErroresTok = new LinkedList <Token>(); 
     
    

    public static void agregarToken(String lex, String tipo, int fila, int columna){
       Token tk = new Token(lex, tipo,fila, columna);
       listaTokens.add(tk);
       
      
    }
    
    public static void agregarTokenErr(String lex, String tipo, int fila, int columna){
       Token tk = new Token(lex, tipo,fila, columna);
       listaErroresTok.add(tk);
       
      
    }
    
    
    public static void mostrarReporte(){
        for (Token token : listaTokens) {
            System.out.println("Lexema: " + token.getToken()+
                    " Tipo: " + token.getTipo()+
                    ", Fila: " + token.getFila() +
                    ", Columna: " + token.getColumna());
        }
    
    }
    
    
   

}




