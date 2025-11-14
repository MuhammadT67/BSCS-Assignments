// Checks if a given matrix is a Magic Square
// All rows, columns, and both diagonals must have the same sum
class Assignment4_MagicSquare {

    public static boolean isMagicSquare(int[][] matrix) {
        int size = matrix.length;

        int targetSum = 0;
        for (int col = 0; col < size; col++)
            targetSum += matrix[0][col];

        for (int row = 0; row < size; row++) {
            int rowSum = 0;
            for (int col = 0; col < size; col++)
                rowSum += matrix[row][col];
            if (rowSum != targetSum) return false;
        }

        for (int col = 0; col < size; col++) {
            int colSum = 0;
            for (int row = 0; row < size; row++)
                colSum += matrix[row][col];
            if (colSum != targetSum) return false;
        }

        int mainDiag = 0;
        int antiDiag = 0;
        for (int i = 0; i < size; i++) {
            mainDiag += matrix[i][i];
            antiDiag += matrix[i][size - 1 - i];
        }

        return mainDiag == targetSum && antiDiag == targetSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 8}
        };

        if (isMagicSquare(matrix))
            System.out.println("Magic Square");
        else
            System.out.println("Not a Magic Square");
    }
}
