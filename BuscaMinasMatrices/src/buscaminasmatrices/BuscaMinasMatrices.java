package buscaminasmatrices;

import java.util.Scanner;

public class BuscaMinasMatrices {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variables para almacenar la cantidad de casos y el número a introducir
        int casos = 0;
        int numeroAintroducir = 0;

        // Lectura de la cantidad de casos desde la entrada
        casos = sc.nextInt();

        // Bucle que se repite la cantidad de veces especificada por "casos"
        for (int i = 0; i < casos; i++) {

            // Creación de una nueva matriz de tamaño 8x8 para cada caso
            int[][] matriz = new int[8][8];

            // Bucle que recorre las filas de la matriz
            for (int f = 0; f < matriz.length; f++) {

                // Bucle que recorre las columnas de la matriz
                for (int c = 0; c < matriz[f].length; c++) {

                    // Lectura del número a introducir desde la entrada
                    numeroAintroducir = sc.nextInt();

                    // Verificación si el número es -1 (mina)
                    if (numeroAintroducir == -1) {
                        matriz[f][c] = -1;

                        // Bucle anidado para actualizar los valores de las celdas vecinas
                        for (int fil = f - 1; fil < (f + 2); fil++) {
                            for (int col = c - 1; col < (c + 2); col++) {

                                // Verificación de los límites de la matriz y si la celda no es una mina
                                if (fil >= 0 && fil < matriz.length && col >= 0 && col < matriz[f].length && matriz[fil][col] != -1) {
                                    matriz[fil][col] += 1;  // Incremento en 1 del valor de la celda vecina
                                }
                            }
                        }
                    }
                }
            }

            // Impresión de la matriz modificada en la consola
            for (int filas = 0; filas < matriz.length; filas++) {
                for (int columnas = 0; columnas < matriz[filas].length; columnas++) {
                    System.out.print(matriz[filas][columnas] + "\t");  // Imprime el valor de la celda seguido de un tabulador
                }
                System.out.println("");  // Salto de línea después de imprimir una fila completa
            }
            System.out.println("");  // Línea en blanco para separar los resultados de los casos de prueba
        }
    }
}
