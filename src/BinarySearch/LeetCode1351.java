package BinarySearch;

public class LeetCode1351 {
    static class Solution {
        public int countNegatives(int[][] grid) {
            int res = 0;
            for(int x[] : grid){
                int low = 0, high = x.length - 1,mid;
                while(low <= high){
                    mid = (low + high) / 2;
                    if(x[mid] < 0)
                        high = mid - 1;
                    else
                        low = mid + 1;
                }

                res += (x.length - low);
            }
            return res;
        }
    }

    public static void main(String args[]) {
        int test[][] = new int[][] {
                {4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}
        };
        System.out.println(new Solution().countNegatives(test));
    }
}
