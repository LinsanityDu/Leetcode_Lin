/*Given an integer array of size n, find all elements that appear more than 
⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.*/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int number1 = nums[0];
        int number2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (count1 == 0) {
                number1 = num;
                count1++;
            } else if (count2 == 0 && num != number1) {
                number2 = num;
                count2++;
            } else {
                if (num == number1) {
                    count1++;
                } else if (num == number2) {
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == number1) {
                count1++;
            } else if (num == number2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) res.add(number1);
        if (count2 > nums.length / 3) res.add(number2);
        return res;
    }
}