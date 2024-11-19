package epd08_backtracking;

public class Laberinto {


    // Constantes para el tamaño del laberinto y los movimientos posibles
    private static final int TAM = 5; // Tamaño del laberinto (5x5)
    private static final int[][] MOVIMIENTOS = {
            {-1, 0}, // Movimiento hacia arriba
            {1, 0},  // Movimiento hacia abajo
            {0, -1}, // Movimiento hacia la izquierda
            {0, 1}   // Movimiento hacia la derecha
    };

    // Metodo que implementa el algoritmo de backtracking para encontrar un camino en el laberinto
    public static boolean laberinto_bt(int[][] laberinto, int filaEntrada, int colEntrada, int filaSalida, int colSalida) {
        System.out.println("Posición actual: (" + filaEntrada + ", " + colEntrada + ")");

        boolean exito = false;
        int m = 0; // Índice para iterar sobre los movimientos

        // Caso base: hemos llegado a la salida
        if (filaEntrada == filaSalida && colEntrada == colSalida) {
            laberinto[filaEntrada][colEntrada] = 9; // Marcar la salida
            imprimirLaberinto(laberinto);
            exito = true; // Camino encontrado
        } else {
            // Iterar mientras haya movimientos posibles y no se haya encontrado un camino
            while (m < MOVIMIENTOS.length && !exito) {
                int nuevaFila = filaEntrada + MOVIMIENTOS[m][0];
                int nuevaCol = colEntrada + MOVIMIENTOS[m][1];
                System.out.println("Inspeccionando nueva posición: (" + nuevaFila + ", " + nuevaCol + ")");

                // Verificar si la nueva posición es válida, no ha sido usada y no es un obstáculo
                if (!valida(nuevaFila, nuevaCol)) {
                    System.out.println("Posición (" + nuevaFila + ", " + nuevaCol + ") fuera de los límites de la matriz.");
                } else if (usada(nuevaFila, nuevaCol, laberinto)) {
                    System.out.println("Posición (" + nuevaFila + ", " + nuevaCol + ") ya ha sido utilizada.");
                } else if (obstaculo(nuevaFila, nuevaCol, laberinto)) {
                    System.out.println("Posición (" + nuevaFila + ", " + nuevaCol + ") es un obstáculo.");
                } else {
                    // Si es válida, marcar la posición y explorar
                    marcar(filaEntrada, colEntrada, laberinto);
                    exito = laberinto_bt(laberinto, nuevaFila, nuevaCol, filaSalida, colSalida);
                    if (!exito) {
                        System.out.println("No se puede avanzar desde la posición (" + nuevaFila + ", " + nuevaCol + "), retrocediendo.");
                        desmarcar(nuevaFila, nuevaCol, laberinto); // Si no tuvo éxito, desmarcar la posición
                    }
                }
                m++; // Probar el siguiente movimiento
            }
            // Si no es la posición de salida y no se encontró camino, desmarcar la posición actual
            if (!exito) {
                desmarcar(filaEntrada, colEntrada, laberinto);
            }
        }
        return exito; // Retornar si se encontró un camino o no
    }

    // Metodo para verificar si una posición está dentro de los límites del laberinto
    public static boolean valida(int fila, int col) {
        return (0 <= fila && fila < TAM && 0 <= col && col < TAM);
    }

    // Metodo para verificar si una posición ya ha sido visitada
    public static boolean usada(int fila, int col, int[][] laberinto) {
        return (laberinto[fila][col] == 9); // 9 indica que la casilla ya fue visitada
    }

    // Metodo para verificar si una posición es un obstáculo
    public static boolean obstaculo(int fila, int col, int[][] laberinto) {
        return (laberinto[fila][col] == 1); // 1 indica un obstáculo
    }

    // Metodo para marcar una posición como visitada
    public static void marcar(int fila, int col, int[][] laberinto) {
        laberinto[fila][col] = 9; // Marcar la casilla como visitada con un 9
    }

    // Metodo para desmarcar una posición (volverla a su estado original)
    public static void desmarcar(int fila, int col, int[][] laberinto) {
        laberinto[fila][col] = 0; // Volver la casilla a su estado original de transitable
    }

    // Metodo para imprimir el laberinto con el camino recorrido
    public static void imprimirLaberinto(int[][] laberinto) {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if (laberinto[i][j] == 9) {
                    System.out.print("🟩"); // Imprimir verde para las casillas que forman el camino
                } else {
                    System.out.print((laberinto[i][j] == 1) ? "🟥" : "⬜️"); // Imprimir el valor original de la casilla
                }
            }
            System.out.println();
        }
        System.out.println(); // Línea en blanco para separar diferentes resultados
    }


    // Metodo principal para probar el algoritmo
    public static void main(String[] args) {
        int[][] laberinto = {
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 0, 1, 0}
        };
        System.out.println(" --------- 🔲 Laberinto 🔲 ----------- \n");
        imprimirLaberinto(laberinto);
        int filaEntrada = 0, colEntrada = 0; // Posición de inicio
        int filaSalida = 4, colSalida = 0;   // Posición de salida

        if (laberinto_bt(laberinto, filaEntrada, colEntrada, filaSalida, colSalida)) {
            System.out.println("Hemos salido. 🏆");
        } else {
            System.out.println("\n ☠️☠️No hemos podido salir. ☠️☠️");
        }
    }
}


