package epd07_divideYvenceras;

public class Maximo {


    /* ALGORITMOS DE DIVIDE Y VENCERÁS
    Divide y vencerás es una técnica de resolución para algorítmos que se basa en resolver un
    problema dividiéndolo en subproblemas más pequeños, resolviendo estos subproblemas de forma recursiva
    y combinando sus soluciones para obtener la solución al problema original.
    Este enfoque es especialmente útil para problemas grandes y complejos,
    ya que reduce su tamaño de manera sistemática, facilitando la solución

    ETAPAS:
    - DIVISIÓN:
    El problema original se divide en subproblemas más pequeños de forma recursiva
    hasta que los subproblemas se simplifican lo suficiente para ser resueltos directamente.
    - RESOLUCIÓN O CONQUISTA:
    Los subproblemas divididos se resuelven de manera recursiva.
    Si el subproblema es lo suficientemente pequeño, se resuelve directamente (caso base).
    - COMBINACIÓN:
    Las soluciones de los subproblemas se combinan para formar la solución al problema original.

    CARACTERÍSTICAS :
    - Recursividad: La mayoría de los algoritmos de divide y vencerás utilizan recursión para dividir el problema
     en subproblemas más pequeños.
    - Eficiencia: Estos algoritmos suelen ser más eficientes que otros métodos, especialmente en problemas
    donde la reducción sistemática del tamaño del problema ayuda a optimizar el tiempo de ejecución.
    - Paralelismo: Los subproblemas divididos pueden ser resueltos de forma independiente,
     lo que permite paralelizar el procesamiento y aprovechar sistemas de múltiples núcleos.

    Ejemplos comunes de algoritmos de divide y vencerás:
    - Algoritmo de Quicksort: Divide un array en dos subarrays en torno a un pivote,
     ordena cada subarray recursivamente y combina los resultados.
    - Algoritmo de Mergesort: Divide el array en mitades, ordena cada mitad de forma recursiva y
     luego las combina para formar un array ordenado.
    - Algoritmo de búsqueda binaria: Divide el espacio de búsqueda a la mitad en cada paso,
     lo que reduce significativamente el número de elementos que se deben verificar.

    Beneficios:
    - Reducción de la complejidad: Algunos problemas complejos se resuelven más rápidamente al dividirlos en subproblemas más pequeños.
    - Claridad en la implementación: La recursividad permite expresar soluciones complejas de forma más simple y comprensible.

    Desventajas:
    - Coste de la recursión: El uso de recursividad puede implicar un coste de memoria y tiempo adicional
    debido al uso de la pila de llamadas.
    - Sobrecarga de combinación: Combinar las soluciones de los subproblemas puede ser complicado y costoso en algunos casos,
     como en la mezcla de subarrays en Mergesort.
    */

    // Metodo principal que inicia la búsqueda del número máximo
    //Es el punto de entrada que llama al metodo recursivo con los índices inicial y final del array.
    public static int encontrarMaximo(int[] array) {
        return encontrarMaximo(array, 0, array.length - 1);
    }

    // Metodo recursivo que implementa la estrategia de divide y vencerás
    /* - Caso base: Si el array tiene un solo elemento (inicio == fin), se devuelve ese elemento.
        - División: Divide el array en dos mitades y llama recursivamente a sí mismo para encontrar el máximo en cada mitad.
        - Conquista: Compara los máximos de las mitades izquierda y derecha y devuelve el mayor.

    Metodo Math.max(): Utilizado para encontrar el máximo entre dos valores.
    */
    private static int encontrarMaximo(int[] array, int inicio, int fin) {
        // Caso base: si la sublista tiene un solo elemento, retorna ese elemento
        if (inicio == fin) {
            return array[inicio];
        }

        // Encuentra el punto medio para dividir el array
        int medio = (inicio + fin) / 2;

        // Llama recursivamente a la función para encontrar el máximo en la mitad izquierda
        int maxIzquierda = encontrarMaximo(array, inicio, medio);

        // Llama recursivamente a la función para encontrar el máximo en la mitad derecha
        int maxDerecha = encontrarMaximo(array, medio + 1, fin);

        // Retorna el mayor valor entre los dos máximos
        return Math.max(maxIzquierda, maxDerecha);
    }

    public static void main(String[] args) {
        // Ejemplo de uso: array de enteros
        int[] array = {3, 5, 7, 2, 8, 1, 4, 10, 6};

        // Llama al metodo para encontrar el máximo y lo imprime
        int maximo = encontrarMaximo(array);
        System.out.println("El valor máximo en el array es: " + maximo);
    }
}


