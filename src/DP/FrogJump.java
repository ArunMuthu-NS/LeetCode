package DP;

public class FrogJump {
    static class Solution {
        public boolean canCross(int[] stones) {
            int max = stones.length;
            boolean dp[][] = new boolean[max][max + 1];

            dp[0][1] = true;

            boolean isReachable = false;
            for(int i = 1;i < stones.length;i++){
                isReachable = false;
                for(int j = 0;j < i;j++){
                    int jump = stones[i] - stones[j];
                    if(dp[j][jump]){
                        dp[i][jump] = dp[i][jump - 1] = dp[i][jump + 1] = true;
                        isReachable = true;;
                    }
                }
            }

            return isReachable;
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().canCross(new int[]{0,1,3,6,10,13,15,16,19,21,25}));
        System.out.println(new Solution().canCross(new int[]{0,1,3,6,10,15,16,21}));
        System.out.println(new Solution().canCross(new int[]{0,2}));
        System.out.println(new Solution().canCross(new int[]{0,1,3,6,7}));
        System.out.println(new Solution().canCross(new int[]{0,1,3,4,5,7,9,10,12}));
        System.out.println(new Solution().canCross(new int[]{0,1,2,3,4,8,9,12}));
    }
}
