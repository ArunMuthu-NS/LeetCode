package Sorting;

import java.util.Arrays;

public class Leetcode179 {
    static class Solution {
        public String largestNumber(int[] nums) {
            Integer[] nums1 = new Integer[nums.length];

            for(int i = 0;i < nums.length;i++)
                nums1[i] = nums[i];

            Arrays.sort(nums1, (o1, o2) -> {
                int[] val1 = new int[getSize(o1) + getSize(o2)];
                int[] val2 = new int[getSize(o1) + getSize(o2)];
                fill(val1, o1, o2);
                fill(val2, o2, o1);

                int i = 0, size = Math.min(val1.length, val2.length);
                while(i < size) {
                    if(val1[i] < val2[i]) return 1;
                    else if(val1[i] > val2[i]) return -1;
                    i++;
                }

                return 0;
            });

            if(nums1[0] == 0) return "0";

            StringBuilder sb = new StringBuilder();
            for(Integer x : nums1) {
                    sb.append(x);
            }

            return sb.toString();
        }


        public int getSize(int x) {
            if(x == 0) return 1;
            int count = 0;
            while(x > 0){
                x = x / 10;
                count++;
            }
            return count;
        }

        public void fill(int val[], int x1, int x2) {
            int i = val.length - 1;
            if(x2 == 0) i--;
            while(x2 > 0) {
                val[i] = x2 % 10;
                x2 = x2 / 10;
                i--;
            }

            while(x1 > 0) {
                val[i] = x1 % 10;
                x1 = x1 / 10;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(new Solution().largestNumber(new int[]{128,12}));
        System.out.println(new Solution().largestNumber(new int[]{10,2}));
        System.out.println(new Solution().largestNumber(new int[]{128,12,320,32}));
        System.out.println(new Solution().largestNumber(new int[]{0,9,8,7,6,5,4,3,2,1}));
    }
}
