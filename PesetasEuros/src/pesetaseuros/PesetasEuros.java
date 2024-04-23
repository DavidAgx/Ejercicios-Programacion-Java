package pesetaseuros;

import java.util.Scanner;

public class PesetasEuros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float resultadoEuro = 0;
        int opcionMenu = 0;
        int numeroCasos = 0;
        float cantidadEuros = 0;
        int cantidadPesetas = 0;
        float resultadoPesetas = 0;

        numeroCasos = sc.nextInt();

        for (int i = 0; i < numeroCasos; i++) {

            while (opcionMenu != 3) {

                System.out.println("1. Pasar de pesetas a euros");
                System.out.println("2. Pasar de euros a pesetas");
                System.out.println("3. Salir");
                opcionMenu = sc.nextInt();

                if (opcionMenu == 1) {
                    System.out.println("Introduzca cantidad: ");
                    cantidadPesetas = sc.nextInt();
                    resultadoPesetas = pasarAEuros(cantidadPesetas);
                    System.out.println("Son " + redondearNdecimales(resultadoPesetas, 2) + " euros");

                } else if (opcionMenu == 2) {
                    System.out.println("Introduzca cantidad: ");
                    cantidadEuros = sc.nextFloat();
                    resultadoEuro = pasarAPesetas(cantidadEuros);
                    System.out.println("Son " + (int) resultadoEuro + " pesetas");
                }
            }
            System.out.println("SIGUIENTE CASO");
            opcionMenu = 0;
        }

    }

    static float redondearNdecimales(float numero, int decimales) {
        float resultado;
        float numeroDecimales;
        numeroDecimales = (float) Math.pow(10, decimales);
        resultado = Math.round(numero * numeroDecimales) / numeroDecimales;
        return resultado;
    }

    static int pasarAPesetas(float euros) {
        float resultadoPesetas = 0;
        resultadoPesetas = Math.round((float) (euros * 166.386));
        return (int) resultadoPesetas;
    }

    static float pasarAEuros(int pesetas) {
        float resultadoEuros = 0;
        resultadoEuros = (float) ((pesetas / 166.386));

        return resultadoEuros;

    }

}
