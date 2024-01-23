/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici2;

/**
 *
 * @author Blanca
 */
public class PilaPunters{
    public Nodo nodo;
    
    private class Nodo {
        int valor;
        Nodo seguent;
    }
    
    public PilaPunters() {
        this.nodo = null;
    }
    
    public boolean buida() {
        return nodo == null;
    }
    
    public void push(int valor) {
        Nodo n = new Nodo();
        n.valor = valor;
        n.seguent = nodo;
        nodo = n;
    }
    
    public Integer pop() {
        if (buida()) {
            System.out.println("Lo sentimos, la pila esta vacia");
            return null;
        }
        int num = nodo.valor;
        nodo = nodo.seguent;
        return num;
    }
    
    public Integer top() {
        if (buida()) {
            System.out.println("Lo sentimos, la pila esta vacia");
            return null;
        }
        return nodo.valor;
    }
}