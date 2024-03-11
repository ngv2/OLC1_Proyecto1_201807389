/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Tokens.ErrToken;
import Tokens.Token;
import analizador.Parser;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import analizador.*;
/**
 *
 * @author lets
 */
public class Ejecutador {
    
  public  void analizadores(String ruta, String jflexFile, String cupFile){
        try {
            String opcionesJflex[] =  {ruta+jflexFile,"-d",ruta};
            jflex.Main.generate(opcionesJflex);

            String opcionesCup[] =  {"-destdir", ruta,"-parser","Parser",ruta+cupFile};
            java_cup.Main.main(opcionesCup);
            
        } catch (Exception e) {
            System.out.println("No se ha podido generar los analizadores");
            System.out.println(e);
        }
    }
  
          // Realizar Analisis
    public  void analizar (String entrada){
        
         analizador.Lexer lexer = new analizador.Lexer(new StringReader(entrada)); 
        try {
         
            analizador.Parser parser = new analizador.Parser(lexer);
            parser.parse();
            
            
            

            
            
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
            // Imprimir tokens en consola
             
            System.out.println(e);
        } 
    } 
}
