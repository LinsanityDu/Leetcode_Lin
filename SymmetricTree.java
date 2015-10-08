/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.*/


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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return helper(root.left,root.right);
    }

    public boolean helper(TreeNode left,TreeNode right)
    {
        if(left==null && right!=null)
            return false;
        if(left!=null && right==null)
            return false;
        if(left==null && right==null)
            return true;
        return left.val==right.val && helper(left.left,right.right) && helper(left.right,right.left);
    }
}


// Recursive
public boolean isSymmetric(TreeNode root) {
    return root==null || isSymmetricHelp(root.left, root.right);
}

private boolean isSymmetricHelp(TreeNode left, TreeNode right){
    if(left==null || right==null)
        return left==right;
    if(left.val!=right.val)
        return false;
    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
}


// Iterative Pay attention to the order of pushing
public boolean isSymmetric(TreeNode root) {
    if (root == null)
        return true;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root.left);
    stack.push(root.right);
    while (!stack.isEmpty()) {
        TreeNode node1 = stack.pop();
        TreeNode node2 = stack.pop();
        if (node1 == null && node2 == null)
            continue;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val != node2.val)
            return false;
        stack.push(node1.left);
        stack.push(node2.right);
        stack.push(node1.right);
        stack.push(node2.left);
    }
    return true;
}