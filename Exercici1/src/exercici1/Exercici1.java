/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Carpeta d'Aprenentatge 1
 * @author Blanca
 * 12/09/2023
 */
public class Exercici1 {

    public static void main(String[] args) {
        //Numero de elementos del conjunto, elejido por el usuario
        int numElem = llegirNum("Introdueix el nombre de elements: ");

        //Inicializamos el conjunto, con elementos enteros aleatorios
        ArrayList<Integer> conjuElemen = new ArrayList();
        for (int i = 0; i < numElem; i++) {
            Random ran = new Random();
            conjuElemen.add(i, ran.nextInt());
        }

        //Metodo para ordenar el conjunto
        Collections.sort(conjuElemen);
        
        //Elemento del conjunto a buscar, elejido por el usuario
        int buscar = llegirNum("\nIntrodueix un element determinat a buscar: ");

        //Comparamos cada elemento con el nombre introducido,
        //cada vex que se encuentre el mismo, se escribira su posiciom
        boolean existeix=false;
        for (int i = 0; i < numElem; i++) {
            if (conjuElemen.get(i).equals(buscar)) {
                System.out.println("Posició: " + i + " ");
                existeix = true;
            }
        }
        if (!existeix) {
            System.out.println("No existeix");
        }
    }

    /**
     * Metodo para leer los nombre enteros introducidos por el usuario
     */
    private static int llegirNum(String text) {
        int x = 0;
        try {
            String s;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(text);
            s = in.readLine();
            x = Integer.parseInt(s);
        } catch (NumberFormatException e) {
        } catch (IOException e) {
            System.err.println("ERROR: PROBLEMAS CON LA REPRODUCCIÓN SONIDO");
        }
        return x;
    }
}
