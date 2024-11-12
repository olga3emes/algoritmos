package epd07_divideYvenceras;

import java.util.Arrays;

public class QuickSort {

    public static void ordenar(int[] array) {
        QuickSort.ordenar(array, 0, array.length - 1);
    }

    private static void ordenar(int[] array, int bajo, int alto) {
        // Verifica que la parte del array a ordenar tenga al menos dos elementos
        if (bajo < alto) {
            // Particiona el array y obtiene el índice del pivote
            int medio = QuickSort.particionar(array, bajo, alto);
            // Ordena recursivamente la parte izquierda del pivote
            QuickSort.ordenar(array, bajo, medio - 1);
            // Ordena recursivamente la parte derecha del pivote
            QuickSort.ordenar(array, medio + 1, alto);
        }
    }

    /**
     * Particiona el array alrededor de un pivote. Usado por quicksort.
     *
     * @param array el array de enteros a ordenar
     * @param bajo el primer índice de la sublista
     * @param alto el último índice de la sublista
     *
     * @return el índice del elemento medio (posición final del pivote)
     */
    private static int particionar(int[] array, int bajo, int alto) {
        int pivote = array[alto]; // Elige el último elemento como pivote
        int izquierda = bajo;
        int derecha = alto;

        // Recorre el array hasta que los índices se crucen
        while (izquierda < derecha) {
            // Mueve la izquierda mientras los elementos sean menores que el pivote
            while (izquierda < derecha && array[izquierda] < pivote) {
                izquierda++;
            }
            // Mueve la derecha mientras los elementos sean mayores o iguales al pivote
            while (izquierda < derecha && array[derecha] >= pivote) {
                derecha--;
            }
            // Intercambia los elementos si los índices no se han cruzado
            if (izquierda < derecha) {
                int aux = array[izquierda];
                array[izquierda] = array[derecha];
                array[derecha] = aux;
            }
        }
        // Coloca el pivote en su posición final
        array[alto] = array[izquierda];
        array[izquierda] = pivote;

        return izquierda; // Devuelve el índice del pivote
    }

    public static void main(String[] args) {
        // Array de prueba con valores mixtos
        long t= System.nanoTime();
        //int[] array = new int[]{12,-5,23,-16,45,8,-34,19,27,-2,39,-11,6,18,-47,21,13,-25,33,-7,0,4,-38,29,50,-20,11,31,-9,22,-14,35,-1,17,26,-33,3,-12,41,-27,7,-8,15,-4,32,-19,9,28,-6,44};
        //int[] array = new int[]{-47,-38,-34,-33,-27,-25,-20,-19,-16,-14,-12,-11,-9,-8,-7,-6,-5,-4,-2,-1,0,3,4,6,7,8,9,11,12,13,15,17,18,19,21,22,23,26,27,28,29,31,32,33,35,39,41,44,45,50};
        int[] array = new int[]{50,45,44,41,39,35,33,32,31,29,28,27,26,23,22,21,19,18,17,15,13,12,11,9,8,7,6,4,3,0,-1,-2,-4,-5,-6,-7,-8,-9,-11,-12,-14,-16,-19,-20,-25,-27,-33,-34,-38,-47};
        // Llama al metodo para ordenar el array
        QuickSort.ordenar(array);
        long t2= System.nanoTime();
        // Imprime el array ordenado
        System.out.println(Arrays.toString(array) +"Tiempo: "+(t2-t));
    }
}
