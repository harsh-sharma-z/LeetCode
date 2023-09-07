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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)
            return head;
        ListNode start = null , end = null , curr = head;
        int c = 0;
        while(curr != null){
            c++;
            if(c == left)
                break;
            start = curr;
            curr = curr.next;
        }
        ListNode startNext = curr;

        while(curr != null){
            if(c == right)
                break;
            c++;
            curr = curr.next;
        }

        end = curr.next;
        curr.next = null;

        startNext = rev(startNext);

        if(start == null)
            head = startNext;
        else
            start.next = startNext;

        while(startNext.next != null)
            startNext = startNext.next;

        startNext.next = end;

        return head;
    }
    private ListNode rev(ListNode head){
        ListNode curr = head , prev = null , next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}