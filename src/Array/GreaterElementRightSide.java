package Array;

public class GreaterElementRightSide {
    static class Solution {
        public int[] replaceElements(int[] arr) {
            int res[] = new int[arr.length];
            int max = -1;
            for(int i = arr.length - 1;i >= 0;i--){
                res[i] = max;
                max = Math.max(arr[i], max);
            }

            return res;
        }
    }
    public static void main(String args[]) {
        int res[] = new Solution().replaceElements(new int[]{17,18,5,4,6,1});
        for(int x : res)
            System.out.print(x + " ");
    }
}
