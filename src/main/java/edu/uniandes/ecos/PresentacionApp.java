/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos;


import edu.uniandes.ecos.conteo.Contador;
import java.io.File;
import java.util.Arrays;

/**
 *
 * @author Angela Edith Suárez Torres
 */
public class PresentacionApp {

    public void presentarConteo() {
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
