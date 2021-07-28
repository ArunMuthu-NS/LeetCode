package DP;

import java.util.Arrays;

public class Leetcode740 {
    static class Solution {
        public int deleteAndEarn(int[] nums) {
            int map[] = new int[10001];
            int DP[] = new int[10001];
            int min = Integer.MAX_VALUE, max = -1;

            Arrays.fill(DP, -1);

            for(int x : nums) {
                min = Math.min(x , min);
                max = Math.max(x , max);
                map[x]++;
            }

            int res = 0;

            for(int i = min;i <= max;i++){
                res = Math.max(res, f(map, DP, i, max));
            }

            return res;
        }

        public int f(int map[],int DP[], int index, int max) {
            if(index > max) return 0;
            if(DP[index] != -1) return DP[index];
            int res = 0;
            if(map[index] != 0)
                res = (map[index] * index) + f(map,DP, index + 2, max);
            else
                res =
            DP[index] = res;
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().deleteAndEarn(new int[]{8,10,4,9,1,3,5,9,4,10}));
    }
}
