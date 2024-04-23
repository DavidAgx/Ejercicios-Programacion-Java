package buscandoelnivelvectores;

import java.util.Scanner;

public class BuscandoElNivelVectores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cantNiveles = sc.nextInt();

        while (cantNiveles != 0) {

            int[] vector = new int[cantNiveles];
            for (int i = 0; i < vector.length; i++) {
                vector[i] = sc.nextInt();
            }
            sc.nextLine();
            int consultas = sc.nextInt();

            int ultimoNivel;
            int siguienteNivel;
            int sumaNiveles = 0;

            if (consultas == 0) {
                System.out.println("---");
            }

            for (int i = 0; i < consultas; i++) {

                ultimoNivel = sc.nextInt();
                siguienteNivel = sc.nextInt();

                if (ultimoNivel == siguienteNivel - 1) {
                    System.out.println("0");
                } else {
                    if (ultimoNivel < siguienteNivel) {
                        for (int k = ultimoNivel; k < siguienteNivel - 1; k++) {
                            sumaNiveles = sumaNiveles + vector[k];
                        }
                        System.out.println(sumaNiveles);
                    } else {
                        if (ultimoNivel > siguienteNivel) {
                            for (int l = ultimoNivel; l >= siguienteNivel; l--) {
                                sumaNiveles = sumaNiveles + vector[l - 1];
                            }
                            System.out.println("-" + sumaNiveles);
                        }

                    }
                }
                sumaNiveles = 0;
            }
            System.out.println("---");
            cantNiveles = sc.nextInt();
        }
    }
}
