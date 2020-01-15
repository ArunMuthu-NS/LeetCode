package Array;

public class DecompressRunLengthEncoding {

    static class Solution {
        public int[] decompressRLElist(int[] nums) {
            int len = 0;
            for(int i = 0;i < nums.length;i += 2)
                len += nums[i];

            int res[] = new int[len];
            int k = 0;
            for(int i = 0;i < nums.length;i += 2)
                for(int j = 0;j < nums[i];j++)
                    res[k++] = nums[i + 1];

            return res;
        }
    }

    public static void main(String args[]){
        int ans[] = new Solution().decompressRLElist(new int[]{42,39});
        for(int x : ans)
            System.out.print(x + " ");
        System.out.println();
    }
}
