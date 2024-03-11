/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Vistas.Inicio;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lets
 */
public class OLC1_Proyecto1_201807389 {
               
      
        
         /*
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });*/
       
        
       
       
       Ejecutador ejecuta = new Ejecutador();
    
    // Generar Analizadores
    
         ejecuta.analizadores("src/analizador/", "Lexer.jflex", "Parser.cup");
    
        String entrada = """
                          program
                         !comentario de una linea
                         
                         var:double::suma<-SUM(sum(sum(1,2),sum(1,2)),sum(1,2)) end;
                          var:double::resta<-res(sum(1,2),1) end;
                         var:double:: prueba <- MUL( SUM(7,3) , RES(7, DIV(25,5)) ) end;
                          arr:double::@darray <- [ SUM(7,3), DIV(sum(22,3),sum(1,4)), 4 ,5] end;
                         var:char[] :: titulo <- "Mi Arreglo" end;
                         
                         arr:char[]::@p1 <- ["hola", "soy", "un", "array"] end;
                         arr:char[]::@p2<-@p1 end;
                         arr:char[]::@p3 <-@p2 end;
                         arr:double::@doble <- @darray  end; 
                         var:double:: med1 <- Media([1, 2, SUM(3, 3), 4]) end;
                         var:double:: mediana2 <- Mediana( @doble ) end;
                         arr:double::@arreglo <- [Media(@darray), Mediana(@doble)] end;
                         var:double:: mitad <- DIV( SUM(Max(@arreglo), res(Max(@arreglo), min(@arreglo))), 2) end;
                         
                         console::print = "hola", titulo, 15, "adios" end;
                         console::print = 1, 2, SUM(3,5), Media(@arreglo) end;
                         console::column = "hola" -> @p1 end;
                         console::column = titulo -> @darray end;
                         <! comentario
                         multilinea !>
                          end program
                          """;
       
         ejecuta.analizar(entrada);    

        
         
         /*
         LinkedList<String> result = new LinkedList<String>(); 
          result.add("hola");
          result.add("3");
          
          Object tipo1 = result;
            for (String elemento  : (LinkedList<String>)tipo1 ) {
                System.out.println(elemento);
            }
          */
    }
    
    
}
