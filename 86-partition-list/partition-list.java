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
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode ans = small;
        ListNode link = large;
        while(head != null){
            ListNode temp = new ListNode(head.val);
            if(head.val < x){
                small.next = temp;
                small = temp;
            }
            else{
                large.next = temp;
                large = temp;
            }
            head = head.next;
        }
        small.next = link.next;
        large.next = null;
        return ans.next;
    }
}