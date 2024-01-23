/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

/**
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class BacktrackingImpl implements Backtracking {

    private int[] bestSolution;
    private int maxProfit;

    /**
     * Solucion recursiva al problema de la mochila.
     *
     * <p>
     * <strong>Precondiciones:</strong> {W>0 ∧(∀ i: 0 ≤ w[i] ∧ 0 ≤ p[i])}
     * </p>
     * <p>
     * <strong>Postcondiciones:</strong> {result.length > W}
     * </p>
     *
     * <p>
     * <strong>Análisis de Casos:</strong>
     * </p>
     * a. El mejor caso ocurre cuando los elementos más valiosos con menor peso 
     * estén al principio, el algoritmo podría explorar solo algunas ramas antes
     * de encontrar la solución óptima. 
     * </p>
     *
     * <p>
     * b. El peor caso ocurre cuando la capacidad de la mochila es lo 
     * suficientemente grande como para permitir todas las combinaciones posible.
     * </p>
     * 
     * <strong>Proof:</strong>
     * </p>
     * Para hacer la verificacion del programa entre los diferentes casos
     * (precondicion, recursive, postcondicion, smaller), lo hemos hecho de la
     * siguiente forma:
     * <p>
     * a. Todos los estados de la precondicion estan cubiertos.
     * </p>
     * <p>
     * b. Los valores de los parametros de la llamada recursiva cumplen con la
     * precondicon especificada.
     * </p>
     * <p>
     * c. Cuando llama al programa se satisface la postcondicion.
     * </p>
     * <p>
     * d. En cada llamada recursiva, el número de indices del array disminuye .
     * </p>
     * <p>
     * <strong>Complejidad:</strong> O(2^n), donde n es el número de elementos en la mochila.
     * </p>
     * Dado que cada nivel del árbol representa un movimiento de busqueda, y cada nodo tiene
     * dos hijos que corresponden a  las dos llamadas recursivas en cada paso, el algoritmo
     * sigue una estructura de árbol binario en sus llamadas recursivas. 
     * 
     * @param W pes màxim de la motxilla, >0
     * @param w conjunt de pesos de cada element, cada w[i] > 0
     * @param p conjunt del profit de cada element, cada p[i] > 0
     * @return selecció més òptima
     */
    @Override
    public int[] knapSack(int W, int[] w, int[] p) {
        // Inicializar variables de la mejor solución y beneficio máximo
        bestSolution = new int[w.length];
        maxProfit = Integer.MIN_VALUE;

        // Llamar a la función recursiva para encontrar la mejor solución
        knapSackUtil(W, w, p, 0, new int[w.length], 0, 0);

        // Devolver la mejor solución encontrada
        return bestSolution;
    }

    /**
     * Función recursiva para explorar todas las posibles combinaciones de elementos en la mochila.
     *
     * @param W              Capacidad total de la mochila.
     * @param w              Arreglo de pesos de los elementos.
     * @param p              Arreglo de beneficios de los elementos.
     * @param currentWeight  Peso acumulado en la solución parcial actual.
     * @param currentProfit  Beneficio acumulado en la solución parcial actual.
     * @param index          Índice del elemento actual.
     * @param solution       Arreglo binario que representa la solución parcial actual.
     * @param bestSolution   Arreglo binario que representa la mejor solución encontrada.
     * @param maxProfit      Beneficio máximo encontrado hasta el momento.
     */
    private void knapSackUtil(int W, int[] w, int[] p, int currentWeight, int[] currentSolution, int index, int currentProfit) {
        // Caso base: si se han considerado todos los elementos
        if (index == w.length) {
            // Si la solución actual es mejor que la mejor solución encontrada hasta el momento, actualizar la mejor solución
            if (currentProfit > maxProfit && currentWeight <= W) {
                maxProfit = currentProfit;
                System.arraycopy(currentSolution, 0, bestSolution, 0, currentSolution.length);
            }
            return;
        }

        // Caso 1: incluir el elemento actual y llamar a la función recursiva para explorar las soluciones restantes
        if (currentWeight + w[index] <= W) {
            currentSolution[index] = 1;
            knapSackUtil(W, w, p, currentWeight + w[index], currentSolution, index + 1, currentProfit + p[index]);
        }

        // Caso 2: excluir el elemento actual y llamar a la función recursiva para explorar las soluciones restantes
        currentSolution[index] = 0;
        knapSackUtil(W, w, p, currentWeight, currentSolution, index + 1, currentProfit);
    }
    
    public int[] knapSackIterative(int W, int[] w, int[] p) {
        int n = w.length;
        int[][] dp = new int[n + 1][W + 1];

        // Llenar la matriz dp
        for (int i = 1; i <= n; i++) {
            for (int weight = 1; weight <= W; weight++) {
                if (w[i - 1] <= weight) {
                    dp[i][weight] = Math.max(p[i - 1] + dp[i - 1][weight - w[i - 1]], dp[i - 1][weight]);
                } else {
                    dp[i][weight] = dp[i - 1][weight];
                }
            }
        }
        
        int[] result = new int[n];
        int i = n, weight = W;
        while(i > 0 && weight > 0){
            if(dp[i][weight] != dp[i-1][weight]){
                result[i-1]=1;
                weight-=w[i-1];
            }
            i--;
        }
       
        // Devolver el máximo beneficio que se puede obtener con una mochila de capacidad W
        return result;
    }
}
