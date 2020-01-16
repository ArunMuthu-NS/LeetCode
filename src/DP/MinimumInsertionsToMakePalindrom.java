package DP;

/*
    Problem Link : https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
    Solution Link : https://leetcode.com/submissions/detail/294714309/
*/

public class MinimumInsertionsToMakePalindrom {
    static class Solution {
        public int minInsertions(String s) {
            int dp[][] = new int[s.length()][s.length()];
            for(int i = 0;i < s.length();i++)
                for(int j = 0;j < s.length();j++)
                    dp[i][j] = -1;

            return helper(dp,s, 0, s.length() - 1);
        }

        private int helper(int dp[][], String s,int start, int end) {
            if(start >= end) return 0;
            if(dp[start][end] != -1) return dp[start][end];
            if(s.charAt(start) == s.charAt(end))
                dp[start][end] = helper(dp, s,start + 1, end - 1);
            else
                dp[start][end] = 1 + Math.min(helper(dp,s,start,end - 1), helper(dp, s, start + 1, end));

            return dp[start][end];
        }
    }
    public static void main(String args[]) {
        System.out.println(new Solution().minInsertions("gn"));
    }
}
