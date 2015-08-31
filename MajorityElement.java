/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.*/


public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int number = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                number = num;
                count++;
            } else {
                if (num == number) {
                    count++; 
                } else {
                    count--;
                }
            }
        }
        return number;
    }
}