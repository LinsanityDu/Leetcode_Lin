/*Binary Tree Right Side View My Submissions Question Solution 
Total Accepted: 21550 Total Submissions: 74773 Difficulty: Medium
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].*/

// Divide and conquer
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        
        List<Integer> left = rightSideView(root.left);
        List<Integer> right = rightSideView(root.right);
        
        if (right.size() >= left.size()) {
            list.addAll(0, right);
            list.add(0, root.val);
        } else {
            for (int i = left.size()- 1; i > right.size() - 1; i--) {
                list.add(0, left.get(i));
            }
            list.addAll(0, right);
            list.add(0, root.val);
        }
        return list;
    }
}



// Traverse
/*
The core idea of this algorithm:

1.Each depth of the tree only select one node.
2. View depth is current size of result list.
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        traverse(result, root, 1);
        return result;
    }

    void traverse(List<Integer> result, TreeNode node, int level) {
        if (node == null) return;
        if (level > result.size()) {
            result.add(node.val);
        }
        traverse(result, node.right, level + 1);
        traverse(result, node.left, level + 1);
    }
}



// Level Order Traversal
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // reverse level traversal
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return result;

        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) result.add(cur.val);
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }

        }
        return result;
    }
}