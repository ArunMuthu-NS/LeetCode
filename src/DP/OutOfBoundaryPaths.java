package DP;

public class OutOfBoundaryPaths {
    static class Solution {
        int dp[][];
        public int findPaths(int m, int n, int N, int i, int j) {
            dp = new int[m][n];
            for(int i1 = 0;i1 < m;i1++)
                for(int j1 = 0;j1 < n;j1++)
                    dp[i1][j1] = -1;

            return path(m,n,N,i,j);
        }

        public int path(int m,int n,int N,int i,int j) {
            if(i >= m || j >= n || i < 0 || j < 0) return 1;
            if(dp[i][j] != -1) return dp[i][j];
            if(N > 0){
                int sum = 0;
                sum += (path(m,n,N - 1,i + 1,j) % 1000000007);
                sum += (path(m,n,N - 1,i,j + 1) % 1000000007);
                sum += (path(m,n,N - 1,i - 1,j) % 1000000007);
                sum += (path(m,n,N - 1,i,j - 1) % 1000000007);
                dp[i][j] = sum % 1000000007;
                return dp[i][j];
            }

            dp[i][j] = 0;
            return dp[i][j];
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().findPaths(2,2,2,0,0));
        System.out.println(new Solution().findPaths(1,3,3,0,1));
    }
}
