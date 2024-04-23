package cuadradomagico;

import java.util.Scanner;

public class CuadradoMagico {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            //leemos la dimension y el numero desde el que empezamos
            int dimension = sc.nextInt();
            int primerNumero = sc.nextInt();
            //inicia un bucle que se ejecuta mientras la dimensión y el primer número sean diferentes de cero
            while (dimension != 0 && primerNumero != 0) {
                //construye el cuadrado mágico y devuelve una matriz de enteros que representa el cuadrado mágico
                int[][] cuadradoMagico = construirCuadradoMagico(dimension, primerNumero);
                //calcula la constante del cuadrado mágico y devuelve un entero.
                int constanteMagica = obtenerConstanteMagica(cuadradoMagico);
                //mostramos la constante y volvemos a pedir datos
                System.out.println(constanteMagica);
                dimension = sc.nextInt();
                primerNumero = sc.nextInt();
            }
        } catch (IllegalArgumentException ex1) {
            System.out.println("Datos incorrectos");
        }
    }

    public static int[][] construirCuadradoMagico(int dimension, int primerNumero) throws IllegalArgumentException {
        //verifica si la dimensión es par o menor que uno o si el primer número es negativo
        if (dimension % 2 == 0 || dimension < 1 || primerNumero < 0) {
            throw new IllegalArgumentException();
        }
        //crea una matriz de enteros con la dimensión dada
        int[][] cuadradoMagico = new int[dimension][dimension];
        //inicializa la variable fila en cero.
        int fila = 0;
        //inicializamos la variable columna en la mitad de la dimensión.
        int columna = dimension / 2;
        //asignamos el primer número a la posición central del cuadrado mágico
        cuadradoMagico[fila][columna] = primerNumero;
        //iniciamos un bucle que se ejecuta desde 1 hasta el valor de la dimensión al cuadrado
        for (int i = 1; i < dimension * dimension; i++) {
            //almacena la posición de la fila actual en una variable auxiliar
            int filaAnterior = fila;
            //almacena la posición de la columna actual en una variable auxiliar
            int columnaAnterior = columna;
            //disminuye el valor de la variable fila
            fila--;
            //aumenta el valor de la variable columna
            columna++;
            //verifica si la fila es menor que cero y, en caso afirmativo, la asigna a la última fila del cuadrado mágico
            if (fila < 0) {
                fila = dimension - 1;
            }
            //verifica si la columna es igual a la dimensión y, en caso afirmativo, la asigna a la primera columna del cuadrado mágico
            if (columna == dimension) {
                columna = 0;
            }
            //verifica si la posición actual del cuadrado mágico ya está ocupada. Si es así, se restauran las variables de fila y columna a sus valores anteriores y se disminuye la fila en uno (si la fila es la última del cuadrado mágico, se asigna la primera fila).
            if (cuadradoMagico[fila][columna] != 0) {
                fila = filaAnterior + 1;
                columna = columnaAnterior;
                if (fila == dimension) {
                    fila = 0;
                }
            }
            //asigna el número actual en la posición actual del cuadrado mágico
            cuadradoMagico[fila][columna] = primerNumero + i;
        }
        return cuadradoMagico;
    }

    public static int obtenerConstanteMagica(int[][] matrizCuadrada) throws IllegalArgumentException {
        //Se inicializa la variable dimension con el tamaño de la matriz y la variable resultado con 0
        int dimension = matrizCuadrada.length;
        int resultado = 0;
        //Se verifica que la matriz tenga al menos una fila y que todas las filas tengan la misma longitud
        if (dimension == 0 || dimension != matrizCuadrada[0].length) {
            throw new IllegalArgumentException();
        }
        //Creamos un vector para almacenar las sumas de las filas e iniciamos las diagonales a 0
        int[] sumas = new int[2 * dimension + 2];
        int diagonalPrincipal = 0;
        int diagonalSecundaria = 0;
        //Recorremos para calcular la suma de filas y columnas, y se almacena. 
        //Se calculan las sumas de los elementos de las diagonales principal y secundaria.
        for (int i = 0; i < dimension; i++) {
            int sumaFila = 0;
            int sumaColumna = 0;

            diagonalPrincipal += matrizCuadrada[i][i];
            diagonalSecundaria += matrizCuadrada[i][dimension - i - 1];

            for (int j = 0; j < dimension; j++) {
                sumaFila += matrizCuadrada[i][j];
                sumaColumna += matrizCuadrada[j][i];
            }

            sumas[i] = sumaFila;
            sumas[dimension + i] = sumaColumna;
        }
        //Almacenamos la suma de las dos diagonales
        sumas[2 * dimension] = diagonalPrincipal;
        sumas[2 * dimension + 1] = diagonalSecundaria;
        //Comparamos la primera suma con la ultima, si son diferentes no es mágico
        if (sumas[0] != sumas[sumas.length - 1]) {
            resultado = -1;
        } else {
            resultado = sumas[0];
        }
        return resultado;
    }
}
