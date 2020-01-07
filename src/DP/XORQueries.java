package DP;

/*
    Problem Link : https://leetcode.com/problems/xor-queries-of-a-subarray/
    Solution Link : https://leetcode.com/submissions/detail/291651101/
*/


import java.util.Arrays;

public class XORQueries {
    static class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int xor[] = new int[arr.length];
            for(int i = 0;i < arr.length;i++)
                xor[i] = (i == 0) ? arr[i] : arr[i] ^ xor[i - 1];

            int res[] = new int[queries.length];
            for(int i = 0;i < queries.length;i++){
                int x = queries[i][0], y = queries[i][1];
                if(x == 0)
                    res[i] = xor[y];
                else if(x == y)
                    res[i] = arr[x];
                else
                    res[i] = xor[y] ^ xor[x - 1];
            }

            return res;
        }
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(new Solution().xorQueries(new int[]{
                1, 3, 4, 8
        }, new int[][]{
                {0, 1}, {1, 2}, {0, 3}, {3, 3}
        })));
    }
}
