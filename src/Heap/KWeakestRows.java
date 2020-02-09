package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KWeakestRows {
    static class Row {
        int index;
        int count;
    }

    static class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            ArrayList<Row> list = new ArrayList<>();

            int index = 0;
            for(int row[] : mat) {
                Row r = new Row();
                r.count = binarySearch(row, 0, row.length - 1);
                r.index = index++;
                list.add(r);
            }

            Collections.sort(list, (o1, o2) -> {
                if(o1.count < o2.count)
                    return -1;
                else if(o1.count > o2.count)
                    return 1;
                else if(o1.index < o2.index)
                    return -1;
                else return 1;
            });

            int res[] = new int[k];
            for(int i = 0;i < k;i++)
                res[i] = list.get(i).index;

            return res;
        }

        public int binarySearch(int row[], int low,int high) {
            int count = 0;
            while(low <= high){
                int mid = (low + high) / 2;
                if(row[mid] == 1) {
                    count = mid + 1;
                    low = mid + 1;
                }
                else
                    high = mid - 1;
            }

            return count;
        }
    }

    public static void main(String args[]) {
        new Solution().kWeakestRows(new int[][]{ {1,0,0,0}, {1,1,1,1}, {1,0,0,0}, {1,0,0,0} }, 2);
    }
}
