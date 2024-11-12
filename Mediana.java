package epd07_divideYvenceras;

public class Mediana {

    /*
    Caso Base 1:
    Si los vectores tienen un solo elemento cada uno, la mediana es el promedio de esos dos elementos.
    Calcula las medianas medianaX y medianaY de los vectores X y Y.

    Caso Base 2:
    Si medianaX es igual a medianaY, devuelve medianaX como la mediana de ambos vectores.

    Caso general:
    Si medianaX > medianaY, la mediana de la unión ordenada debe estar en la segunda mitad de Y o en la primera mitad de X.
    Si medianaX < medianaY, la mediana de la unión ordenada debe estar en la segunda mitad de X o en la primera mitad de Y.

    Recursividad:
    Llama recursivamente a la función con las mitades correspondientes de X y Y.

    COMPLEJIDAD:
    La complejidad del algoritmo es 𝑂(log n) ya que divide los vectores de tamaño n a la mitad en cada llamada recursiva.

    La implementación asume que los vectores X y Y tienen el mismo tamaño y están ordenados de forma creciente.

    Si los vectores pueden tener diferente tamaño o no están ordenados, se necesitaría un preprocesamiento adicional.
    */

    // Metodo auxiliar para obtener un subarray
    private static int[] subArray(int[] array, int inicio, int fin) {
        int[] resultado = new int[fin - inicio];
        System.arraycopy(array, inicio, resultado, 0, fin - inicio);//"clone" del array
        return resultado;
    }

    public static double encontrarMediana(int[] X, int[] Y) {
        int n = X.length;
        if (n == 1) {
            // Caso base 1: vectores de un solo elemento
            return (X[0] + Y[0]) / 2.0;
        }

        // Encuentra las medianas de X e Y
        double medianaX = (n % 2 == 0) ? (X[n / 2] + X[(n / 2) - 1]) / 2.0 : X[n / 2];
        double medianaY = (n % 2 == 0) ? (Y[n / 2] + Y[(n / 2) - 1]) / 2.0 : Y[n / 2];

        // Caso base 2: medianas iguales
        if (medianaX == medianaY) {
            return medianaX;
        }

        // Caso general
        if (medianaX > medianaY) {
            // La mediana final está en la segunda mitad de Y y en la primera mitad de X
            return encontrarMediana(subArray(X, 0, n / 2 ), subArray(Y, n / 2, n ));
        } else {
            // La mediana final está en la segunda mitad de X y en la primera mitad de Y
            return encontrarMediana(subArray(X, n / 2, n), subArray(Y, 0, n / 2 + 1));
        }
    }



    public static void main(String[] args) {
        int[] X = {1, 3, 8, 9, 15};
        int[] Y = {7, 11, 18, 19, 21};

        double mediana = encontrarMediana(X, Y);
        System.out.println("La mediana de los dos vectores es: " + mediana);
    }
}
