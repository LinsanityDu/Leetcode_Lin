/*Given a binary tree, return the bottom-up level order traversal of its nodes values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]*/

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	List<Integer> temp = new ArrayList<Integer>();
        	for (int i = 1; i <= size; i++) {
        		TreeNode node = queue.poll();
        		temp.add(node.val);
        		if (node.left != null) queue.offer(node.left);
        		if (node.right != null) queue.offer(node.right);
        	}
        	res.add(0, temp);
        }
        return res;
    }
}