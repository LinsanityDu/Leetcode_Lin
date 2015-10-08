/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        } else if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}


// Discussion
public static int minDepth(TreeNode root) {
    if (root == null)   return 0;
    if (root.left == null)  return minDepth(root.right) + 1;
    if (root.right == null) return minDepth(root.left) + 1;
    return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
}

// BFS
public int minDepth(TreeNode root) {
    if (root == null){
        return 0;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    int depth = 1;
    while (!queue.isEmpty()){
        int size = queue.size(); // determine the loop size
        for (int i = 0; i< size; i++){
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null){
                return depth;
            }
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        depth ++;
    }
    return depth;
}