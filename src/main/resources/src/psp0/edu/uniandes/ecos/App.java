package edu.uniandes.ecos;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase con el método principal
 */
public class App {

    /**
     * Método principal
     *
     * @param args
     */
    public static void main(String[] args) {

        BufferedReader reader = null;
        FileReader fileReader = null;
        ArrayList<Double> valores = new ArrayList<Double>();
        valores.add((double) 186);
        valores.add((double) 699);
        valores.add((double) 132);
        valores.add((double) 272);
        valores.add((double) 291);
        valores.add((double) 331);
        valores.add((double) 199);
        valores.add((double) 1890);
        valores.add((double) 788);
        valores.add((double) 1601);
        
        File archivo = new File(System.getProperty("user.dir") + File.separator + "target" + File.separator + "classes" + File.separator + "valores.txt");
        try {
            fileReader = new FileReader(archivo);
            reader = new BufferedReader(fileReader);
            String valor;
            try {
                valores = new ArrayList<Double>();
                System.out.println("Lectura exitosa de archivo. Se toman valores cargados desde el archivo valores.txt" + "\n");
                while ((valor = reader.readLine()) != null) {
                    System.out.println(valor);
                    valores.add(Double.valueOf(valor));
                }
            } catch (IOException ex) {
                System.out.println("Error con archivo. Se toma el array por defecto" + "\n");
                System.out.println(valores.toString() + "\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error con lectura de archivo. Se toma el array por defecto cargado" + "\n" + ex);
            System.out.println(valores.toString() + "\n");
        }

        CalculoPromedio promedio = new CalculoPromedio();
        promedio.calcularMedia(valores);
        promedio.calcularDesviacion(valores);

        System.out.println("El resultado de la media es: " + promedio.getMedia());
        System.out.println("El resultado de la desviacion estandar es: " + promedio.getDesviacion());

    }
}
