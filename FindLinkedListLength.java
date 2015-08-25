/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/

public class Solution {
	public int findLength(ListNode head) {
		int res = 0;
		if (head == null) {
			return res;
		}
		while (head != null) {
			res++;
			head = head.next;
		}
		return res;
	}
}


public class Solution {
	public int findLength(ListNode head) {
		if (head == null) {
			return 0;
		}
		return findLength(head.next) + 1;
	}
}