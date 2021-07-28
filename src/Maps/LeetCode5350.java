package Maps;

import java.util.*;

public class LeetCode5350 {
    static class Solution {

        class Power{
            int val;
            int power;

            Power(int val, int power) {
                this.val = val;
                this.power = power;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        public int getKth(int lo, int hi, int k) {
            List<Power> list = new ArrayList<>();
            while(lo <= hi)
                list.add(new Power(lo, calculatePower(lo++)));
            Collections.sort(list, (p1, p2) -> {
                if(p1.power < p2.power) return -1;
                else if(p1.power > p2.power) return 1;
                else if(p1.val < p2.val) return -1;
                else return 1;
            });

            return list.get(k - 1).val;
        }

        public int calculatePower(int val) {
            if(val == 1)
                return 0;
            if(map.get(val) != null)
                return map.get(val);
            if(val % 2 == 0)
                map.put(val, 1 + calculatePower(val / 2));
            else
                map.put(val, 1 + calculatePower((val * 3) + 1));
            return map.get(val);
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().getKth(1,1000, 777));
    }
}
