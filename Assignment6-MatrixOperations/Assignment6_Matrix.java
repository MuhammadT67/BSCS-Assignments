import java.util.Scanner;

// Assignment 6 - Matrix Operations: addition, subtraction, multiplication, transpose, diagonals
class Assignment6_Matrix {

    static void print(int[][] m) {
        for (int[] row : m) {
            for (int v : row) System.out.printf("%4d", v);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] A = {{9, 7, 8}, {5, 6, 7}, {1, 3, 5}};
        int[][] B = {{2, 4, 1}, {2, 3, 1}, {0, 1, 3}};
        int n = 3;

        int[][] add = new int[n][n];
        int[][] sub = new int[n][n];
        int[][] mul = new int[n][n];
        int[][] tr  = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                add[i][j] = A[i][j] + B[i][j];
                sub[i][j] = A[i][j] - B[i][j];
                tr[j][i]  = A[i][j];
                for (int k = 0; k < n; k++)
                    mul[i][j] += A[i][k] * B[k][j];
            }

        System.out.println("Addition:");      print(add);
        System.out.println("\nSubtraction:"); print(sub);
        System.out.println("\nMultiplication:"); print(mul);
        System.out.println("\nTranspose of A:"); print(tr);

        int sumAll = 0;
        for (int[] row : A) for (int v : row) sumAll += v;
        System.out.println("\nSum of all elements in A: " + sumAll);

        int d1 = 0, d2 = 0;
        for (int i = 0; i < n; i++) {
            d1 += A[i][i];
            d2 += A[i][n - 1 - i];
        }
        System.out.println("Primary Diagonal Sum   : " + d1);
        System.out.println("Secondary Diagonal Sum : " + d2);

        Scanner sc = new Scanner(System.in);
        System.out.print("\nHow many numbers to sum? ");
        int cnt = sc.nextInt();
        double s = 0;
        for (int i = 0; i < cnt; i++) s += sc.nextDouble();
        System.out.println("Sum = " + s + "  |  Average = " + (s / cnt));
        sc.close();
    }
}
