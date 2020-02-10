
/*
    Problem Link : https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
    Solution Link : https://leetcode.com/submissions/detail/301936265/
*/

public class AnagramConversion {

    static class Solution {
        public int minSteps(String s, String t) {
            int res = 0;
            char sMap[] = new char[26];
            char tMap[] = new char[26];

            for(char x : s.toCharArray())
                sMap[x - 'a']++;

            for(char x : t.toCharArray())
                tMap[x - 'a']++;

            for(int i = 0;i < tMap.length;i++){
                if(tMap[i] > 0){
                    res += (tMap[i] > sMap[i]) ? tMap[i] - sMap[i] : 0;
                }
            }

            return res;
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().minSteps("leetcode", "practice"));
        System.out.println(new Solution().minSteps("bab", "aba"));
        System.out.println(new Solution().minSteps("anagram", "mangaar"));
        System.out.println(new Solution().minSteps("xxyyzz", "xxyyzz"));
        System.out.println(new Solution().minSteps("friend", "family"));
    }
}
