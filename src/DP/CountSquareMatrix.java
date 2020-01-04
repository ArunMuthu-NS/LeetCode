package DP;

/*
    Problem Link : https://leetcode.com/problems/count-square-submatrices-with-all-ones/
    Solution Link : https://leetcode.com/submissions/detail/287963613/
*/

public class CountSquareMatrix {
    static class Solution {
        public int countSquares(int[][] matrix) {
            if(matrix == null || matrix[0] == null) return 0;

            int count = 0;
            for(int i = 0;i < matrix.length;i++){
                for(int j = 0;j < matrix[i].length;j++){
                    if(i == 0 || j == 0) {
                        count += (matrix[i][j] == 1) ? 1 : 0;
                    }
                    else if(matrix[i][j] == 1) {
                        count++;
                        matrix[i][j] = getMin(matrix[i - 1][j - 1], matrix[i][j - 1], matrix[i - 1][j]) + 1;
                        count += matrix[i][j] - 1;
                    }
                }
            }

            return count;
        }

        public int getMin(int ...args){
            int min = Integer.MAX_VALUE;
            for(int x : args)
                min = Math.min(x, min);
            return min;
        }
    }

    public static void main(String args[]) {
        int matrix[][] =new int[][]{
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(new Solution().countSquares(matrix));
    }
}
