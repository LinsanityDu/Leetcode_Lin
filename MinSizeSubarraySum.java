/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        int localSum = 0;
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = i;
        while (i < nums.length) {
            while (j < nums.length) {
        		localSum += nums[j];
        		if (localSum >= s) {
        			res = Math.min(res, j - i + 1);
        			localSum = localSum - nums[i] - nums[j];
        			break;
        		} else {
        			j++;
        		}
        	}
        	i++;	
        }
        if (res == Integer.MAX_VALUE) {
        	return 0;
        }
        return res;
    }
}