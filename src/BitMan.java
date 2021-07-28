public class BitMan {
    static class Solution {
        public int numSteps(String s) {
            int carry = 0, steps = 0, res;

            for(int i = s.length() - 1;i >= 0;i--) {
                res = ((s.charAt(i) == '1' && carry == 1)  || (s.charAt(i) == '0' && carry == 0)) ? 0 : 1;

                if(s.charAt(i) == '1' && i == 0 && carry == 0){
                    break;
                }
                if(res == 1) {
                    steps += 2;
                    carry = 1;
                }
                else {
                    steps++;
                }
            }

            return steps;
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().numSteps("1101"));
        System.out.println(new Solution().numSteps("1"));
        System.out.println(new Solution().numSteps("10"));
    }
}
