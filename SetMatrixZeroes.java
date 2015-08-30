/*Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?*/


public class Solution {
    public void setZeroes(int[][] matrix) {
        // Space O(m + n)
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (row[i] == 0) {
                        row[i] = 1;
                    }
                    if (column[j] == 0) {
                        column[j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        return;
    }
}


// Space O(1)
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return;
        boolean rowflag=false;//记录第一行是否会变成0
        boolean colflag=false;//记录第一列是否会变成0
        //判断第一行是否会变成0
        for(int i=0;i<matrix[0].length;i++)
        {
            if(matrix[0][i]==0)
            {
                rowflag=true;
                break;
            }
        }
        //判断第一列是否会变成0
        for(int j=0;j<matrix.length;j++)
        {
            if(matrix[j][0]==0)
            {
                colflag=true;
                break;
            }
        }
        //用第一行和第一列的位置来存放该行，该列是否应该变成0
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        //将应该变为0的行和列变为0
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }

        //判断第一行是否要变为0
        if(rowflag==true)
        {
            for(int i=0;i<matrix[0].length;i++)
                matrix[0][i]=0;
        }

         //判断第一列是否要变为0
        if(colflag==true)
        {
            for(int i=0;i<matrix.length;i++)
                matrix[i][0]=0;
        }

        return;
    }
}