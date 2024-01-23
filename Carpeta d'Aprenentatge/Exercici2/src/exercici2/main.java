/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici2;

import java.util.Scanner;

/**
 * Carpeta d'Aprenentatge 2
 *
 * @author Blanca 18/09/2023
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el tamaño de la pila:");
        PilaCursors pilaC = new PilaCursors(scanner.nextInt());
        PilaPunters pilaP = new PilaPunters();

        System.out.println("* 1. Push - Pila Punteros        *" + "\n* 2. Pop - Pila Punteros         *"
                + "\n* 3. Top - Pila Punteros         *" + "\n* 4. Push - Pila Cursores        *"
                + "\n* 5. Pop - Pila Cursores         *" + "\n* 6. Top - Pila Cursores         *"
                + "\n* 7. Salir.                      *" + "\n     Introdueix una opcio:\n");

        int opc = scanner.nextInt();
        while (opc != 7) {
            switch (opc) {
                case 1: //Push
                    System.out.println("Introdueix un nombre: ");
                    pilaC.push(scanner.next());
                    break;

                case 2: //Pop
                    System.out.println(pilaC.pop());
                    break;

                case 3: //Top
                    System.out.println(pilaC.top());
                    break;

                case 4: //Push
                    System.out.println("Introdueix un nombre: ");
                    pilaP.push(scanner.nextInt());
                    break;

                case 5: //pop
                    if (!pilaP.buida()) {
                        System.out.print("Pop: pilaP.pop()");
                    }
                        System.out.println("Lo sentimos, la pila esta vacia");
                    break;

                case 6: //Top
                    if (pilaP.top() != null) {
                        System.out.println("Top: " + pilaP.top());
                    }
                    break;
            }
            System.out.println("\n     Introdueix una opcio:\n");
            opc = scanner.nextInt();
        }
    }
}
