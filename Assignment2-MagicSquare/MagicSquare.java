import java.util.Scanner;

public class MagicSquare {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the dimension of the square matrix: ");
        int len = reader.nextInt();

        int[][] arr = new int[len][len];

        System.out.println("Enter matrix values:");
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                arr[row][col] = reader.nextInt();
            }
        }

        // Row sums
        System.out.println("\nRow Totals:");
        for (int row = 0; row < len; row++) {
            int rowTotal = 0;
            for (int col = 0; col < len; col++) {
                rowTotal += arr[row][col];
            }
            System.out.println("Row " + (row + 1) + " = " + rowTotal);
        }

        // Column sums
        System.out.println("\nColumn Totals:");
        for (int col = 0; col < len; col++) {
            int colTotal = 0;
            for (int row = 0; row < len; row++) {
                colTotal += arr[row][col];
            }
            System.out.println("Column " + (col + 1) + " = " + colTotal);
        }

        // Main diagonal
        int mainDiag = 0;
        for (int row = 0; row < len; row++) {
            mainDiag += arr[row][row];
        }
        System.out.println("\nPrimary Diagonal = " + mainDiag);

        // Anti diagonal
        int antiDiag = 0;
        for (int row = 0; row < len; row++) {
            antiDiag += arr[row][len - 1 - row];
        }
        System.out.println("Anti Diagonal    = " + antiDiag);

        reader.close();
    }
}
