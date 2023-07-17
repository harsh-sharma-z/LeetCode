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
    private int size(ListNode a){
        int ans = 0;
        while(a!=null){
            a = a.next;
            ans++;
        }
        return ans;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s1 = size(l1);
        int s2 = size(l2);

        ListNode res = null;
        ListNode temp = null;

        while(l1 != null || l2 != null) {
            int v1 = 0;
            int v2 = 0;

            if(s1 >= s2){
                v1 = l1 != null ? l1.val : 0;
                l1 = l1.next;
                s1--;
            }
            if(s2 >= s1 + 1){
                v2 = l2 != null ? l2.val : 0;
                l2 = l2.next;
                s2--;
            }

            temp = new ListNode(v1 + v2);
            temp.next = res;
            res = temp;
        }

        int c = 0;
        res = null;

        while(temp != null) {
            temp.val += c;
            if(temp.val >= 10){
                temp.val %= 10;
                c = 1;
            }
            else
                c = 0;

            ListNode extra = temp.next;
            temp.next = res;
            res = temp;
            temp = extra;
        }

        if(c > 0){
            temp = new ListNode(1);
            temp.next = res;
            res = temp;
        }

        return res;
    }
}