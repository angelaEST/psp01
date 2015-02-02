/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.conteo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Contiene la l�gica para ejecutar el conteo de clases, m�todos y l�neas de una
 * clase en el directorio src
 *
 * @author Angela Edith Su�rez Torres
 */
public class Contador {

    private int cantidadDirectorios;
    private int cantidadClases;
    private int cantidadMetodos;
    private StringBuilder valoresAcumulados;

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
     * Ejecuta el conteo de m�todos en una clase
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
                        if ((!sValoresAcumulados.contains("class"))
                                && !sValoresAcumulados.contains("for")
                                && !sValoresAcumulados.contains("while")
                                && !sValoresAcumulados.contains("else")
                                && !sValoresAcumulados.contains("if")
                                && !sValoresAcumulados.contains("try")
                                && !sValoresAcumulados.contains("catch")
                                && !sValoresAcumulados.contentEquals("do")
                                && !sValoresAcumulados.contains("System")) {
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
                                && !valor.contentEquals("do")
                                && !valor.contains("System")) {
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
     * Ejecuta el conteo de l�neas de una clase de acuerdo a estandar definido
     *
     * @param archivo Archivo donde ejecutar� el conteo de l�neas
     * @param url Ubicaci�n del archivo
     */
    public
            void
            contadorLineas(
                    File archivo,
                    String url
            ) {

        BufferedReader reader = null;
        FileReader fileReader = null;

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