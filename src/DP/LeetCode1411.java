package DP;

import java.util.Collections;

public class LeetCode1411 {
    static class Solution {
        public int numOfWays(int n) {
            long twoCombo = 6, threeCombo = 6;
            long mod = 1000000007;

            for(int i = 2;i <= n;i++) {
                long tempTwoCombo = (3 * twoCombo + 2 * threeCombo) % mod;
                long tempThreeCombo = (2 * twoCombo + 2 * threeCombo) % mod;
                twoCombo = tempTwoCombo;
                threeCombo = tempThreeCombo;
            }

            return (int)((twoCombo + threeCombo) % mod);
        }
    }

    public static void main(String[] args) {
        Collections.reverseOrder();
        System.out.println(new Solution().numOfWays(5000));
    }
}
