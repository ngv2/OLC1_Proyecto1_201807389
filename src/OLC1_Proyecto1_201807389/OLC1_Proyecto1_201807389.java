
package OLC1_Proyecto1_201807389;


import Components.Compilador;

public class OLC1_Proyecto1_201807389 {

    public static void main(String[] args) {
        
             Inicial x = new Inicial();
    
    //  Analizador
    
         x.analizadores("src/analizador/", "Lexer.jflex", "Parser.cup");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compilador().setVisible(true);
            }
        });    
    }
    
   
}
