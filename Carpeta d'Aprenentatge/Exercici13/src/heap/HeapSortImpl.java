/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

/**
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class HeapSortImpl<E extends Comparable<E>> implements HeapSort<E> {

    /**
     * <b>Algoritmo per ordenar un array.</b>
     * 
     * @param h conjunt de dades que s'ordenarà
     * @pre El array h no debe ser nulo
     * @post El array debe estar ordenado donde el elemento en la posicion menor 
     * a otro elemento debe ser menor
     * 
     * <p>
     * Este método ordena de forma recursiva el array h, utilizando un arbol
     * binario, por lo que seria un monticulo de ordenacion.
     * </p>
     * <p>
     * <b>Orden de complejidad y optimización:</b>
     * <li>
     *  El orden de complejidad de la CPU es O(n log n).
     * </li>
     * <li>
     *  El orden de complejidad del uso de memoria es O(n), donde n es igual a
     * la medida u tamaño del array h.
     * <ul><li>
     *    No cremos que se pueda optimizar el uso de memoria a causa de que en
     *    este programa, ya se utiliza el minimo posible de esppacio en memoria
     *    utilizando el mismo vector, es decir, sin crear uno nuevo para poner
     *    los elementos ya ordenados
     * </li></ul>
     * </li>
     * </p>
     */
    @Override
    public void heapSort(E[] h) {
        int n = h.length;

        // Construir el montículo (heap)
        for (int i = n; i >= 0; i--) {
            heapify(h, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz (elemento más grande) al final
            E temp = h[0];
            h[0] = h[i];
            h[i] = temp;

            heapify(h, i, 0);
        }
    }


private void heapify(E[] h, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && h[left].compareTo(h[largest]) > 0) {
            largest = left;
        }

        if (right < n && h[right].compareTo(h[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            E intercambio = h[i];
            h[i] = h[largest];
            h[largest] = intercambio;

            heapify(h, n, largest);
        }
    }
}
