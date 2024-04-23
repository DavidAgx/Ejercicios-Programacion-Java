package constantekaprekar;

import java.util.Scanner;

public class ConstanteKaprekar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        for (int i = 0; i < casos; i++) {
            int numero = sc.nextInt();
            int iteraciones = kaprekar(numero);
            System.out.println(iteraciones);
        }
    }

    public static int kaprekar(int num) {
        int iteraciones = 0;
        while (num != 6174 && num != 0) {
            int[] digitos = descomponer(num);
            int mayor = ordenarDesc(digitos);
            int menor = ordenarAsc(digitos);
            num = mayor - menor;
            iteraciones++;
        }
        return iteraciones;
    }

    public static int[] descomponer(int num) {
        int[] digitos = new int[4];
        for (int i = 3; i >= 0; i--) {
            digitos[i] = num % 10;
            num /= 10;
        }
        return digitos;
    }

    public static int ordenarDesc(int[] digitos) {
        int numero = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (digitos[i] < digitos[j]) {
                    int temporal = digitos[i];
                    digitos[i] = digitos[j];
                    digitos[j] = temporal;
                }
            }
            numero = numero * 10 + digitos[i];
        }
        return numero;
    }

    public static int ordenarAsc(int[] digitos) {
        int numero = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (digitos[i] > digitos[j]) {
                    int temp = digitos[i];
                    digitos[i] = digitos[j];
                    digitos[j] = temp;
                }
            }
            numero = numero * 10 + digitos[i];
        }
        return numero;
    }
}