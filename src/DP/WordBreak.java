package DP;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            char arr[] = s.toCharArray();
            boolean dp[][] = new boolean[arr.length][arr.length];

            for(int l = 1;l <= arr.length;l++){
                for(int i = 0;i <= arr.length - l;i++)
                    if(wordDict.contains(new String(arr,i,l)))
                        dp[i][i + l - 1] = true;
                    else{
                        for(int k = i;k < i + l - 1;k++){
                            if(dp[i][k] && dp[k + 1][i + l - 1]){
                                dp[i][i + l - 1] = true;
                                break;
                            }
                        }
                    }
            }

            return dp[0][arr.length - 1];
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().wordBreak("leetcode", Arrays.asList("leet","code")));
        System.out.println(new Solution().wordBreak("applepenapple", Arrays.asList("apple","pen")));
        System.out.println(new Solution().wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}
