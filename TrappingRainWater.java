/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.*/


public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int res = 0;
        while (start < height.length && height[start] == 0) {
            start++;
        }
        while (end >= 0 && height[end] == 0) {
            end--;
        }
        int prev;
        while (start < end) {
            if (height[start] <= height[end]) {
                prev = height[start];
                while (start < end && height[start] <= prev) {
                    res += prev - height[start];
                    start++;
                }
            } else {
                prev = height[end];
                while (start < end && height[end] <= prev) {
                    res += prev - height[end];
                    end--;
                }
            }
        }
        return res;
    }
}