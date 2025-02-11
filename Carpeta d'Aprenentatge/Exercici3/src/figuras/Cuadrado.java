package figuras;

import exercici3.Figura;

/**
 * Clase que representa un cuadrado, por lo tanto sus cuatro lados 
 * son iguales.
 * 
 * @author Pau Toni Bibiloni & Blanca Atienzar
 */
public class Cuadrado extends Figura {

    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }

    @Override
    public String obtenerTipo() {
        return "Cuadrado";
    }
}
