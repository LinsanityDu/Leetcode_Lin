


public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] order = new int[nums.length];
        int[] reverse = new int[nums.length];
        order[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            order[i] = nums[i] * order[i - 1];
        }
        reverse[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            reverse[i] = nums[i] * reverse[i + 1];
        }

        int[] res = new int[nums.length];
        res[0] = reverse[1];
        res[nums.length - 1] = order[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = order[i - 1] * reverse[i + 1];
        }

        return res;
    }
}