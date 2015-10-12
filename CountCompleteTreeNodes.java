/*Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.*/




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
    public int countNodes(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}

    	int left = getLeft(root) + 1;
    	int right = getRight(root) + 1;

    	if (left == right) {
    		return (2 << (right - 1)) - 1;
    	} else {
    		return countNodes(root.left) + countNodes(root.right) + 1;
    	}
    }

    public int getLeft(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}

    	int height = 0;
    	while (root.left != null) {
    		height++;
    		root = root.left;
    	}
    	return height;
    }

    public int getRight(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}

    	int height = 0;
    	while (root.right != null) {
    		height++;
    		root = root.right;
    	}
    	return height;
    }
}
// Discussion
public class Solution {

  public int countNodes(TreeNode root) {
    if (root == null)
      return 0;

    int hLeft = getHeight(root.left);
    int hRight = getHeight(root.right);

    if (hLeft == hRight)
      return (1 << hLeft) + countNodes(root.right);
    else
      return (1 << hRight) + countNodes(root.left);

  }

  int getHeight(TreeNode root) {
    if (root == null)
      return 0;

    return 1 + getHeight(root.left);
  }

}


// Pochman God
class Solution {
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int nodes = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h-1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }
}