import java.util.LinkedList;
import java.util.Queue;

public class Code48_reverseMatrix {
    public static void rotate (int[][] matrix){
        Queue queue = new LinkedList();
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                queue.add(matrix[i][j]);
            }
        }
        for (int i = matrix.length - 1; i>=0; i--){
            for (int j = 0; j<matrix.length; j++){
                matrix[j][i] = (int)queue.poll();
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int num = 1;
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                matrix[i][j] = num ++;
            }
        }

        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        rotate(matrix);
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
