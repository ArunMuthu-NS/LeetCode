package DP;

/*
    Problem Link : https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
    Solution Link : https://leetcode.com/submissions/detail/291942055/
*/

public class NumberOfDicesToTarget {
    static class Solution {
        public int numRollsToTarget(int d, int f, int target) {
            int dp[][] = new int[d + 1][target + 1];
            dp[0][0] = 1;

            for(int i = 1;i <= d;i++)
                for(int j = i;j <= target;j++)
                    if(j > (i * f)) continue;
                    else{
                        for(int faces = 1;faces <= f && faces <= j;faces++)
                            dp[i][j] = (dp[i][j] + dp[i - 1][j - faces]) % 1000000007;
                    }

            return dp[d][target];
        }
    }
    public static void main(String args[]) {
        System.out.println(new Solution().numRollsToTarget(30,30,500));
    }
}
