/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici2;

/**
 *
 * @author Blanca
 */
public class PilaCursors {

    private final String[] pila;
    public final int tamaño;
    public int top = -1;

    public PilaCursors(int tamaño) {
        pila = new String[tamaño];
        this.tamaño = tamaño;
    }

    public String pop() {
        if (buida()) {
            return " ";
        } else {
            top--;
            return "Pop: "+pila[top + 1];
        }
    }

    private boolean plena() {
        if (tamaño == top + 1) {
            System.out.println("Lo sentimos, la pila esta llena");
            return true;
        } else {
            return false;
        }
    }

    private boolean buida() {
        if (top == -1) {
            System.out.println("Lo sentimos, la pila esta vacia");
            return true;
        } else {
            return false;
        }
    }

    public void push(String caract) {
        if (!plena()) {
            pila[top + 1] = caract;
            top++;
        }
    }

    public String top() {
        if (top == -1) {
            return "Lo sentimos, la pila esta vacia";
        } else {

            return "Top: " + pila[top];
        }
    }

}
