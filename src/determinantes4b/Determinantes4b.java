package determinantes4b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Determinantes4b {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion;

        do {
            System.out.println("Hola😍. Elige la opción de lo que deseas realizar:");
            System.out.println("1. Calcular determinante matriz");
            System.out.println("2. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Inténtalo de nuevo :(");
                opcion = -1; 
                continue;
            }

            switch (opcion) {
                case 1 -> calcularMatriz(reader);
                case 2 -> System.out.println("Saliendo del programa...😣");
                default -> System.out.println("Inténtalo de nuevo :(");
            }
        } while (opcion != 0);

        try {
            reader.close();
        } catch (IOException e) {
        }
    }

    public static void calcularMatriz(BufferedReader reader) {
        try {
            System.out.print("Número de filas de la matriz: ");
            int filas = Integer.parseInt(reader.readLine());

            System.out.print("Número de columnas de la matriz: ");
            int columnas = Integer.parseInt(reader.readLine());

            if (filas != columnas) {
                System.out.println("No es una matriz cuadrada. El número de filas debe ser igual al número de columnas.");
                return;
            }

            int[][] matriz = new int[filas][columnas];
      
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print("Ingrese el elemento en la posición [" + (i + 1) + "][" + (j + 1) + "]: ");
                    matriz[i][j] = Integer.parseInt(reader.readLine());
                }
            }

            
            System.out.println("Matriz ingresada:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(matriz[i][j] + "\t");
                }
                System.out.println();
            }

            int suma = calcularSumaMatriz(matriz);
            System.out.println("Resultado de la suma de la matriz: " + suma);

        } catch (IOException | NumberFormatException e) {
            System.out.println("Inténtalo de nuevo, error al leer datos :(");
        }
    }
    public static int calcularSumaMatriz(int[][] matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
        }
        return suma;
    }
}
