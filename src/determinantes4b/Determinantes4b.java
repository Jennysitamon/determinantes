package determinantes4b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Determinantes4b {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static void obtenerCofactor(int matriz[][], int temp[][], int p, int q, int n) {
        int i = 0, j = 0;
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                if (fila != p && columna != q) {
                    temp[i][j++] = matriz[fila][columna];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    static int determinanteMatriz(int matriz[][], int n) {
        int determinante = 0;
        if (n == 1) {
            return matriz[0][0];
        }
        int temp[][] = new int[n][n];
        int multiplicador = 1;
        for (int f = 0; f < n; f++) {
            obtenerCofactor(matriz, temp, 0, f, n);
            determinante += multiplicador * matriz[0][f] * determinanteMatriz(temp, n - 1);
            multiplicador = -multiplicador;
        }
        return determinante;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Ingresa el tamaño de la matriz:\t");
        int n = Integer.parseInt(reader.readLine());
        int matriz[][] = new int[n][n];
        System.out.println("Inserta los valores:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("mat[" + i + "][" + j + "]:\t");
                matriz[i][j] = Integer.parseInt(reader.readLine());
            }
        }

        System.out.println("\nMatriz ingresada:");
        imprimirMatriz(matriz);

        System.out.println("\nLa determinante de la matriz es:\t" + determinanteMatriz(matriz, n));

        reader.close();
    }

    static void imprimirMatriz(int matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
