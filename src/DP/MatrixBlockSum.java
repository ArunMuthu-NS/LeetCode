package DP;

public class MatrixBlockSum {
    static class Solution {
        public int[][] matrixBlockSum(int[][] mat, int K) {
            int res[][] = new int[mat.length + 1][mat[0].length + 1];
            for(int i = 1;i <= mat.length;i++)
                for(int j = 1;j <= mat[i - 1].length;j++)
                    res[i][j] = mat[i - 1][j - 1] + res[i][j - 1] + res[i - 1][j] - res[i - 1][j - 1];

            int ans[][] = new int[mat.length][mat[0].length];
            for(int i = 0;i < mat.length;i++)
                for(int j = 0;j < mat[i].length;j++) {
                    int r1 = (i - K) < 0 ? 0 : (i - K);
                    int c1 = (j - K) < 0 ? 0 : (j - K);

                    int r2 = (i + K) >= mat.length ? mat.length - 1 : (i + K);
                    int c2 = (j + K) >= mat[i].length ? mat[i].length - 1 : (j + K);

                    r1++; c1++; r2++; c2++;
                    ans[i][j] = res[r2][c2] - res[r2][c1 - 1] - res[r1 - 1][c2] + res[r1 - 1][c1 - 1];
                }

            return ans;
        }
    }

    public static void main(String args[]) {
        int ans[][] = new Solution().matrixBlockSum(new int[][]{
                {1,2,3}, {4,5,6}, {7,8,9}
        }, 1);
        for(int i = 0;i < ans.length;i++) {
            for (int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}
