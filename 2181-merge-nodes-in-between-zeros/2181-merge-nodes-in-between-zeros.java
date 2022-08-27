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
    public ListNode mergeNodes(ListNode head) {
        
        if(head == null)
            return null;
        ListNode newnode = new ListNode(0);
        ListNode node = newnode;
        ListNode curr = head;
        while(curr.next != null)
        {
            if(curr.val == 0)
            {
                int sum = 0;
                while(curr.next.val != 0)
                {
                    sum += curr.next.val;
                    curr = curr.next;
                }
                node.next = new ListNode(sum);
                node = node.next;
            }
            curr = curr.next;
        }
        return newnode.next;   
        
        
    }
}