package DP;

/*
    Problem Link : https://leetcode.com/problems/longest-common-subsequence
    Solution Link : https://leetcode.com/submissions/detail/287881657/
*/

public class LongestPalidromeSubSeq {
    static class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int L[][] = new int[n][n];

            for(int i = 0;i < n;i++)
                L[i][i] = 1;

            for(int l = 2;l <= n;l++)
                for(int i = 0;i <= n- l;i++){
                    int j = i + l - 1;
                    if(s.charAt(i) == s.charAt(j))
                        L[i][j] = 2 + L[i + 1][j - 1];
                    else
                        L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
                }

            return L[0][n - 1];
        }
    }
    public static void main(String args[]){
        System.out.println(new Solution().longestPalindromeSubseq("bbbcb"));
    }


}
