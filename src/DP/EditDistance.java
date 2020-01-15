package DP;

/*
    Problem Link : https://leetcode.com/problems/edit-distance/
    Solution Link : https://leetcode.com/submissions/detail/294466939/
*/

public class EditDistance {
    static class Solution {
        public int minDistance(String word1, String word2) {
            int DP[][] = new int[word1.length() + 1][word2.length() + 1];

            for(int i = 0;i <= word1.length();i++)
                for(int j = 0;j <= word2.length();j++){
                    if(i == 0) DP[i][j] = j;
                    else if(j == 0) DP[i][j] = i;
                    else if(word1.charAt(i - 1) == word2.charAt(j - 1))
                        DP[i][j] = DP[i - 1][j - 1];
                    else
                        DP[i][j] = 1 + Math.min(DP[i - 1][j - 1], Math.min(DP[i - 1][j], DP[i][j - 1]));
                }

            return DP[word1.length()][word2.length()];
        }
    }
    public static void main(String args[]) {
        System.out.println(new Solution().minDistance("horse", "ros"));
    }
}
