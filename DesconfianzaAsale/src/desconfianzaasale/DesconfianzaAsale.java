
package desconfianzaasale;

import java.util.Scanner;

public class DesconfianzaAsale {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String palabra1, palabra2;
        boolean asale = false;

        while (sc.hasNext()) {
            palabra1 = sc.next();
            palabra2 = sc.next();

            if (palabra1.contains("ch") || palabra2.contains("ch") || palabra1.contains("ll") || palabra2.contains("ll")) {
                asale = true;
            }

            if (palabra1.compareTo(palabra2) < 0 && asale) {
                System.out.println(palabra2);
                asale = false;

            } else if (palabra2.compareTo(palabra1) < 0) {
                System.out.println(palabra1);

            }
        }
    }

}
