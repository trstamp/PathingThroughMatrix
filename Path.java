import java.util.Random;

public class Path {
    Random ran = new Random();
    int max = 0;

    public int[][] createMatrix(){
        int m = 12, n = 12;   //change these numbers to change size of square matrices
        int[][] board = new int[n][m];
        for(int a = 0; a < n; a++){
            for(int b = 0; b < m; b++){
                int num = ran.nextInt(90) + 10;
                board[a][b] = num;
                System.out.print(board[a][b] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        return board;
    }

    public int findPath(int[][] matrix, int i, int j) //i and j are the beginning of the matrix (0,0)
    {
        int num;
        if(i == 0 && j == 0){
            System.out.print(matrix[i][j] + ", ");
        }            
        if(i == matrix.length - 1){
            if(j < matrix[0].length - 1){
                num = matrix[i][j+1];
                max = num + max;
                System.out.print(num + ", ");
                return findPath(matrix, i, j+1);
            }
            else{
                return max;
            }
        }
        else if(j == matrix[0].length - 1){
            if (i < matrix.length - 1){
                num = matrix[i+1][j];
                max = num + max;
                System.out.print(num + ", ");
                return findPath(matrix, i+1, j);
            }
        }
        if(matrix[i + 1][j] <= matrix[i + 1][j + 1]) {
            if (matrix[i][j + 1] <= matrix[i + 1][j + 1]) {
                num = matrix[i+1][j+1];
                max = num + max;
                System.out.print(num + ", ");
                return findPath(matrix, i+1, j+1);
            }
            else {
                num = matrix[i][j + 1];
                max = num + max;
                System.out.print(num + ", ");
                return findPath(matrix, i, j + 1);
            }
        }
        else if(matrix[i+1][j+1] <= matrix[i+1][j]){
            if(matrix[i][j+1] <= matrix[i+1][j]){
                num = matrix[i+1][j];
                max = num + max;
                System.out.print(num + ", ");
                return findPath(matrix, i+1, j);
            }
            else{
                num = matrix[i][j+1];
                max = num + max;
                System.out.print(num + ", ");
                return findPath(matrix, i, j+1);
            }
        }
        else if(matrix[i][j+1] <= matrix[i+1][j]){
            if(matrix[i+1][j+1] <= matrix[i+1][j]){
                num = matrix[i+1][j];
                max = num + max;
                System.out.print(num + ", ");
                return findPath(matrix, i+1, j);
            }
            else{
                num = matrix[i+1][j+1];
                max = num + max;
                System.out.print(num + ", ");
                return findPath(matrix, i+1, j+1);
            }
        }
        return max;
    }
}
