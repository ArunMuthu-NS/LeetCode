package Array;

public class EvenNumberDigits {
    static class Solution{
        public int findNumbers(int arr[]) {
            int ans = 0;
            for(int x : arr)
                if(countDigits(x) % 2 == 0)
                    ans++;
            return ans;
        }

        private int countDigits(int x) {
            int c = 0;
            while(x != 0){
                c++;
                x /= 10;
            }
            return c;
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().findNumbers(new int[]{12,345,2,6,7896}));
    }
}
