package Math;

public class Max69 {
    static class Solution {
        public int maximum69Number (int num) {
            int tenPower = 1, res = 0,n = num;
            boolean isChanged = true;
            while(n > 10){
                tenPower = tenPower * 10;
                n = n / 10;
            }

            while(num != 0) {
                if(num / tenPower == 6 && isChanged){
                    res += 9 * tenPower;
                    isChanged = false;
                }
                else
                    res += (num / tenPower) * tenPower;

                num = num % tenPower;
                tenPower = tenPower / 10;
            }

            return res;
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().maximum69Number(9669));
        System.out.println(new Solution().maximum69Number(9999));
        System.out.println(new Solution().maximum69Number(9996));
        System.out.println(new Solution().maximum69Number(96));
    }
}
