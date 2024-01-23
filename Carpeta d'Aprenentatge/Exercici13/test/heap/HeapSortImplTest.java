/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package heap;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class HeapSortImplTest {

    public HeapSortImplTest() {
    }

    /**
     * Test of heapSort method, of class HeapSortImpl.
     */
    @Test
    public void testHeapSort() {
        System.out.println("heapSort");
        Integer a[] = new Integer[100];
        Random r = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100);
        }

        HeapSortImpl<Integer> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
            }
        }
        assertEquals(true, result);
    }

    /**
     * Test of heapSort method, of class HeapSortImpl. Hecho por nosotros
     */
    @Test
    public void testHeapSortWithString() {
        System.out.println("heapSortWithString");
        String a[] = {"Avila", "Burgos", "León", "Palencia", "Salamanca", "Valladolid", "Zamora"};

        HeapSortImpl<String> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                result = false;
            }
        }
        assertEquals(true, result);
    }

    /**
     * Test of heapSort method, of class HeapSortImpl. Hecho por nosotros
     */
    @Test
    public void testHeapSortWithCharacter() {
        System.out.println("heapSortWithCharacter");
        Character a[] = {'A', 'f', 'B', 'w', 'A'};

        HeapSortImpl<Character> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                result = false;
            }
        }
        assertEquals(true, result);
    }

    /**
     * Test of heapSort method, of class HeapSortImpl. Hecho por nosotros
     */
    @Test
    public void testHeapSortNull() {
        System.out.println("heapSortNull");
        Integer a[] = {null};

        HeapSortImpl<Integer> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                result = false;
            }
        }
        assertEquals(true, result);
    }

    @Test
    public void testHeapSortNull2() {
        System.out.println("heapSortNull2");
        Integer a[] = null;

        HeapSortImpl<Integer> hs = new HeapSortImpl<>();
        
        try {
            hs.heapSort(a);
            boolean result = true;
            for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                result = false;
            }
        }
            assertEquals(true, result);
        } catch (Exception e) {
            // Success
        }
    }
    
}
