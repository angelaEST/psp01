/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos;


import edu.uniandes.ecos.mundo.Contador;
import java.io.File;
import java.util.Arrays;

/******************************************************************/
/* Program Assignment:2                                                        
/* Name: Angela Edith Suárez Torres                                                                                  
/* Date: 31/05/15                  
/* Description: Presenta por consola los resultados del conteo ejecutado al tamaño del programa, sus clases y métodos
/******************************************************************/

public class PaintingText {

    public static void  main (String[] args) {
        Contador c = new Contador();
        File directorio = new File(System.getProperty("user.dir") + File.separator + 
                "target" + File.separator + "classes" +
                File.separator + "src");
        
        System.out.println("lista " 
                + Arrays.toString(directorio.list()));
        String[] directorios = directorio.list();
        String url = directorio.getPath();
        System.out.println("path " + url);

        c.contadorClases(url, directorios);
        System.out.println("HAY: " + 
                c.getCantidadClases() + 
                " CLASES");
        System.out.println("HAY: " + c.getCantidadDirectorios() + " DIRECTORIOS");
        System.out.println("HAY: " + c.getCantidadMetodos()+ " METODOS");
    }
}
