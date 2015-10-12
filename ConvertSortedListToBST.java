/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.*/

// My suck code
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {  
        //write your code here
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            TreeNode root = new TreeNode(head.val);
            return root;
        }
        if (head.next.next == null) {
            TreeNode root = new TreeNode(head.val);
            TreeNode right = new TreeNode(head.next.val);
            root.right = right;
            return root;
        }
        ListNode mid = findMiddle(head);
        TreeNode root = new TreeNode(mid.next.val);
        TreeNode right = sortedListToBST(mid.next.next);
        mid.next = null;
        TreeNode left = sortedListToBST(head);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            pre = pre.next;
            fast = fast.next.next;
        }
        return pre;
    }
}


// Nine Chapter
  private ListNode current;

    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size;

        current = head;
        size = getListLength(head);

        return sortedListToBSTHelper(size);
    }

    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }


// Another Discussion
public TreeNode sortedListToBST(ListNode head) {
   return sortedListToBST(head, null);
}
private TreeNode sortedListToBST(ListNode head, ListNode tail){
    if(head == null || head == tail)
        return null;
    if(head.next == tail)
        return new TreeNode(head.val);
    ListNode fast = head, slow = head;
    while(fast!=tail && fast.next!=tail){
        fast = fast.next.next;
        slow = slow.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(head, slow);
    root.right = sortedListToBST(slow.next, tail);
    return root;
}