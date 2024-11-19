package epd08_backtracking;

import java.util.Arrays;

public class SumaSubconjuntos {

    /*

    --------------------BACKTRACKING----------------------
        El algoritmo de backtracking sigue una estrategia de búsqueda en profundidad (Depth-First Search)
        para explorar las posibles soluciones.

        Cada paso consiste en probar una opción y, si esa opción no lleva a una solución,
        retrocede (back) y prueba con otra opción.
        Es eficiente en comparación con la búsqueda completa, ya que utiliza restricciones para evitar
        explorar caminos que no llevan a soluciones válidas.

        ETAPAS:
        - Inicialización: Se define una estructura de datos para representar las soluciones parciales.
        - Exploración: Se intenta añadir un item a la solución parcial.
        - Verificación: Se comprueba si la solución parcial es válida:
                Si es válida y es completa, se acepta como solución.
                Si es válida pero incompleta, se continúa explorando.
                Si no es válida, se descarta y se retrocede.
        - Retroceso: Si todas las opciones de un nivel son inválidas,
        se deshacen los cambios y se vuelve al nivel anterior para probar otras opciones.

        Ventajas:
        - Explora todas las soluciones posibles de manera eficiente.
        - Puede reducir significativamente el espacio de búsqueda al aplicar restricciones.

        Desventajas:
        - Alta complejidad en problemas grandes sin restricciones adecuadas.
        - El tiempo de ejecución en el peor caso sigue siendo exponencial.

     */


    public static boolean encontrarSubconjunto(int[] conjunto, int sumaObjetivo) {
        return encontrarSubconjuntoRec(conjunto, sumaObjetivo, 0, 0);
    }

    private static boolean encontrarSubconjuntoRec(int[] conjunto, int sumaObjetivo, int sumaActual, int index) {
        // Caso base: hemos encontrado la suma
        if (sumaActual == sumaObjetivo) {
            return true;
        }

        // Si excedemos la suma o llegamos al final del conjunto
        if (sumaActual > sumaObjetivo || index >= conjunto.length) {
            return false;
        }

        // Probar incluir el elemento actual
        if (encontrarSubconjuntoRec(conjunto, sumaObjetivo, sumaActual + conjunto[index], index + 1)) {
            System.out.println(conjunto[index]);
            return true;
        }

        // Probar excluir el elemento actual y continuar
        return encontrarSubconjuntoRec(conjunto, sumaObjetivo, sumaActual, index + 1);
    }

    public static void main(String[] args) {
        int[] conjunto = {3, 34, 4, 12, 5, 2};
        //int[] conjunto = {8, 34, 4, 12, 5, 2};
        int sumaObjetivo = 9;

        if (encontrarSubconjunto(conjunto, sumaObjetivo)) {
            System.out.println("Existe un subconjunto de números con los que obtenemos la suma objetivo.");
        } else {
            System.out.println("No Existe un subconjunto de números con los que obtenemos la suma objetivo.");
        }
    }
}



