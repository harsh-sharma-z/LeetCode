/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left=head;;
        ListNode right=head;
        int c=0;
        while(left.next!=null)
        {
            c++;
            if(c==k)
            break;
            left=left.next;
        }
        ListNode extra=left;
        while(extra.next!=null)
        {
            extra=extra.next;
            right=right.next;
        }
        int temp=left.val;
        left.val=right.val;
        right.val=temp;
        return head;
    }
}