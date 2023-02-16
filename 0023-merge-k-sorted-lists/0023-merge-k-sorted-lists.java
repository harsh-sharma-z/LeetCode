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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((o1,o2)->o1.val-o2.val);
        for(ListNode i: lists)
            if(i!=null)
                pq.add(i);
        ListNode Dummy=new ListNode();
        ListNode temp=Dummy;
        while(!pq.isEmpty())
        {
            ListNode r=pq.poll();
            Dummy.next=r;
            Dummy=Dummy.next;
            if(r.next!=null)
                pq.add(r.next);
        }
        return temp.next;
    }
}