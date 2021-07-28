package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode1046 {
    static class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int x : stones)
                pq.add(x);

            while(pq.size() > 1) {
                int firstStone = pq.poll();
                int secondStone = pq.poll();

                if(firstStone != secondStone) {
                    pq.add(firstStone - secondStone);
                }
            }

            return pq.isEmpty() ? 0 : pq.poll();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
