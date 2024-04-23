package desembalsevector;

import java.util.Scanner;

public class DesembalseVector {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leemos la distancia
        int distancia = sc.nextInt();
        int mayor;
        int resultado = 0;

        // Iniciamos el bucle while
        while (distancia != 0) {
            // Creamos un vector del tamaño de la distancia
            int[] altura = new int[distancia];

            // Leemos la altura de cada tramo
            for (int i = 0; i < distancia; i++) {
                altura[i] = sc.nextInt();
            }

            // Encontramos el muro más alto
            mayor = altura[distancia - 1];

            // Calculamos la cantidad de agua que se desborda para cada muro
            for (int i = 0; i < distancia; i++) {
                resultado = resultado + mayor - altura[i];
            }

            // Imprimimos el resultado
            System.out.println(resultado);

            // Reseteamos el resultado y leemos la siguiente entrada
            resultado = 0;
            distancia = sc.nextInt();
        }
    }
}
