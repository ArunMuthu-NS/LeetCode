package DP;

/*
    Problem Link : https://leetcode.com/problems/range-sum-query-2d-immutable/
    Solution Link : https://leetcode.com/submissions/detail/293868946/
*/

class NumMatrix {
    int[][] sumArr = null;
    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        sumArr = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1;i <= matrix.length;i++)
            for(int j = 1;j <= matrix[i - 1].length;j++)
                sumArr[i][j] = matrix[i - 1][j - 1] + sumArr[i][j - 1] + sumArr[i - 1][j] - sumArr[i - 1][j - 1];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sumArr == null) return 0;
        row1++; col1++; row2++; col2++;
        return (sumArr[row2][col2] - sumArr[row2][col1 - 1] - sumArr[row1 - 1][col2] + sumArr[row1 - 1][col1 - 1]);
    }
}

public class Sum2D {
    public static void main(String args[]) {
        int matrix[][] = new int[][]{
                {3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}      
        };
        NumMatrix matrix1 = new NumMatrix(matrix);
        System.out.println(matrix1.sumRegion(2, 1, 4, 3));
        System.out.println(matrix1.sumRegion(1, 1, 2, 2));
        System.out.println(matrix1.sumRegion(1, 2, 2, 4));
    }
}
