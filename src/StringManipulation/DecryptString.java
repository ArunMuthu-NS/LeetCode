package StringManipulation;

/*
    Problem Link : https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
    Solution Link : https://leetcode.com/submissions/detail/291647439/
*/

public class DecryptString {
    static class Solution {
        public String freqAlphabets(String s) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < s.length();){
                if(i + 2 < s.length() && s.charAt(i + 2) == '#'){
                    int a = s.charAt(i) - '0';
                    a = (a * 10) + (s.charAt(i + 1) - '0');
                    sb.append((char)('a' + a - 1));
                    i += 3;
                }
                else{
                    sb.append((char)('a' + (s.charAt(i) - '0') - 1));
                    i += 1;
                }
            }

            return sb.toString();
        }
    }

    public static void main(String args[]) {
        String test[] = new String[]{
                "10#11#12",
                "1326#",
                "25#",
                "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
        };
        for(String t : test)
            System.out.println(new Solution().freqAlphabets(t));
    }
}
