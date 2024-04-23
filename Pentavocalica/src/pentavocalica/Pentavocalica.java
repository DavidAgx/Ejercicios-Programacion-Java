package pentavocalica;

import java.util.Scanner;

public class Pentavocalica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int casos = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < casos; i++) {
           String palabra = sc.nextLine();
            if (palabra.contains("a") && palabra.contains("e") && palabra.contains("i") && palabra.contains("o") && palabra.contains("u")) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
           
           
        }
        
    }
    
}
