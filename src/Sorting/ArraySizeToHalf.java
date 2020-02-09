package Sorting;

import java.util.*;

public class ArraySizeToHalf {
    static class Solution {
        public int minSetSize(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int x : arr)
                map.put(x, map.getOrDefault(x, 0) + 1);

            List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
            Collections.sort(list, (o1, o2) -> {
                if(o1.getValue() > o2.getValue()) return -1;
                if(o1.getValue() < o2.getValue()) return 1;
                return 0;
            });

            int size = 0, len = arr.length;
            for(Map.Entry<Integer, Integer> entry : list){
                len = len - entry.getValue();
                size++;
                if(len <= (arr.length/ 2))
                    break;
            }

            return size;
        }
    }

    public static void main(String args[]){
        System.out.println(new Solution().minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
        System.out.println(new Solution().minSetSize(new int[]{7,7,7,7,7,7}));
        System.out.println(new Solution().minSetSize(new int[]{1,9}));
        System.out.println(new Solution().minSetSize(new int[]{1000,1000,3,7}));
        System.out.println(new Solution().minSetSize(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }
}
