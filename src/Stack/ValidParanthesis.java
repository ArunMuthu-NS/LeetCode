package Stack;

import java.util.Collections;
import java.util.Stack;

public class ValidParanthesis {

    static class Solution {
        public boolean checkValidString(String s) {
            char arr[] = s.toCharArray();
            return check(arr, 0, 0);
        }

        public boolean check(char[] arr, int index, int open) {
            if(open < 0) return false;
            if(index >= arr.length && open == 0) return true;

            if(arr[index] == '(') {
                open++;
                return check(arr, index + 1, open);
            }
            else if(arr[index] == ')') {
                if(open == 0) return false;
                open--;
                return check(arr, index + 1, open);
            }
            else{
                return check(arr, index + 1, open) || check(arr, index + 1, open + 1) || check(arr, index + 1, open - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString("()"));
    }
}
