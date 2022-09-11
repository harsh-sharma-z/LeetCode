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
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode curr=head;int count=0;int check=0;
		   

             while (curr!=null){
                count++;
                curr=curr.next;
             }

             if(count==n){
                 return head.next;
             }

            curr=head;  
            int p=count-n;
			
            for(int i=0;i<p;i++){
                check++;
                if(p==check){
                    curr.next=curr.next.next;
                    return head;
                }
                curr=curr.next; 
            }
             
             return head;
    }
}