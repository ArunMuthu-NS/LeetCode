package LinkedList;

/*
    Problem Link : https://leetcode.com/problems/middle-of-the-linked-list/
    Solution Link : https://leetcode.com/submissions/detail/290956407/
*/

public class FindingMiddleNode {
    static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }

    public static void main(String args[]) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        System.out.println(new Solution().middleNode(list).val);
    }
}
