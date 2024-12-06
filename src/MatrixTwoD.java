import java.util.Scanner;

public class MatrixTwoD {
    static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] Transpose(int[][] matrix){
        int[][] ans= new int[matrix[0].length][matrix.length];
        for(int i=0; i<matrix.length;i++){
            for (int j = 0; j < matrix[i].length; j++) {
                ans[j][i]=matrix[i][j];
            }
        }
        return ans;
    }
    public static int[][] pascalTriangle(int n){
        int[][] ans=new int[n][];
        for(int i=0;i<n;i++){
            ans[i]=new int[i+1];
            ans[i][0]=ans[i][i]=1;
            for (int j = 1; j <i; j++) {
                ans[i][j]=ans[i-1][j]+ans[i-1][j-1];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the no. of rows or columns");
        int n=sc.nextInt();
        int[][] ans=pascalTriangle(n);
        printMatrix(ans);
    }
}