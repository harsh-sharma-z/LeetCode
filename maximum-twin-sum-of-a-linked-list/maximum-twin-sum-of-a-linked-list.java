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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        slow=slow.next;
        Stack<Integer> uwu=new Stack<>();
        while(slow!=null)
        {
            uwu.push(slow.val);
            slow=slow.next;
        }

        int ans=Integer.MIN_VALUE;

        while(!uwu.isEmpty())
        {
            ans=Math.max(ans,head.val+uwu.pop());
            head=head.next;
        }
        return ans;
        
    }
}