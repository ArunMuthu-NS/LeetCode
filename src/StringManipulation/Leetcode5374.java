package StringManipulation;

public class Leetcode5374 {
    static class Solution {

        char valMap[][] = {
                {'b', 'c'},
                {'a', 'c'},
                {'a', 'b'}
        };

        public String getHappyString(int n, int k) {
            char res[] = new char[n];
            int noOfStrs = calculateNoOfStrs(n);

            if(k > noOfStrs) return "";

            int low = fillRoot(res, noOfStrs, k);
            fillSubTrees(res, n, k, 1, low,low + (noOfStrs / 3));

            return new String(res);
        }

        public int calculateNoOfStrs(int n) {
            int noOfStrs = 3;
            for(int i = 2;i <= n;i++)
                noOfStrs = noOfStrs * 2;
            return noOfStrs;
        }

        public int fillRoot(char[] arr, int noOfStrs, int k) {
            noOfStrs = noOfStrs / 3;
            if(1 <= k && k <= noOfStrs){
                arr[0] = 'a';
                return 1;
            }
            else if(noOfStrs + 1 <= k && k <= (noOfStrs * 2)){
                arr[0] = 'b';
                return noOfStrs + 1;
            }
            else{
                arr[0] = 'c';
                return (noOfStrs * 2) + 1;
            }
        }

        public void fillSubTrees(char[] arr, int n, int k, int index, int low, int high) {
            if(index >= n) return;

            char prev = arr[index - 1];
            int size = (high - low) + 1;
            int mid = low + (size / 2) - 1;
            if(low <= k && k <= mid) {
                arr[index] = valMap[prev - 'a'][0];
                fillSubTrees(arr,n,k,index + 1, low, mid);
            }
            else {
                arr[index] = valMap[prev - 'a'][1];
                fillSubTrees(arr,n,k,index + 1, mid + 1, high);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHappyString(3, 9));
    }
}
