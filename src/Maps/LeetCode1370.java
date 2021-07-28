package Maps;

import java.util.Arrays;

public class LeetCode1370 {
    static class Solution {
        public String sortString(String s) {
            char resArr[] = new char[s.length()];

            char sArr[] = s.toCharArray();
            int map[] = new int[26];

            Arrays.sort(sArr);

            for(char x : sArr)
                map[x - 'a']++;

            int j = 0, limit = 26, val = 1;
            boolean toggle = true;
            for(int i = 0;i < s.length();){
                while(j != limit){
                    if(map[j] != 0){
                        resArr[i++] = (char)('a' + j);
                        map[j]--;
                    }
                    j += val;
                }
                j = (toggle) ? 25 : 0;
                limit = (toggle) ? -1 : 26;
                val = (toggle) ? -1 : 1;
                toggle = !toggle;
            }

            return new String(resArr);
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().sortString("kwgnfmmfngwk"));
    }
}
