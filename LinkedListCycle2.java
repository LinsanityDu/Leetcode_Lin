/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow =  head;
        ListNode fast = head.next;
        while (slow != fast) {
        	if (fast == null || fast.next == null) {
        		return null;
        	}
        	slow = slow.next;
        	fast = fast.next.next;
        }

        while (head != slow.next) {
        	head = head.next;
        	slow = slow.next;
        }

        return head;
        
    }
}