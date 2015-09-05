/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]*/

public class Solution {
    public int[][] generateMatrix(int n) {
       
        int[][] res = new int[n][n];
        if (n == 0) return res;
        int count = 0;
        int ele = 1;
        while (count * 2 < n) {
            for (int i = count; i < n - count; i ++) {
                res[count][i] = ele;
                ele ++;
            }
            
            for (int i = count + 1; i < n - count; i ++) {
                res[i][n-count-1] = ele;
                ele ++;
            }
            
            if (n - 2 * count == 1) break;
            
            for (int i = n - count - 2; i >= count; i --) {
                res[n-count-1][i] = ele ;
                ele ++;
            }
            
            for(int i = n-count-2; i>= count+1; i--) {
                res[i][count]= ele;
                ele ++;
            }
            
            count++;
        }
        
        return res;
    }
}