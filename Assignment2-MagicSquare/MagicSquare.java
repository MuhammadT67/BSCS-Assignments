import java.util.Scanner;
public class SquareMatrix {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Input the dimension of the square matrix: ");
        int len = reader.nextInt();
        int[][] arr = new int[len][len];
        // Input elements
        System.out.println("Input the matrix values:");
        for(int row = 0; row < len; row++) {
            for(int col = 0; col < len; col++) {
                arr[row][col] = reader.nextInt();
            }
        }
        // Row Sum
        System.out.println("Row Totals:");
        for(int row = 0; row < len; row++) {
            int rowTotal = 0;
            for(int col = 0; col < len; col++) {
                rowTotal += arr[row][col];
            }
            System.out.println("Row " + (row+1) + " Total = " + rowTotal);
        }
        // Column Sum
        System.out.println("Column Totals:");
        for(int col = 0; col < len; col++) {
            int colTotal = 0;
            for(int row = 0; row < len; row++) {
                colTotal += arr[row][col];
            }
            System.out.println("Column " + (col+1) + " Total = " + colTotal);
        }
        // Diagonal Sum
        int mainDiag = 0;
        for(int row = 0; row < len; row++) {
            mainDiag += arr[row][row];
        }
        System.out.println("Primary Diagonal Total = " + mainDiag);
        // Reverse Diagonal Sum
        int antiDiag = 0;
        for(int row = 0; row < len; row++) {
            antiDiag += arr[row][len-1-row];
        }
        System.out.println("Anti Diagonal Total = " + antiDiag);
        reader.close();
    }
}
