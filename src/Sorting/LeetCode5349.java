package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode5349 {
    static class Solution {
        public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
            int ans = 0;
            Arrays.sort(reservedSeats, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] < o2[0]) return -1;
                    else return 1;
                }
            });

            int seats[] = new int[11], curr = 0;

            for(int i = 0;i <= reservedSeats.length;) {
                if((i < reservedSeats.length) && (reservedSeats[curr][0] == reservedSeats[i][0])){
                    seats[reservedSeats[i][1]] = 1;
                    i++;
                }
                else {
                    int ranges[][] = new int[][]{{2,6}, {4,8}, {6,10}};
                    for(int j = 0;j < ranges.length;j++) {
                        while (ranges[j][0] < ranges[j][1]) {
                            if (seats[ranges[j][0]] != 0)
                                break;
                            seats[ranges[j][0]] = 1;
                            ranges[j][0]++;
                        }
                        if (ranges[j][0] == ranges[j][1]) ans++;
                    }

                    seats = new int[11];
                    curr = i;
                    i = (i == reservedSeats.length) ? i + 1 : i;
                    n--;
                }
            }

            ans = (n > 0) ? (n * 2) + ans : ans;

            return ans;
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().maxNumberOfFamilies(3,new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}}));
    }
}
