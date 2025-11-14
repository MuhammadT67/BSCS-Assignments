import java.util.Scanner;

public class MatrixAnalyzer {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the order of the square matrix: ");
        int size = input.nextInt();

        int[][] grid = new int[size][size];

        System.out.println("Enter the values of the matrix:");
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = input.nextInt();
            }
        }

        // Row sums
        System.out.println("\nSum of Rows:");
        for (int r = 0; r < size; r++) {
            int total = 0;
            for (int c = 0; c < size; c++) {
                total += grid[r][c];
            }
            System.out.println("Row " + (r + 1) + " = " + total);
        }

        // Column sums
        System.out.println("\nSum of Columns:");
        for (int c = 0; c < size; c++) {
            int total = 0;
            for (int r = 0; r < size; r++) {
                total += grid[r][c];
            }
            System.out.println("Column " + (c + 1) + " = " + total);
        }

        // Primary diagonal
        int primaryDiag = 0;
        for (int r = 0; r < size; r++) {
            primaryDiag += grid[r][r];
        }
        System.out.println("\nPrimary Diagonal Sum = " + primaryDiag);

        // Secondary diagonal
        int secondaryDiag = 0;
        for (int r = 0; r < size; r++) {
            secondaryDiag += grid[r][size - 1 - r];
        }
        System.out.println("Secondary Diagonal Sum = " + secondaryDiag);

        input.close();
    }
}
