package epd06_voraces;

public class KnapsackProblem {

    /*Llama a realizarExperimentos para ejecutar dos pruebas con diferentes configuraciones de beneficios y pesos.
    Luego, realiza una prueba adicional con un conjunto de datos distinto para reforzar el entendimiento del problema.*/
    public static void main(String[] args) throws Exception {
        // Ejecución de experimentos para ilustrar el problema de la mochila
        realizarExperimentos();

        // Prueba adicional con diferentes beneficios y pesos
        int[] beneficios = {8, 5, 3, 2, 1};
        float[] pesos = {5, 2, 2, 1, 1};
        /*int[] beneficios = {11, 6, 6};
        float[] pesos = {5, 3, 2};*/
        float capacidad = 7.0f;
        float[] proporciones = new float[beneficios.length];

        System.out.println("\nPrueba adicional:");
        System.out.println("Beneficio obtenido: " + calcularMochilaEntera(beneficios, pesos, capacidad, proporciones));
        mostrarVector(proporciones, "Proporciones de cada objeto en la mochila");
    }

    //realizarExperimentos:
    //Configura dos casos distintos de beneficios y pesos.
    //Llama a calcularMochilaEntera para cada caso y muestra el beneficio obtenido, junto con las proporciones de los objetos que se incluyen en la mochila.
    //Esto permite observar cómo cambian los resultados en función de diferentes ordenaciones de beneficios y pesos.
    public static void realizarExperimentos() {
        int[] beneficios = {8, 5, 3, 2, 1};
        float[] pesos = {5, 1, 2, 1, 2};
        float capacidad = 7.0f;
        float[] proporciones = new float[beneficios.length];

        System.out.println("Experimento 1: Ordenado por beneficio");
        System.out.println("\tBeneficio obtenido: " + calcularMochilaEntera(beneficios, pesos, capacidad, proporciones));
        mostrarVector(proporciones, "\tProporciones de cada objeto");

        beneficios = new int[]{8, 1, 3, 5, 2};
        pesos = new float[]{5, 2, 2, 1, 1};
        proporciones = new float[beneficios.length];

        System.out.println("Experimento 2: Ordenado por peso");
        System.out.println("\tBeneficio obtenido: " + calcularMochilaEntera(beneficios, pesos, capacidad, proporciones));
        mostrarVector(proporciones, "\tProporciones de cada objeto");
    }

    // Metodo voraz para resolver el problema de la mochila (solo objetos completos)
    public static int calcularMochilaEntera(int[] beneficios, float[] pesos, float capacidad, float[] proporciones) {
        float pesoActual = 0.0f;
        int beneficioTotal = 0;

        /*Este metodo añade objetos completos a la mochila mientras la capacidad lo permita.
                Actualiza beneficioTotal con el beneficio de cada objeto añadido y pesoActual con el peso acumulado.
        El vector proporciones se utiliza para indicar si un objeto fue añadido (1.0) o no (0.0) en esta versión.*/

        // Inicializamos el vector de proporciones en 0
        for (int i = 0; i < beneficios.length; i++) {
            proporciones[i] = 0;
        }

        // Iteramos sobre cada objeto, agregándolo a la mochila si es posible
        for (int i = 0; i < beneficios.length && pesoActual < capacidad; i++) {
            if (pesoActual + pesos[i] <= capacidad) {
                // Si el objeto cabe en la mochila, lo tomamos completo
                proporciones[i] = 1.0f;
                pesoActual += pesos[i];
                beneficioTotal += beneficios[i];
            } // Si no cabe, dejamos de añadir más objetos
        }

        return beneficioTotal;
    }

    // Metodo para mostrar el contenido de un vector
    /*Imprime el contenido del vector proporciones para
     mostrar qué objetos se han añadido a la mochila y en qué proporción.
     */
    public static void mostrarVector(float[] vector, String mensaje) {
        System.out.println("\n" + mensaje + ":");
        for (float valor : vector) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}
