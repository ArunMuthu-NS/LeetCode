package DP;

import java.util.HashMap;
import java.util.Map;

public class PushDominoes {
    static class Solution {
        public String pushDominoes(String dominoes) {
            int rIndex = -1;
            char res[] = new char[dominoes.length()];
            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Integer, Boolean> rTrack = new HashMap<>();

            for (int i = 0; i < dominoes.length(); i++) {
                res[i] = dominoes.charAt(i);
                rIndex = (dominoes.charAt(i) == 'R') ? i : rIndex;
                rTrack.put(rIndex, true);
                if (dominoes.charAt(i) == 'L') {
                    map.put(i, rIndex);
                    rIndex = -1;
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int l = entry.getKey(), r = entry.getValue();
                rTrack.put(r, false);
                if (r == -1) {
                    for (int i = l - 1; i >= 0 && res[i] == '.'; i--)
                        res[i] = 'L';
                } else {
                    int i = r + 1, j = l - 1;
                    while (i < j) {
                        res[i++] = 'R';
                        res[j--] = 'L';
                    }
                }
            }

            for (Map.Entry<Integer, Boolean> entry : rTrack.entrySet()) {
                if (entry.getValue() && entry.getKey() > -1) {
                    for (int i = entry.getKey() + 1; i < res.length && res[i] == '.'; i++)
                        res[i] = 'R';
                }
            }

            return new String(res);
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().pushDominoes("L.....RR.RL.....L.R."));
    }
}
