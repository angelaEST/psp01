package edu.uniandes.ecos;

import java.util.ArrayList;

/**
 * Contiene la lógica para calcular la media y la desviación estandar de ina lista de parámetros.
 * @author Angela Suárez
 * @version 2.0 
 */
public class CalculoPromedio {

    
    private Double media;
    private Double desviacion;

    public CalculoPromedio() {

        media = (double) 0;
        desviacion = (double) 0;
    }
    /**
     * Calcula la media de una lista de valores de tipo Double
     * @param valores Lista de valores a los que se calculará la media
     */
    public void calcularMedia(ArrayList<Double> valores) {
        Double sumatoria = (double) 0;
        for (Double valor : valores) {
            sumatoria = sumatoria + valor;
        }
        this.setMedia(sumatoria / (valores.size()));
    }
    
    /**
     * Cálcula la desviación estandar de una lista de valores de tipo Double
     * @param valores Lista de valores a los que se calculará la desviación estandar
     */
    public void calcularDesviacion(ArrayList<Double> valores) {

        Double sumatoria = (double) 0;
        for (Double valor : valores) {
            sumatoria = sumatoria + Math.pow((valor - (this.getMedia())), 2);
        }
        this.setDesviacion(Math.sqrt(sumatoria / (valores.size() - 1)));

    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Double getDesviacion() {
        return desviacion;
    }

    public void setDesviacion(Double desviacion) {
        this.desviacion = desviacion;
    }

}
