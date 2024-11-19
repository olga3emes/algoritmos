package epd08_backtracking;

public class NReinas {


    private static final int N = 8; // Tamaño del tablero (NxN)

    public static void resolver() {
        int[] tablero = new int[N]; // Vector que representa la posición de las reinas en cada fila
        resolverReinas(tablero, 0); // Iniciar la resolución desde la fila 0
    }

    // Metodo recursivo para colocar las reinas en el tablero
    private static void resolverReinas(int[] tablero, int fila) {
        // Caso base: si llegamos a la fila N, se ha encontrado una solución
        if (fila == N) {
            imprimirSolucion(tablero); // Imprimir la solución encontrada
            return; // Volver al nivel anterior para buscar otras soluciones
        }

        // Intentar colocar una reina en cada columna de la fila actual
        for (int columna = 0; columna < N; columna++) {
            // Verificar si colocar la reina en (fila, columna) es válido
            if (esValido(tablero, fila, columna)) {
                tablero[fila] = columna; // Colocar la reina en la columna actual
                resolverReinas(tablero, fila + 1); // Llamada recursiva para colocar la siguiente reina
            }
        }
    }

    // Función para verificar si una posición es válida para colocar una reina
    private static boolean esValido(int[] tablero, int fila, int columna) {
        // Verificar que la nueva reina no esté en conflicto con las reinas ya colocadas
        for (int i = 0; i < fila; i++) {
            // Verificar si hay otra reina en la misma columna o en la misma diagonal
            if (tablero[i] == columna || Math.abs(tablero[i] - columna) == Math.abs(i - fila)) {
                return false; // Conflicto encontrado, la posición no es válida
            }
        }
        return true; // No hay conflictos, la posición es válida
    }

    // Metodo para imprimir la solución en el tablero
    private static void imprimirSolucion(int[] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Imprimir '👑' si hay una reina en (i, j), de lo contrario imprimir '⬜️'
                if (tablero[i] == j) {
                    System.out.print("👑");
                } else {
                    System.out.print("⬜️");
                }
            }
            System.out.println(); // Nueva línea para la siguiente fila
        }
        System.out.println(); // Línea en blanco entre soluciones
    }

    // Metodo principal para ejecutar el programa
    public static void main(String[] args) {
        resolver(); // Llamada para comenzar a resolver el problema
    }
}




