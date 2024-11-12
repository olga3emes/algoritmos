package epd07_divideYvenceras;

import java.util.Arrays;

public class MergeSort {

    public static void ordenar(int[] array) {
        if (array.length > 1) {
            int medio = array.length / 2;

            // Divide el array en dos mitades
            int[] izquierda = Arrays.copyOfRange(array, 0, medio);
            int[] derecha = Arrays.copyOfRange(array, medio, array.length);

            // Ordena cada mitad recursivamente
            ordenar(izquierda);
            ordenar(derecha);

            // Combina las dos mitades ordenadas
            combinar(array, izquierda, derecha);
        }
    }

    private static void combinar(int[] array, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        // Compara elementos y combina en orden
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                array[k++] = izquierda[i++];
            } else {
                array[k++] = derecha[j++];
            }
        }

        // Copia los elementos restantes de la mitad izquierda (si los hay)
        while (i < izquierda.length) {
            array[k++] = izquierda[i++];
        }

        // Copia los elementos restantes de la mitad derecha (si los hay)
        while (j < derecha.length) {
            array[k++] = derecha[j++];
        }
    }

    public static void main(String[] args) {
        // Array de prueba con valores mixtos
        long t1=System.nanoTime();
        //int[] array = new int[]{4, 3, 2, 1, 5, -6, 8, 7, 0, 0};
        //int[] array = new int[]{-6,0,0,1,2,3,4,5,7,8};
        int[] array = new int[]{8,7,5,4,3,2,1,0,0,-6};

        // Llama al metodo para ordenar el array
        MergeSort.ordenar(array);
        long t2=System.nanoTime();
        // Imprime el array ordenado
        System.out.println(Arrays.toString(array) + "Tiempo: "+ (t2-t1));
    }
}
