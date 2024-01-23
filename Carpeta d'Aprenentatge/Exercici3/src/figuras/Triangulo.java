package figuras;

import exercici3.Figura;

/**
 * Clase que representa un triangulo equilatero, por lo tanto todos 
 * sus lados son de la misma longitud. De este modo, resulta mas facil
 * calcular su area entre otras cosas.
 * 
 * @author Pau Toni Bibiloni & Blanca Atienzar
 */
public class Triangulo extends Figura {

    private double lado;

    public Triangulo(double lado1) {
        this.lado = lado1;     
    }

    @Override
    public double calcularArea() {
        return (Math.sqrt(3) / 4) * lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 3 * lado;
    }

    @Override
    public String obtenerTipo() {
        return "Triangulo";
    }
}
