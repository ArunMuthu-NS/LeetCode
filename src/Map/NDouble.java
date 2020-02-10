package Map;

import java.util.HashMap;

public class NDouble {
    static class Solution {
        public boolean checkIfExist(int[] arr) {
            HashMap<Integer,Integer> map = new HashMap<>();

            for(int i = 0;i < arr.length;i++)
                map.put(arr[i], i);

            for(int i = 0;i < arr.length;i++)
                if(map.get(arr[i] * 2) != null && map.get(arr[i] * 2) != i) return true;

            return false;
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
    }
}
