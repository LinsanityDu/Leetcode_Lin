/*Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]*/

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        dfs(res, new String(), root);
        return res;
    }
    
    public void dfs(List<String> res, String temp, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            temp += root.val;
            res.add(new String(temp));
            temp = temp.substring(0, temp.length() - 1);
            return;
        }
        temp = temp + root.val + "->";
        dfs(res, temp, root.left);
        dfs(res, temp, root.right);
        temp = temp.substring(0, temp.length() - 3);
    }
}