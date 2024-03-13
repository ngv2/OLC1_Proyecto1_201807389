/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Token;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class HTMLGenerator {

    public static void generateHTML(LinkedList<Token> tokens, String titulo, String nameFile) {
        try {
            // Crear el archivo HTML
            File file = new File(nameFile+".html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            // Escribir el encabezado del HTML con Bootstrap
            writer.write("<html>\n<head>\n<title>"+titulo+"</title>\n"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n"
                    + "</head>\n<body>\n<div class=\"container\">\n"
                    + "<h2>"+titulo+"</h2>\n<table class=\"table table-bordered\">\n"
                    + "<thead>\n<tr>\n<th>#</th>\n<th>Token</th>\n<th>Tipo</th>\n<th>Fila</th>\n<th>Columna</th>\n</tr>\n</thead>\n<tbody>\n");

            // Iterar sobre la colección de tokens y escribir en el HTML
            int counter = 1;
            for (Token token : tokens) {
                writer.write("<tr>\n<td>" + counter + "</td>\n"
                        + "<td>" + token.getToken() + "</td>\n"
                        + "<td>" + token.getTipo() + "</td>\n"
                        + "<td>" + token.getFila() + "</td>\n"
                        + "<td>" + token.getColumna() + "</td>\n</tr>\n");
                counter++;
            }

            // Escribir el cierre del HTML
            writer.write("</tbody>\n</table>\n</div>\n</body>\n</html>");

            // Cerrar el escritor
            writer.close();

            // Abrir el archivo recién creado en el navegador predeterminado
            java.awt.Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            System.out.println("Err:"+e.getMessage());
        }
    }

       public static void generateHTMLErr(LinkedList<Token> tokens, String titulo, String nameFile) {
           
           if(!tokens.isEmpty()){
           
                try {
                    // Crear el archivo HTML
                    File file = new File(nameFile+".html");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                    // Escribir el encabezado del HTML con Bootstrap
                    writer.write("<html>\n<head>\n<title>"+titulo+"</title>\n"
                            + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n"
                            + "</head>\n<body>\n<div class=\"container\">\n"
                            + "<h2>"+titulo+"</h2>\n<table class=\"table table-bordered\">\n"
                            + "<thead>\n<tr>\n<th>#</th>\n<th>Tipo</th>\n<th>Descripcion</th>\n<th>Fila</th>\n<th>Columna</th>\n</tr>\n</thead>\n<tbody>\n");

                    // Iterar sobre la colección de tokens y escribir en el HTML
                    int counter = 1;
                    for (Token token : tokens) {
                        writer.write("<tr>\n<td>" + counter + "</td>\n"
                                + "<td>" + token.getTipo() + "</td>\n"
                                + "<td>" + token.getToken() + "</td>\n"
                                + "<td>" + token.getFila() + "</td>\n"
                                + "<td>" + token.getColumna() + "</td>\n</tr>\n");
                        counter++;
                    }

                    // Escribir el cierre del HTML
                    writer.write("</tbody>\n</table>\n</div>\n</body>\n</html>");

                    // Cerrar el escritor
                    writer.close();

                    // Abrir el archivo recién creado en el navegador predeterminado
                    java.awt.Desktop.getDesktop().browse(file.toURI());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                
           }
    }
       
       
        public static void generateHTMLTabSimb(HashMap<String, Object> data, String titulo, String nameFile) {
           
          if(!data.isEmpty()){
            
            try {
            // Crear el archivo HTML
            File file = new File(nameFile + ".html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            // Escribir el encabezado del HTML con Bootstrap
            writer.write("<html>\n<head>\n<title>" + titulo + "</title>\n"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n"
                    + "</head>\n<body>\n<div class=\"container\">\n"
                    + "<h2>" + titulo + "</h2>\n<table class=\"table table-bordered\">\n"
                    + "<thead>\n<tr>\n<th>#</th>\n<th>Variable</th>\n<th>Valor</th>\n</tr>\n</thead>\n<tbody>\n");

            // Iterar sobre la colección de datos y escribir en el HTML
            int counter = 1;
            for (String key : data.keySet()) {
                writer.write("<tr>\n<td>" + counter + "</td>\n"
                        + "<td>" + key + "</td>\n"
                        + "<td>" + data.get(key).toString() + "</td>\n</tr>\n");
                counter++;
            }

            // Escribir el cierre del HTML
            writer.write("</tbody>\n</table>\n</div>\n</body>\n</html>");

            // Cerrar el escritor
            writer.close();

            // Abrir el archivo recién creado en el navegador predeterminado
            java.awt.Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            System.out.println("Err:" + e.getMessage());
        }
      }
    }



}
