/*Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        // Check every row
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (board[i][j] - '1' < 0 || board[i][j] - '9' > 0) {
                    return false;
                }
                if (!set.contains(board[i][j] - '0')) {
                    set.add(board[i][j] - '0');
                } else {
                    return false;
                }
            }
        }
        
        // Check every column
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (board[j][i] - '1' < 0 || board[j][i] - '9' > 0) {
                    return false;
                }
                if (!set.contains(board[j][i] - '0')) {
                    set.add(board[j][i] - '0');
                } else {
                    return false;
                }
            }
        }
        // Check every block
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j+= 3) {
                Set<Integer> set = new HashSet<Integer>();
                for (int k = 0; k < 9; k++) {
                    if (board[i + k / 3][j + k % 3] == '.') {
                        continue;
                    }
                    if (board[i + k / 3][j + k % 3] - '1' < 0 || board[i + k / 3][j + k % 3] - '9' > 0) {
                        return false;
                    }
                    if (!set.contains(board[i + k / 3][j + k % 3] - '0')) {
                        set.add(board[i + k / 3][j + k % 3] - '0');
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
        
    }
}