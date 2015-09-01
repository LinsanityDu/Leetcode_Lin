/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?*/


// Extra O(N) Space

public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] res = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            res[nums[i]]++;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}



// Extra O(1) Space
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i || nums[i] >= nums.length) {
                continue;
            } else {
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
                i--;
            }
        }
        
        if (nums[0] != 0) return 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return i + 1;
            }
        }
        return nums.length;
    }
}