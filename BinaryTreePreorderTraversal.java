/*Given a binary tree, return the preorder traversal of its nodes values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?*/



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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return res;
    }
}



// Recursive
public class Solution {
    List<Integer> traversal = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null){helper(root);}
        return traversal;
    }

    void helper (TreeNode root){
        traversal.add(root.val);
        if(root.left!=null){helper(root.left);}
        if(root.right!=null){helper(root.right);}

    }
}