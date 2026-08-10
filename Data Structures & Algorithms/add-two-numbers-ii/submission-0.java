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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            p.next = newNode;
            p = p.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry > 0){
            p.next = new ListNode(1);
        }
        return reverse(dummy.next);

    }
    private ListNode reverse(ListNode list){
        // base case 
        if(list == null || list.next == null) return list;
        ListNode newHead = reverse(list.next);
        list.next.next = list;
        list.next = null;
        return newHead;
    }
}