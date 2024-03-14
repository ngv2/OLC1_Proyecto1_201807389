/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Modelo.Token;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class HTMLGenerator {

    public static void generateHTML(LinkedList<Token> tokens, String titulo, String nameFile) {
        try {
            File file = new File(nameFile+".html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            // Escribir el encabezado del HTML con Bootstrap
            writer.write("<html>\n<head>\n<title>"+titulo+"</title>\n"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n" 
                    + "</head>\n<body>\n<div class=\"container\">\n"
                    + "<h1><CENTER>"+titulo+"</CENTER></h1>\n<table class=\"table table-danger\">\n"
                    + "<thead>\n<tr>\n<th>No.</th>\n<th>Token</th>\n<th>Tipo</th>\n<th>Fila</th>\n<th>Columna</th>\n</tr>\n</thead>\n<tbody>\n");

            int counter = 1;
            for (Token token : tokens) {
                writer.write("<tr>\n<td>" + counter + "</td>\n"
                        + "<td>" + token.getToken() + "</td>\n"
                        + "<td>" + token.getTipo() + "</td>\n"
                        + "<td>" + token.getFila() + "</td>\n"
                        + "<td>" + token.getColumna() + "</td>\n</tr>\n");
                counter++;
            }

            writer.write("</tbody>\n</table>\n</div>\n</body>\n</html>");

            writer.close();

            java.awt.Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            System.out.println("Err:"+e.getMessage());
        }
    }

       public static void generateHTMLErr(LinkedList<Token> tokens, String titulo, String nameFile) {
           
           if(!tokens.isEmpty()){
           
                try {
                    File file = new File(nameFile+".html");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                    writer.write("<html>\n<head>\n<title>"+titulo+"</title>\n"
                            + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n"
                            + "</head>\n<body>\n<div class=\"container\">\n"
                            + "<h1><CENTER>"+titulo+"</CENTER></h1>\n<table class=\"table table-danger\">\n"
                            + "<thead>\n<tr>\n<th>No.</th>\n<th>Tipo</th>\n<th>Descripcion</th>\n<th>Fila</th>\n<th>Columna</th>\n</tr>\n</thead>\n<tbody>\n");

                    int counter = 1;
                    for (Token token : tokens) {
                        writer.write("<tr>\n<td>" + counter + "</td>\n"
                                + "<td>" + token.getTipo() + "</td>\n"
                                + "<td>" + token.getToken() + "</td>\n"
                                + "<td>" + token.getFila() + "</td>\n"
                                + "<td>" + token.getColumna() + "</td>\n</tr>\n");
                        counter++;
                    }

                    writer.write("</tbody>\n</table>\n</div>\n</body>\n</html>");

                    writer.close();

                    java.awt.Desktop.getDesktop().browse(file.toURI());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                
           }
    }
       
       
        public static void generateHTMLTabSimb(HashMap<String, Object> data, String titulo, String nameFile) {
           
          if(!data.isEmpty()){
            
            try {
            File file = new File(nameFile + ".html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("<html>\n<head>\n<title>" + titulo + "</title>\n"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n"
                    + "</head>\n<body>\n<div class=\"container\">\n"
                    + "<h1><CENTER>" + titulo + "</CENTER></h1>\n<table class=\"table table-danger\">\n"
                    + "<thead>\n<tr>\n<th>No.</th>\n<th>Variable</th>\n<th>Valor</th>\n</tr>\n</thead>\n<tbody>\n");

            int counter = 1;
            for (String key : data.keySet()) {
                writer.write("<tr>\n<td>" + counter + "</td>\n"
                        + "<td>" + key + "</td>\n"
                        + "<td>" + data.get(key).toString() + "</td>\n</tr>\n");
                counter++;
            }

            writer.write("</tbody>\n</table>\n</div>\n</body>\n</html>");
            writer.close();
            java.awt.Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            System.out.println("Err:" + e.getMessage());
        }
      }
    }



}
