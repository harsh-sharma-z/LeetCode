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
         public static ListNode swapNodes_tp(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        int cnt = 0;
		
        while (left != null) {
            cnt++;
            if (cnt == k) {
                break;
            }
            left = left.next;
        }

	
        ListNode pNode = left;
        while (pNode.next != null) {
            pNode = pNode.next;
            right = right.next;
        }

		
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;
        
    }
}
