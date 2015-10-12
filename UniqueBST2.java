/*Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3*/

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
     public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
    	List<TreeNode> res = new ArrayList<TreeNode>();
    	if (start > end) {
    		res.add(null);
    		return res;
    	}

    	for (int i = start; i <= end; i++) {
    		List<TreeNode> left = generate(start, i - 1);
    		List<TreeNode> right = generate(i + 1, end);
    		for (TreeNode l : left) {
    			for (TreeNode r : right) {
    				TreeNode root = new TreeNode(i);
    				root.left = l;
    				root.right = r;
    				res.add(root);
    			}
    		}

    	}
    	return res;
    }
}