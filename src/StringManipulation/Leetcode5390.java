package StringManipulation;

public class Leetcode5390 {
    static class Solution {

        public int charIndex(char val) {
            switch(val) {
                case 'c' : return 0;
                case 'r' : return 1;
                case 'o' : return 2;
                case 'a' : return 3;
                case 'k' : return 4;
            }
            return -1;
        }

        public int minNumberOfFrogs(String croakOfFrogs) {
            if(croakOfFrogs.length() % 5 > 0) return -1;
            int count[] = new int[5];
            int ans = 0;

            for(int i = croakOfFrogs.length() - 1;i >= 0;i--) {
                int index = charIndex(croakOfFrogs.charAt(i));
                if(index == -1) return -1;

                if(index == 0) {
                    for(int j = 1;j < count.length;j++)
                        if(count[j] > 0) count[j]--;
                        else return -1;
                    ans++;
                }
                else if(index + 1 < count.length){
                    if(count[index] < count[index + 1]) count[index]++;
                    else return -1;
                }
                else
                    count[index]++;
            }

            for(int x : count)
                if(x > 0) return -1;

            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minNumberOfFrogs("crcrocakroakoak"));
    }
}
