package StringManipulation;

/*
    Problem Link : https://leetcode.com/problems/split-a-string-in-balanced-strings/
    Solution Link : https://leetcode.com/submissions/detail/295037739/
*/

public class BalancedStrings {
    static class Solution {
        public int balancedStringSplit(String s) {
            int l = 0, r = 0, count = 0;
            char res[] = s.toCharArray();
            for(char x : res) {
                if(x == 'L') l++;
                if(x == 'R') r++;
                if(l == r){
                    count++;
                    l = r = 0;
                }
            }

            return count;
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().balancedStringSplit("RLRRLLRLRL"));
    }
}
