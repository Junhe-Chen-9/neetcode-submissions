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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode reversed = reverse(secondHalf);
        ListNode firstHalf = head;
        while(reversed != null){
            ListNode p1Next = firstHalf.next;
            ListNode p2Next = reversed.next;
            firstHalf.next = reversed;
            reversed.next = p1Next;

            firstHalf = p1Next;
            reversed = p2Next;
        }
    }
    private ListNode reverse(ListNode head){
        // base case 
        if(head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
