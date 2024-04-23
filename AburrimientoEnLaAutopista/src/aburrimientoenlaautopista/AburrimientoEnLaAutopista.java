package aburrimientoenlaautopista;

import java.util.Scanner;

public class AburrimientoEnLaAutopista {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int casos = sc.nextInt();

        String miMatricula; 
        String matriculaIntroducida;
        String numero1, numero2, letras1, letras2;
        int viejos;
        int nuevos;

        for (int i = 0; i < casos; i++) {

            miMatricula = sc.next();
            numero1 = miMatricula.substring(0, 4);
            letras1 = miMatricula.substring(4, 7);

            viejos = 0;
            nuevos = 0;
            
            matriculaIntroducida = sc.next();

            while (!(matriculaIntroducida.equals("0"))) {

                numero2 = matriculaIntroducida.substring(0, 4);
                letras2 = matriculaIntroducida.substring(4, 7);

                if (letras1.equals(letras2)) {
                    if (numero2.compareTo(numero1) < 0) {
                        viejos++;
                    } else {
                        nuevos++;
                    }
                } else {
                    if (letras1.compareTo(letras2) < 0) {
                        nuevos++;
                    } else {
                        viejos++;
                    }
                }
                matriculaIntroducida = sc.next();
            }
            System.out.println(viejos + " " + nuevos);
        }

    }

}
