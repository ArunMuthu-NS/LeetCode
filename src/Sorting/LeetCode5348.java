package Sorting;

import java.util.Arrays;

public class LeetCode5348 {
    static class Solution {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            int res = 0;
            Arrays.sort(arr2);
            for(int i = 0;i < arr1.length;i++) {
                int low = 0, high = arr2.length - 1,mid;
                while(low <= high) {
                    mid = (low + high) / 2;
                    int modVal = Math.abs(arr1[i] - arr2[mid]);
                    if(modVal <= d) break;
                    if(arr2[mid] >=0 )
                        high = mid - 1;
                    else
                        low = mid + 1;
                }

                if(low > high)
                    res++;
            }

            return res;
        }
    }
    public static void main(String args[]) {
        System.out.println(new Solution().findTheDistanceValue(new int[]{-3,10,2,8,0,10}, new int[]{-9,-1,-4,-9,-8}, 9));
    }
}
