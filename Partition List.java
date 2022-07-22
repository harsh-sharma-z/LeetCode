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
    public ListNode partition(ListNode head, int x) {
        
        ListNode left=new ListNode(0);
        ListNode right = new ListNode(0);
        
        ListNode lTail=left;
        ListNode rTail=right;
        
        while(head!= null)
        {
            if(head.val<x)
            {
                lTail.next=head;
                lTail=lTail.next;
            }
            else
            {
                rTail.next=head;
                rTail=rTail.next;
            }
            
            head=head.next;
        }
        lTail.next=right.next;
        rTail.next=null;
            
            
            return left.next;
        
    }
}
