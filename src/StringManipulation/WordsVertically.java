package StringManipulation;

import java.util.ArrayList;
import java.util.List;

public class WordsVertically {
    static class Solution {
        public List<String> printVertically(String s) {
            String arr[] = s.split(" ");
            int index = 0, pos = -1;
            StringBuffer sb = null;

            List<String> result = new ArrayList<>();
            do{
                sb = new StringBuffer();
                pos = -1;
                for(int i = 0;i < arr.length;i++) {
                    if(index < arr[i].length()) {
                        sb.append(arr[i].charAt(index));
                        pos = sb.length() - 1;
                    }
                    else
                        sb.append(" ");
                }

                if(pos != -1)
                    result.add(sb.substring(0,pos + 1).toString());
                index++;
            }while(pos != -1);
            return result;
        }
    }

    public static void main(String args[]) {
        System.out.println(new Solution().printVertically("HOW ARE YOU"));
        System.out.println(new Solution().printVertically("TO BE OR NOT TO BE"));
        System.out.println(new Solution().printVertically("CONTEST IS COMING"));
    }
}
