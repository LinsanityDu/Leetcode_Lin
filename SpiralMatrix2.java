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


// Discussion
public static int[][] generateMatrix(int n) {
    int[][] ret = new int[n][n];
    int left = 0,top = 0;
    int right = n -1,down = n - 1;
    int count = 1;
    while (left <= right) {
        for (int j = left; j <= right; j ++) {
            ret[top][j] = count++;
        }
        top ++;
        for (int i = top; i <= down; i ++) {
            ret[i][right] = count ++;
        }
        right --;
        for (int j = right; j >= left; j --) {
            ret[down][j] = count ++;
        }
        down --;
        for (int i = down; i >= top; i --) {
            ret[i][left] = count ++;
        }
        left ++;
    }
    return ret;
}


// C++ solution
class Solution {
    public:
        vector<vector<int> > generateMatrix(int n) {
            vector<vector<int> > ret( n, vector<int>(n) );
            int k = 1, i = 0;
            while( k <= n * n )
            {
                int j = i;
                    // four steps
                while( j < n - i )             // 1. horizonal, left to right
                    ret[i][j++] = k++;
                j = i + 1;
                while( j < n - i )             // 2. vertical, top to bottom
                    ret[j++][n-i-1] = k++;
                j = n - i - 2;
                while( j > i )                  // 3. horizonal, right to left 
                    ret[n-i-1][j--] = k++;
                j = n - i - 1;
                while( j > i )                  // 4. vertical, bottom to  top 
                    ret[j--][i] = k++;
                i++;      // next loop
            }
            return ret;
        }
    }