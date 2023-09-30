/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici3;

import figuras.Circulo;
import figuras.Cuadrado;
import figuras.Rectangulo;
import figuras.Triangulo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Clase principal donde se presentan las resoluciones dels los problemas del Ejercicio3 
 * relacionado con las figuras, y las operaciones para su realizacion, los problemas son: 
 * Suma total de las areas y perimetros de cada figura y total. Areas maximas y minimas de 
 * cada figura y total. Mostras de forma ordenada las 10 areas y perimetros de cada figura y total.
 * 
 * @author Pau Toni Bibiloni & Blanca Atienzar
 */
public class Exercici3 {

    /**
     * Metodo main donde se presentan los resultados
     * @param args 
     */
    public static void main(String[] args) {
        Collection<Figura> fig = generarFigurasAleatorias();
        List<Double> sumaAreas = calcularSuma(fig, "area");
        List<Double> sumaPerimetros = calcularSuma(fig, "peri");

        System.out.println(" 1. Suma de las areas y perimetros de todas las figuras");
        System.out.println("AREA TOTAL DE LAS FIGURAS: \n\t" + (sumaAreas.get(4)));
        System.out.println("PERIMETRO TOTAL DE LAS FIGURAS: \n\t" + (sumaPerimetros.get(4)));

        System.out.println("\n 2. Suma de las areas y perimetros de cada figura");
        System.out.println("AREAS: \n\tCIRCULO: " + sumaAreas.get(0) + "\tCUADRADO: " + sumaAreas.get(1)
                + "\n\tTRIANGULO: " + sumaAreas.get(2) + "\tRECTANGULO: " + sumaAreas.get(3));
        System.out.println("\nPERIMETROS: \n\tCIRCULO: " + sumaPerimetros.get(0) + "\tCUADRADO: " + sumaPerimetros.get(1)
                + "\n\tTRIANGULO: " + sumaPerimetros.get(2) + "\tRECTANGULO: " + sumaPerimetros.get(3));

        System.out.println("\n 3. Area maxima i minima de todas las figuras y per a cada tipus de figures");
        System.out.println("AREA MAXIMA TOTAL: \n\t" + (calcularAreaMaxima(fig, "null")));
        System.out.println("AREA MINIMA TOTAL: \n\t" + (OrdenarFigura(fig, "null", "area").get(0)));
        System.out.println("\nAREAS MAXIMAS: \n\tCIRCULO: " + calcularAreaMaxima(fig, "Círculo") + "\tCUADRADO: " + calcularAreaMaxima(fig, "Cuadrado")
                + "\n\tTRIANGULO: " + calcularAreaMaxima(fig, "Triangulo") + "\tRECTANGULO: " + calcularAreaMaxima(fig, "Rectángulo"));
        System.out.println("AREAS MINIMAS: \n\tCIRCULO: " + OrdenarFigura(fig, "Círculo", "area").get(0) + "\tCUADRADO: " + OrdenarFigura(fig, "Cuadrado", "area").get(0)
                + "\n\tTRIANGULO: " + OrdenarFigura(fig, "Triangulo", "area").get(0) + "\tRECTANGULO: " + OrdenarFigura(fig, "Rectángulo", "area").get(0));

        System.out.println("\n 4. Ordenar las figuras por areas y por perimetros y mostrar los 10 primeros. ");
        System.out.println("AREA TOTAL ORDENADA: \n\t" + (OrdenarFigura(fig, "null", "area").subList(0, 10)));
        System.out.println("PERIMETRO TOTAL ORDENADO: \n\t" + (OrdenarFigura(fig, "null", "perim").subList(0, 10)));
        System.out.println("\nAREAS ORDENADAS: \n\tCIRCULO: " + (OrdenarFigura(fig, "Círculo", "area").subList(0, 10)) + "\n\tCUADRADO: " + (OrdenarFigura(fig, "Cuadrado", "area").subList(0, 10))
                + "\n\tTRIANGULO: " + (OrdenarFigura(fig, "Triangulo", "area").subList(0, 10)) + "\n\tRECTANGULO: " + (OrdenarFigura(fig, "Rectángulo", "area").subList(0, 10)));
        System.out.println("PERIMETROS ORDENADOS: \n\tCIRCULO: " + (OrdenarFigura(fig, "Círculo", "perim").subList(0, 10)) + "\n\tCUADRADO: " + (OrdenarFigura(fig, "Cuadrado", "perim").subList(0, 10))
                + "\n\tTRIANGULO: " + (OrdenarFigura(fig, "Triangulo", "perim").subList(0, 10)) + "\n\tRECTANGULO: " + (OrdenarFigura(fig, "Rectángulo", "perim").subList(0, 10)));
    }

