package DP;

import java.util.HashMap;

public class LongestFibSeq {
    static class Solution {
        HashMap<String,Integer> map = new HashMap<>();
        public int lenLongestFibSubseq(int[] A) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int x : A)
                map.put(x,x);

            int max = 0;

            for(int i = 0;i < A.length;i++){
                for(int j = i + 1;j < A.length;j++){
                    int a = A[i];
                    int b = A[j];
                    int c = a + b;
                    int len = 0;
                    if(map.get(c) != null){
                        len = 2;
                        while(map.get(c) != null){
                            a = b;
                            b = c;
                            c = a + b;
                            len++;
                        }
                    }
                    max = Math.max(max, len);
                }
            }

            return max;
        }

        public int lenLongestFibSubSeq_2(int[] A) {
            int dp[][] = new int[A.length][A.length];
            int max = 0;
            for(int i = 1;i < A.length;i++){
                int l = 0, r = i - 1;
                while(l < r) {
                    int sum = A[l] + A[r];
                    if(sum < A[i])
                        l++;
                    else if(sum > A[i])
                        r--;
                    else{
                        dp[r][i] = dp[l][r] + 1;
                        max = Math.max(dp[r][i], max);
                        l++;
                        r--;
                    }
                }
            }

            return (max == 0) ? max : (max + 2);
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().lenLongestFibSubSeq_2(new int[]{
                2,4,7,8,9,10,14,15,18,23,32,50
        }));
    }
}
