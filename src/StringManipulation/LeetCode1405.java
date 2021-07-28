package StringManipulation;

public class LeetCode1405 {
    static class Solution {

        public int checkMax(int map[], int alreadyInserted) {
            int index = -1, max = 0;
            for(int i = 0;i < map.length;i++) {
                if(map[i] > max && alreadyInserted != i) {
                    index = i;
                    max = map[i];
                }
            }

            return index;
        }

        public void insert(StringBuffer sb, int index, int map[], int count) {
            char val = (char)('a' + index);
            while(map[index] > 0 && count > 0){
                sb.append(val);
                count--;
                map[index]--;
            }
        }

        public String longestDiverseString(int a, int b, int c) {
            int alreadyInserted = -1;
            int map[] = new int[3];
            StringBuffer sb = new StringBuffer();

            map[0] = a; map[1] = b; map[2] = c;

            while(true) {
                int index = checkMax(map, alreadyInserted);
                if(index == -1) break;
                int count = (alreadyInserted != -1 && (map[index] < map[alreadyInserted])) ? 1 : 2;
                insert(sb,index,map,count);
                alreadyInserted = index;
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestDiverseString(0,8,11));
    }
}