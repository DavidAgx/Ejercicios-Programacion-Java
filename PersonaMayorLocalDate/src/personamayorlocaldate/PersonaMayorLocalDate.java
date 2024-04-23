package personamayorlocaldate;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class PersonaMayorLocalDate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casos, fechasIntroducidas = 0;
        String fechaIntroducida = " ";
        String dia = " ";
        String mes = " ";
        String anyo = " ";

        LocalDate menor = LocalDate.of(0001, 01, 01);

        casos = sc.nextInt();
        for (int i = 0; i < casos; i++) {
            fechasIntroducidas = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < fechasIntroducidas; j++) {
                fechaIntroducida = sc.next();

                anyo = fechaIntroducida.substring(0, 4);
                mes = fechaIntroducida.substring(5, 7);
                dia = fechaIntroducida.substring(8, 10);

                int anyoP = Integer.parseInt(anyo);
                int mesP = Integer.parseInt(mes);
                int diaP = Integer.parseInt(dia);

                LocalDate fecha = LocalDate.of(anyoP, mesP, diaP);

                if (fecha.isAfter(menor)) {
                    menor = fecha;
                }

            }
            System.out.println(menor);
            menor = LocalDate.of(0001, 01, 01);

        }
    }

}
