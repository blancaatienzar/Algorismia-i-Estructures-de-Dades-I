package exercici3;

/**
 * Clase abstracta base para todas las figuras geométricas (Circulo, Cuadrado
 * Triangulo y Rectanuglo).
 * 
 * @author Pau Toni Bibiloni & Blanca Atienzar
 */
public abstract class Figura {

    public abstract double calcularArea();

    public abstract double calcularPerimetro();

    public abstract String obtenerTipo();
}
