package figuras;

import exercici3.Figura;

/**
 * Clase que representa un rectángulo, por lo tanto de sus cuatro lados 
 * son iguales a diferencia de sus otros dos.
 * 
 * @author Pau Toni Bibiloni & Blanca Atienzar
 */
public class Rectangulo extends Figura {

    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public String obtenerTipo() {
        return "Rectángulo";
    }
}
