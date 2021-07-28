package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode1403 {
    static class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            int sum = 0;
            int sumArr[] = new int[nums.length];
            List<Integer> subseq[] = new ArrayList[nums.length];

            int maxSize = Integer.MAX_VALUE;
            int maxSum = 0;
            List<Integer> res = new ArrayList<>();

            for(int x : nums)
                sum += x;

            for(int i = nums.length - 1;i >= 0;i--) {
                int eSum = sum - nums[i];
                int iSum = nums[i];
                subseq[i] = new ArrayList<>();
                if(eSum < iSum && ((maxSize > 1) || (maxSize == 1 && iSum > maxSum))) {
                    res.add(nums[i]);
                    maxSize = 1;
                    sumArr[i] = iSum;
                }

                for(int j = i + 1; j < nums.length;j++) {
                    eSum = sum - (nums[i] + nums[j]);
                    iSum = nums[i] + nums[j];
                    if(eSum < iSum && (maxSize > 2 || (maxSize == 2 && iSum > maxSum))) {
                        res.add(nums[i]);
                        res.add(nums[j]);
                        sumArr[i] = iSum;
                        maxSize = 2;
                    }

                    eSum = sum - (nums[i] + sumArr[j]);
                    iSum = nums[i] + sumArr[j];
                    int size = subseq[j].size() + 1;
                    if(eSum < iSum && (maxSize > size || (maxSize == size && iSum > maxSum))) {
                        res.addAll(subseq[j]);
                        res.add(nums[i]);
                        sumArr[i] = iSum;
                        maxSize = subseq[j].size() + 1;
                    }
                }

                subseq[i].addAll(res);
            }

            Collections.sort(res);
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubsequence(new int[]{4,3,10,9,8}));
    }
}
