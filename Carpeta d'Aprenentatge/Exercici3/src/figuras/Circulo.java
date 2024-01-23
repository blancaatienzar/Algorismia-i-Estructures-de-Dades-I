package figuras;

import exercici3.Figura;

/**
 * Clase que representa un círculo, donde solo se necesita su radio
 * para poder calcular area y perimetro.
 * 
 * @author Pau Toni Bibiloni & Blanca Atienzar
 */
public class Circulo extends Figura {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String obtenerTipo() {
        return "Círculo";
    }
}
