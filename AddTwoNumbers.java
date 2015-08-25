/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
        	return null;
        }
        if (l1 == null && l2 != null) {
        	return l2;
        }
        if (l1 != null && l2 == null) {
        	return l1;
        }
        ListNode dummy = new ListNode(0);
		ListNode res = dummy;


        int carry = 0;
        while (l1 != null && l2 != null) {
        	int val = (l1.val + l2.val + carry) % 10;
        	carry = (l1.val + l2.val + carry) / 10;
        	res.next = new ListNode(val);
        	res = res.next;
        	l1 = l1.next;
        	l2 = l2.next;
        }

        if (l1 != null) {
        	while (l1 != null) {
        		int val =(l1.val + carry) % 10;
        		carry = (l1.val + carry) / 10;
        		res.next = new ListNode(val);
        		res = res.next;
        		l1 = l1.next;
        	}
        }

        if (l2 != null) {
        	while (l2 != null) {
        		int val =(l2.val + carry) % 10;
        		carry = (l2.val + carry) / 10;
        		res.next = new ListNode(val);
        		res = res.next;
        		l2 = l2.next;
        	}
        }
        if (carry != 0) {
            res.next = new ListNode(carry);
        }

        return dummy.next;
    }
}




// Recursively

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }

    private ListNode helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return null;
            } else {
                return new ListNode(1);
            }
        } else if (l1 == null) {
            return helper(new ListNode(0), l2, carry);
        } else if (l2 == null) {
            return helper(l1, new ListNode(0), carry);
        } else {
            // both l1 and l2 have value
            int sum = l1.val + l2.val + carry;
            int resultNumber = sum % 10;
            int newCarry = sum / 10;
            ListNode ans = new ListNode(resultNumber);
            ans.next = helper(l1.next, l2.next, newCarry);
            return ans;
        }
    }
}



// Iteratively, More concise

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2, head = res;
        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                carry += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                carry += cur2.val;
                cur2 = cur2.next;
            }
            head.next = new ListNode(carry % 10);
            head = head.next;
            carry /= 10;
        }
        if (carry == 1)
            head.next = new ListNode(1);
        return res.next;
    }
}

