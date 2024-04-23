package calambur;

import java.util.Scanner;

public class Calambur {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        sc.nextLine(); // consumir salto de línea después del entero

        for (int i = 0; i < casos; i++) {
            String linea1 = sc.nextLine();
            String linea2 = sc.nextLine();

            if (!esCalambur(linea1, linea2)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean esCalambur(String frase1, String frase2) {
        // Eliminar todos los caracteres que no sean letras
        String soloLetras1 = eliminarNoLetras(frase1);
        String soloLetras2 = eliminarNoLetras(frase2);
        boolean resultado = true;

        if (soloLetras1.length() != soloLetras2.length()) {
            resultado = false;
        }

        for (int i = 0; i < soloLetras1.length(); i++) {
            char letra = soloLetras1.charAt(i);

            // Verificar si la letra se repite la misma cantidad de veces en ambas frases
            if (contarLetras(soloLetras1, letra) != contarLetras(soloLetras2, letra)) {
                resultado = false;
            }
        }

        return resultado;
    }

    public static String eliminarNoLetras(String cadena) {
        String cadenaFinal = "";

        if (cadena.length() == 0) {
            throw new IllegalArgumentException();
        }
        char letra = ' ';
        for (int i = 0; i < cadena.length(); i++) {
            letra = cadena.charAt(i);
            if (letra == ' ' || letra == '.' || letra == ',') {
                cadenaFinal = cadenaFinal + "";

            } else {
                cadenaFinal += letra;
            }
        }
        return cadenaFinal;
    }

    public static int contarLetras(String frase, char letra) {
        int contador = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == letra) {
                contador++;
            }
        }

        return contador;
    }
}
