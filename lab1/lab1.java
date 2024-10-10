public class lab1 {

    public static void main(String[] args) {

        try {

            long[][] matrix_A = generate_matrix(3, 4);

            long[][] matrix_B = generate_matrix(4, 3);

            System.out.println("\nMatrix A:");
            print_matrix(matrix_A, matrix_A.length, matrix_A[0].length);
            System.out.println("\nMatrix B:");
            print_matrix(matrix_B, matrix_B.length, matrix_B[0].length);

            long[][] matrix_C = multiplyMatrices(matrix_A, matrix_B);

            System.out.println("\nResult of Matrix A * Matrix B:");
            print_matrix(matrix_C, matrix_C.length, matrix_C[0].length);
            
            long sum = sumMaxEvenRows(matrix_C) + sumMinOddRows(matrix_C);

            System.out.println("\nThe sum of the largest elements in the matrix rows with even numbers\nand the smallest elements in the matrix rows with odd numbers: " + sum);


        } catch (Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }

    public static long[][] generate_matrix(int m, int n) {
        long[][] matrix = new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (long) (Math.random() * 100);
            }
        }

        return matrix;
    }

    public static void print_matrix(long[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static long[][] multiplyMatrices(long[][] matrix_A, long[][] matrix_B) {
        int rows_A = matrix_A.length;        
        int cols_A = matrix_A[0].length;     
        int rows_B = matrix_B.length;        
        int cols_B = matrix_B[0].length;    

        if (cols_A != rows_B) {
            throw new IllegalArgumentException("\nNumber of columns in matrix A must match the number of rows in matrix B.");
        }

        long[][] result = new long[rows_A][cols_B];

        for (int i = 0; i < rows_A; i++) {
            for (int j = 0; j < cols_B; j++) {
                for (int k = 0; k < cols_A; k++) {
                    result[i][j] += matrix_A[i][k] * matrix_B[k][j];
                }
            }
        }

        return result;
    }

    public static long sumMaxEvenRows(long[][] matrix) {
        long sum = 0;
        for (int i = 1; i < matrix.length; i += 2) {  
            long maxInRow = matrix[i][0];  
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxInRow) {
                    maxInRow = matrix[i][j]; 
                }
            }
            sum += maxInRow;  
        }
        return sum;
    }

    public static long sumMinOddRows(long[][] matrix) {
        long sum = 0;
        for (int i = 0; i < matrix.length; i += 2) {  
            long minInRow = matrix[i][0];  
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < minInRow) {
                    minInRow = matrix[i][j]; 
                }
            }
            sum += minInRow;  
        }
        return sum;
    }


}

