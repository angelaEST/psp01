package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Clase2 {

    static int cantidadClases;
    static int cantidadDirectorios;
    static int cantidadMetodos;

    static StringBuilder valoresAcumulados = new StringBuilder();

    public static void fruc(String[] args) {

        File directorio = new File(System.getProperty("user.dir") + File.separator + "target" + File.separator + "classes" + File.separator + "src");
        
        System.out.println("lista " + Arrays.toString(directorio.list()));
        String[] directorios = directorio.list();
        String url = directorio.getPath();
        System.out.println("path " + url);

        Clase2.contarClases(url, directorios);
        System.out.println("HAY: " + cantidadClases + " CLASES");
        System.out.println("HAY: " + cantidadDirectorios + " DIRECTORIOS");
        System.out.println("HAY: " + cantidadMetodos + " METODOS");
    }

    public static void contarClases(String url, String[] directorios) {

        for (String directorio1 : directorios) {

            File archivoLectura = new File(url + File.separator + directorio1);
            if (archivoLectura.isDirectory()) {
                cantidadDirectorios++;
                contarClases(archivoLectura.getPath(), archivoLectura.list());
            } else {
                cantidadClases++;
                imprimirLinea(archivoLectura, url);
            }

        }
    }

    public static
            void
            imprimirLinea(
                    File archivo,
                    String url
            ) {

        BufferedReader reader = null;
        FileReader fileReader = null;
        //File archivo = new File(System.getProperty("user.dir") + File.separator + "target" + File.separator + "classes" + File.separator + "Clase.java");
        String valor;
        int contador = 0;
        try {
            try {
                fileReader = new FileReader(archivo);
                reader = new BufferedReader(fileReader);
                System.out.println("\n" + "************" + archivo.getName() + "**************" + "\n");
                System.out.println("Estoy en el directorio: " + archivo.getParent() + "\n");
                while ((valor = reader.readLine()) != null) {
                    if (valor != null && valor.trim().length() > 0 && valor.trim().charAt(0) != '/' && !valor.trim().startsWith("*")) {
                        contarMetodos(valor);
                        contador++;
                    }

                }
                System.out.println("Cantidad de Lineas : " + contador + "\n");
            } catch (FileNotFoundException ex) {
                System.out.println("Error con lectura de archivo. Se toma el array por defecto cargado" + "\n" + ex);
            }
        } catch (IOException ex) {
            System.out.println("Error con archivo. Se toma el array por defecto" + "\n");
        }
    }

    public static void contarMetodos(String valor) {
        if (!valor.contains(";")) {
            if (!valor.contains("}")) {
                if (!valor.contains("{")) {
                    valoresAcumulados.append(valor);
                } else {
                    String sValoresAcumulados = valoresAcumulados.toString();
                    if (sValoresAcumulados.length() > 0) {
                        if (!sValoresAcumulados.contains("class")
                                && !sValoresAcumulados.contains("for")
                                && !sValoresAcumulados.contains("while")
                                && !sValoresAcumulados.contains("else")
                                && !sValoresAcumulados.contains("if")
                                && !sValoresAcumulados.contains("try")
                                && !sValoresAcumulados.contains("catch")
                                && !sValoresAcumulados.contains("do")) {
                            cantidadMetodos++;
                            valoresAcumulados = new StringBuilder();
                        }
                    } else {
                        if (!valor.contains("class")
                                && !valor.contains("for")
                                && !valor.contains("while")
                                && !valor.contains("else")
                                && !valor.contains("if")
                                && !valor.contains("try")
                                && !valor.contains("catch")
                                && !valor.contains("do")) {
                            cantidadMetodos++;

                        }
                    }
                }
            }
        }

    }

}
// public
//            static
//         void 
//        imprimirLinea
//        (
//                File
//                        archivo
//                ,
//                String
//                        url
//        )
//        {
