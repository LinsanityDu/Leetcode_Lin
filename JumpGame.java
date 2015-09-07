/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.*/

// DP

public class Solution {
    public boolean canJump(int[] nums) {
        // DP
        if (nums == null || nums.length == 0 || nums[0] == 0) {
            return false;
        }
        boolean[] state = new boolean[nums.length];
        state[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (state[j] && nums[j] >= i - j) {
                    state[i] = true;
                    break;
                }
            }
        }
        return state[nums.length - 1];
    }
}

// Greedy

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > res) {
                break;
            }
            res = Math.max(res, i + nums[i]);
            if (res >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
