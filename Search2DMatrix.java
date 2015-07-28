/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
                if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return false;
        }
        // Search row
        int start = 0;
        int end = matrix.length - 1;
        int mid = start + (end - start) / 2;
        while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	if (matrix[mid][0] == target) {
        		return true;
        	} else if (matrix[mid][0] > target) {
        		end = mid;
        	} else {
        		start = mid;
        	}
        }
        if (matrix[start][0] == target || matrix[end][0] == target) {
        	return true;
        }
        // Search column
        int row = 0;
        if (target < matrix[start][0]) {
        	if (start > 0) {
        	   row = start - 1;
        	} else {
        	    row = 0;
        	}
        } else if (target > matrix[start][0] && target < matrix[end][0]) {
        	row = start;
        } else {
        	row = end;
        }
        start = 0;
        end = matrix[row].length - 1;
        while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	if (matrix[row][mid] == target) {
        		return true;
        	} else if (matrix[row][mid] > target) {
        		end = mid;
        	} else {
        		start = mid;
        	}
        }
        if (matrix[row][start] == target || matrix[row][end] == target) {
        	return true;
        }
        return false;

    }
}