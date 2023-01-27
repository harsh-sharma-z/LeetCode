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
    public ListNode sortList(ListNode head) {
        if(head==null)
            return head;
        
        if(head.next==null)
        {
            return head;
        }
        
        
        ListNode middle, l1,l2;
        
        
        middle=findMiddle(head);
        
        l1=head;
        l2=middle.next;
        middle.next=null;
        l1=sortList(l1);
        l2=sortList(l2);
        
        return merge(l1,l2);
    }
    
    private ListNode merge(ListNode l1,ListNode l2)
    {
        ListNode preHead=new ListNode(0),cur=preHead;
        
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                cur.next=l1;
                l1=l1.next;
            }
            else
            {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        
        
        if(l1==null)
            cur.next=l2;
        else
            cur.next=l1;
        
        return preHead.next;
    }
    
    private ListNode findMiddle(ListNode head){
        if(head==null)
            return head;
        
        ListNode slow=head,fast=head;
        
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
}