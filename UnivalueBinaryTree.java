/*Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.*/

// Pochman God Helper all tells whether all nodes in the given tree have the given value. And while doing that, it also counts the uni-value subtrees. Hi, Stefan. Really amazing code! I am still playing with it to see its mechanism :-) A little question: why replacing | with || gives the wrong answer?

// Update: I now see that | does not short-circuit the right operand and thus the counting will be on, right?

public class Solution {
    int count = 0;
    boolean all(TreeNode root, int val) {
        if (root == null)
            return true;
        if (!all(root.left, root.val) | !all(root.right, root.val))
            return false;
        count++;
        return root.val == val;
    }
    public int countUnivalSubtrees(TreeNode root) {
        all(root, 0);
        return count;
    }
}



// Discussion Solution
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] counter = new int[1];
        count(root, counter, root.val);
        return counter[0];
    }

    private boolean count(TreeNode root, int[] counter, int val) {
        if (root == null) {
            return true;
        }
        boolean l = count(root.left, counter, root.val);
        boolean r = count(root.right, counter, root.val);

        if (l && r) {
            counter[0]++;
        }

        return l && r && root.val == val;
    }

}

// Another Discussion
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private boolean helper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}