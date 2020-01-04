package Sorting;

/*
    Problem Link : https://leetcode.com/problems/remove-covered-intervals/
    Solution Link : https://leetcode.com/submissions/detail/288442294/
*/

import java.util.Arrays;
import java.util.Comparator;

public class CoveredIntervals {
    static class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, new Comparator<int[]>(){
                public int compare(int[] interval1, int[] interval2) {
                    if(interval1[0] < interval2[0]) return -1;
                    if(interval1[0] > interval2[0]) return 1;
                    if(interval1[1] > interval2[1]) return -1;
                    return 0;
                }
            });

            int count = 0, x = -1, y = -1;
            for(int i = 0;i < intervals.length;i++){
                if(i == 0){
                    x = intervals[i][0];
                    y = intervals[i][1];
                    count++;
                }
                else{
                    if(x <= intervals[i][0] && intervals[i][1] <= y)
                        continue;
                    else{
                        x = intervals[i][0];
                        y = intervals[i][1];
                        count++;
                    }
                }
            }
            return count;
        }
    }
    public static void main(String args[]) {
        int[][] intervals = new int[][]{
                {1,4},
                {3,6},
                {2,8},
                {2,6}
        };
        System.out.println(new Solution().removeCoveredIntervals(intervals));
    }
}
