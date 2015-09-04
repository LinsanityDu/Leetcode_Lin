/*Given a binary tree and a sum, find all root-to-leaf paths where each paths sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        dfs(res, new ArrayList<Integer>(), sum, root);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> temp, int sum, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            temp.add(root.val);
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        temp.add(root.val);
        dfs(res, temp, sum - root.val, root.left);
        dfs(res, temp, sum - root.val, root.right);
        temp.remove(temp.size() - 1);
        
    }
}