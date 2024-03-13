
package Main;


import Components.Compilador;



/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
             Ejecutador ejecuta = new Ejecutador();
    
    // Generar Analizadores
    
         ejecuta.analizadores("src/analizador/", "Lexer.jflex", "Parser.cup");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compilador().setVisible(true);
            }
        });
        
       
      
        
       
             


    /*
        String entrada = """
                         program
                         
                         graphPie(
                                                  titulo::char[] = "Titulo inicial" end;
                                                  label::char[] = ["dato incorrecto", "dato2" ] end;
                                                  values::double = [20, 70] end;
                                                  titulo::char[] = "Titulo que se debe mostrar" end;
                                                  label::char[] = ["dato correcto", "dato2" ] end;
                                                  EXEC grapPie end;
                                                  ) end;
                         
                         
                         graphBar(
                         titulo::char[] = "Estudiantes" end;
                         ejeX::char[] = ["1 Parcial", "2 parcial", "Final"] end;
                         ejeY::double = [50, 30, 70] end;
                         tituloX::char[] = "Actividades" end;
                         tituloY::char[] = "Notas" end;
                         EXEC grapBar end;
                         ) end;
                         
                         graphLine(
                         titulo::char[] = "Gráfica de Linea" end;
                         ejeX::char[] = ["1 Parcial", "2 parcial", "Final"] end;
                         ejeY::double = [50, 30, 70] end;
                         tituloX::char[] = "Actividades" end;
                         tituloY::char[] = "Notas" end;
                         EXEC grapLine end;
                         ) end;
                         
                         
                         Histogram(
                         titulo::char[] = "Este no" end;
                         titulo::char[] = "Analisis de Arreglo" end;
                         values::double = [2,2,2,5,5,7,8] end;
                         EXEC Histogram end;
                         ) end;
                         
                         
                          end program
                          """;
       
         ejecuta.analizar(entrada);    
         */
       
        
        
        
    }
    
   
}
