/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Contiene la lógica para ejecutar el conteo de clases, métodos y líneas de una
 * clase en el directorio src
 *
 * @author Angela Edith Suárez Torres
 */
public class Contador {

    private int cantidadDirectorios;
    private int cantidadClases;
    private int cantidadMetodos;
    private StringBuilder valoresAcumulados;

    private static final String PALABRA_CLAVE_CLASS = "class ";
    private static final String PALABRA_CLAVE_FOR = "for ";
    private static final String PALABRA_CLAVE_WHILE = "while ";
    private static final String PALABRA_CLAVE_ELSE = "else ";
    private static final String PALABRA_CLAVE_IF = "if ";
    private static final String PALABRA_CLAVE_TRY = "try ";
    private static final String PALABRA_CLAVE_CATCH = "catch ";
    private static final String PALABRA_CLAVE_SYSTEM = "System ";
    private static final String PALABRA_CLAVE_DO = "do ";
    private static final String PALABRA_CLAVE_ENUM = "ENUM ";

    public Contador() {
        valoresAcumulados = new StringBuilder();
    }

    /**
     * Ejecuta el conteo de los directorios y clases en el directorio src
     * Recorre el contenido del directorio y acumula las cantidades de
     * directorios y clases.
     *
     * @param url Path del directorio src
     * @param directorios Contenido del directorio src
     */
    public void contadorClases(String url, String[] directorios) {

        for (String directorio1 : directorios) {
            File archivoLectura = new File(url + File.separator + directorio1);
            if (archivoLectura.isDirectory()) {
                cantidadDirectorios++;

                contadorClases(archivoLectura.getPath(), archivoLectura.list());
            } else {
                cantidadClases++;
                contadorLineas(archivoLectura, url);
            }

        }
    }

    /**
     * Ejecuta el conteo de métodos en una clase
     *
     * @param valor
     */
    public void contadorMetodos(String valor) {
        if (!valor.contains(";")) {
            if (!valor.contains("}")) {
                if (!valor.contains("{")) {
                    valoresAcumulados.append(valor);
                } else {
                    String sValoresAcumulados = valoresAcumulados.toString();
                    if (sValoresAcumulados.length() > 0) {
                        if ((!sValoresAcumulados.contains(PALABRA_CLAVE_CLASS))
                                && !sValoresAcumulados.contains(PALABRA_CLAVE_FOR)
                                && !sValoresAcumulados.contains(PALABRA_CLAVE_WHILE)
                                && !sValoresAcumulados.contains(PALABRA_CLAVE_ELSE)
                                && !sValoresAcumulados.contains(PALABRA_CLAVE_IF)
                                && !sValoresAcumulados.contains(PALABRA_CLAVE_TRY)
                                && !sValoresAcumulados.contains(PALABRA_CLAVE_CATCH)
                                && !sValoresAcumulados.contains(PALABRA_CLAVE_DO)
                                && !sValoresAcumulados.contains(PALABRA_CLAVE_ENUM)
                                && !sValoresAcumulados.contains(PALABRA_CLAVE_SYSTEM)) {
                            cantidadMetodos++;
                            valoresAcumulados = new StringBuilder();
                        }
                    } else {
                        if (!valor.contains(PALABRA_CLAVE_CLASS)
                                && !valor.contains(PALABRA_CLAVE_FOR)
                                && !valor.contains(PALABRA_CLAVE_WHILE)
                                && !valor.contains(PALABRA_CLAVE_ELSE)
                                && !valor.contains(PALABRA_CLAVE_IF)
                                && !valor.contains(PALABRA_CLAVE_TRY)
                                && !valor.contains(PALABRA_CLAVE_CATCH)
                                && !valor.contains(PALABRA_CLAVE_DO)
                                && !valor.contains(PALABRA_CLAVE_ENUM)
                                && !valor.contains(PALABRA_CLAVE_SYSTEM)) {
                            cantidadMetodos++;
                        }
                    }
                }
            }
        } else {
            valoresAcumulados = new StringBuilder();
        }

    }

    /**
     * Ejecuta el conteo de líneas de una clase de acuerdo a estandar definido
     *
     * @param archivo Archivo donde ejecutará el conteo de líneas
     * @param url Ubicación del archivo
     */
    public void contadorLineas(File archivo, String url) {

        BufferedReader reader = null;
        FileReader fileReader = null;

        String valor;
        int contador = 0;
        try {
            try {
                fileReader = new FileReader(archivo);
                reader = new BufferedReader(fileReader);
                System.out.println("\n" + "********    " + archivo.getName() + "   **************" + "\n");
                System.out.println("Estoy en el directorio: " + archivo.getParent() + "\n");
                while ((valor = reader.readLine()) != null) {
                    if (valor != null && valor.trim().length() > 0 && valor.trim().charAt(0) != '/' && !valor.trim().startsWith("*")) {
                        contadorMetodos(valor);
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

    public int getCantidadDirectorios() {
        return cantidadDirectorios;
    }

    public void setCantidadDirectorios(int cantidadDirectorios) {
        this.cantidadDirectorios = cantidadDirectorios;
    }

    public int getCantidadClases() {
        return cantidadClases;
    }

    public void setCantidadClases(int cantidadClases) {
        this.cantidadClases = cantidadClases;
    }

    public int getCantidadMetodos() {
        return cantidadMetodos;
    }

    public void setCantidadMetodos(int cantidadMetodos) {
        this.cantidadMetodos = cantidadMetodos;
    }

}