    /**
     * Metodo que devuelve un Collection con 10000 Objetos de Figuras, generados
     * de forma aleatoria el numero de cada tipo de figura y de sus dimensiones
     * @return Collection
     */
    public static Collection<Figura> generarFigurasAleatorias() {
        List<Figura> figuras = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int figuraAleatoria = random.nextInt(4);
            double lado1 = random.nextDouble() * 10 + 1;
            double lado2 = random.nextDouble() * 10 + 1;

            switch (figuraAleatoria) {
                case 0:
                    figuras.add(new Circulo(lado1));
                    break;
                case 1:
                    figuras.add(new Triangulo(lado1));
                    break;
                case 2:
                    figuras.add(new Rectangulo(lado1, lado2));
                    break;
                case 3:
                    figuras.add(new Cuadrado(lado1));
                    break;
            }
        }
        return figuras;
    }

    /**
     * Metodo para calcular la suma total de area o perimetros para una cada figura especifica 
     * y tambien guarda la suma total, todos estos sumatorios los guarda en una lista.
     * @param figuras Conjunto de elementos que contiene las figuras
     * @param tipoSuma Indicamos si queremos calcular el area o el perimetro
     * @return List  
     */
    public static List<Double> calcularSuma(Collection<Figura> figuras, String tipoSuma) {
        double sumaCercle = 0, sumaQuadrat = 0, sumaTriangle = 0, sumaRectangle = 0;
        double tipo = 0;
        List<Double> suma = new ArrayList<Double>();
        for (Figura figura : figuras) {
            if (tipoSuma == "area") {
                tipo = figura.calcularArea();
            } else {
                tipo = figura.calcularPerimetro();
            }
            if (figura.obtenerTipo() == "Círculo") {
                sumaCercle += tipo;
            } else if (figura.obtenerTipo() == "Cuadrado") {
                sumaQuadrat += tipo;
            } else if (figura.obtenerTipo() == "Triangulo") {
                sumaTriangle += tipo;
            } else if (figura.obtenerTipo() == "Rectángulo") {
                sumaRectangle += tipo;
            }
        }
        suma.add(0, sumaCercle);
        suma.add(1, sumaQuadrat);
        suma.add(2, sumaTriangle);
        suma.add(3, sumaRectangle);
        suma.add(4, sumaCercle + sumaQuadrat + sumaTriangle + sumaRectangle);
        return suma;
    }

    /**
     * Metodo capaz de ordenar las areas y perimetros de forma especifica/no especifica 
     * de cada figura, devolviendo una lista con el su debido orden.
     * @param figuras Conjunto de elementos que contiene las figuras
     * @param tipoFigura Indicamos la figura especifica o si es el total ("null")
     * @param ordenar Indicamos si queremos ordenar el area o el perimetro
     * @return List
     */
    public static List<Double> OrdenarFigura(Collection<Figura> figuras, String tipoFigura, String ordenar) {
        ArrayList<Double> suma = new ArrayList<>();
        for (Figura figura : figuras) {
            if (ordenar == "area") {
                if ((figura.obtenerTipo() == tipoFigura) || (tipoFigura == "null")) {
                    suma.add(figura.calcularArea());
                }
            } else {
                if ((figura.obtenerTipo() == tipoFigura) || (tipoFigura == "null")) {
                    suma.add(figura.calcularPerimetro());
                }
            }
        }
        Collections.sort(suma);
        while (10 > suma.size()) {
            suma.add(0.0);
        }
        return suma;
    }
    
    /**
     * Metodo que devuelde double con con el resultado despues de calcular 
     * el area maxima de cada figura o de todas las figuras en general
     * @param figuras Conjunto de elementos que contiene las figuras
     * @param tipoFigura Indicamos la figura especifica o si es el total ("null")
     * @return doubñe
     */
    public static double calcularAreaMaxima(Collection<Figura> figuras, String tipoFigura) {
        double maxima = 0;
        for (Figura figura : figuras) {
            if ((figura.obtenerTipo() == tipoFigura) || (tipoFigura == "null")) {
                double area = figura.calcularArea();
                if (area > maxima) {
                    maxima = area;
                }
            }
        }
        return maxima;
    }
}
