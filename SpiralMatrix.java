/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].*/



public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int leftRow = 0;
        int leftCol = 0;
        int rightRow = matrix.length - 1;
        int rightCol = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;
        
        while (leftCol <= rightCol && leftRow <= rightRow) {
            for (int i = leftCol; i <= rightCol; i++) {
                res.add(matrix[leftRow][i]);
                if (res.size() == size) return res;
            }
            for (int i = leftRow + 1; i <= rightRow; i++) {
                res.add(matrix[i][rightCol]);
                if (res.size() == size) return res;
            }
            for (int i = rightCol - 1; i >= leftCol; i--) {
                res.add(matrix[rightRow][i]);
                if (res.size() == size) return res;
            }
            for (int i = rightRow - 1; i >= leftRow + 1; i--) {
                res.add(matrix[i][leftCol]);
                if (res.size() == size) return res;
            }
            leftRow++;
            leftCol++;
            rightRow--;
            rightCol--;
        }
        
        return res;
    }
}



public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) 
            return rst;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        while(count * 2 < rows && count * 2 < cols){
            for(int i = count; i < cols-count; i++)
                rst.add(matrix[count][i]);
            
            
            for(int i = count+1; i< rows-count; i++)
                rst.add(matrix[i][cols-count-1]);
            
            if(rows - 2 * count == 1 || cols - 2 * count == 1)  // if only one row /col remains
                break;
                
            for(int i = cols-count-2; i>=count; i--)
                rst.add(matrix[rows-count-1][i]);
                
            for(int i = rows-count-2; i>= count+1; i--)
                rst.add(matrix[i][count]);
            
            count++;
        }
        return rst;
    }
}