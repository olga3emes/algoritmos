package epd06_voraces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CambioMoneda {

    /* Algoritmos Voraces o Greedy Algorithm
    En general, los algoritmos voraces siguen este proceso:

    - Inicialización: Preparan un conjunto vacío o una estructura inicial para comenzar a construir la solución.
    - Selección del Candidato: En cada etapa, el algoritmo selecciona el mejor candidato según la función de selección.
    - Comprobación Prometedora: Verifica si el candidato seleccionado permite continuar construyendo una solución viable.
    - Incluir el Candidato: Si el candidato es prometedor, se añade a la solución. En caso contrario, se descarta.
    - Comprobación de la Solución: Verifica si el conjunto actual de candidatos constituye una solución completa. Si es así, se detiene el algoritmo.

    A tener en cuenta:
    Óptimos Locales vs. Óptimos Globales:
    Los algoritmos voraces solo consideran el óptimo local en cada paso, lo que no siempre lleva al óptimo global.
    No todos los problemas pueden resolverse vorazmente: Solo ciertos problemas de optimización permiten soluciones óptimas
    a través de esta estrategia (ej., el problema de la mochila fraccionada y el problema del cambio de monedas bajo ciertos sistemas monetarios).
    Esta eficiencia y simplicidad hace que los algoritmos voraces sean atractivos,
    pero deben aplicarse en problemas adecuados para obtener soluciones óptimas.

*/

    // Metodo voraz en el problema de cambio de moneda
    public static List<Integer> calcularCambio(int[] monedas, int cantidad) {
        List<Integer> resultado = new ArrayList<>();
        // Ordenar las monedas en orden descendente (mayor a menor)
        Arrays.sort(monedas);
        for (int i = monedas.length - 1; i >= 0; i--) {
            // Mientras la moneda actual puede ser usada, la añadimos al resultado
            while (cantidad >= monedas[i]) {
                cantidad -= monedas[i];
                resultado.add(monedas[i]);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] monedas = {1, 2, 5, 10}; // Denominaciones de las monedas
        int cantidad = 48; // Cantidad de cambio deseado

        List<Integer> cambio = calcularCambio(monedas, cantidad);
        System.out.println("Cambio óptimo en monedas: " + cambio);
    }
}
