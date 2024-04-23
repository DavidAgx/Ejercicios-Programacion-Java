package spaceinvaders;

import java.util.Scanner;

public class SpaceInvaders {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Lee el número de casos de prueba
        int casos = sc.nextInt(); 

        for (int k = 0; k < casos; k++) {
            // Lee el número de puntuaciones
            int totalPuntuaciones = sc.nextInt();
            // Crea una matriz para almacenar los nombres de las puntuaciones
            char[][] nombres = new char[3][totalPuntuaciones]; 

            // Lee los nombres de las puntuaciones y los almacena en la matriz
            for (int i = 0; i < totalPuntuaciones; i++) {
                String puntuacion = sc.next();
                for (int j = 0; j < 3; j++) {
                    nombres[j][i] = puntuacion.charAt(j);
                }
            }

            // Imprime el mensaje que se puede leer al leer las letras de arriba hacia abajo
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < totalPuntuaciones; j++) {
                    System.out.print(nombres[i][j]);
                }
            }
            System.out.println();
        }
    }
}
