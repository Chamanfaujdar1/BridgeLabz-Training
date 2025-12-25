public class MatrixOperations {

    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10); // 0–9
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int rowsA = 2, colsA = 3;
        int rowsB = 3, colsB = 2;

        int[][] A = createRandomMatrix(rowsA, colsA);
        int[][] B = createRandomMatrix(rowsA, colsA);
        int[][] C = createRandomMatrix(rowsB, colsB);

        System.out.println("Matrix A:");
        displayMatrix(A);

        System.out.println("Matrix B:");
        displayMatrix(B);

        System.out.println("A + B:");
        displayMatrix(addMatrices(A, B));

        System.out.println("A - B:");
        displayMatrix(subtractMatrices(A, B));

        System.out.println("Matrix C:");
        displayMatrix(C);

        System.out.println("A x C:");
        displayMatrix(multiplyMatrices(A, C));
    }
}
