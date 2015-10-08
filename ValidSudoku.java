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



// Another
public boolean isValidSudoku(char[][] board) {
    for (int i=0; i<9; i++) {
        if (!isParticallyValid(board,i,0,i,8)) return false;
        if (!isParticallyValid(board,0,i,8,i)) return false;
    }
    for (int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if (!isParticallyValid(board,i*3,j*3,i*3+2,j*3+2)) return false;
        }
    }
    return true;
}
private boolean isParticallyValid(char[][] board, int x1, int y1,int x2,int y2){
    Set singleSet = new HashSet();
    for (int i= x1; i<=x2; i++){
        for (int j=y1;j<=y2; j++){
            if (board[i][j]!='.') if(!singleSet.add(board[i][j])) return false;
        }
    }
    return true;
}