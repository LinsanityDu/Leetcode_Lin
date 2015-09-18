/*Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X*/

// My stackoverflow DFS solution
public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs1(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs1(board, i, board[0].length - 1);
            }
        }
        for (int i = 1; i < board[0].length - 1; i++) {
            if (board[0][i] == 'O') {
                dfs1(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs1(board, board.length - 1, i);
            }
        }
        
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
    
    private void dfs1(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X' || board[row][col] == '1') {
            return;
        }
        board[row][col] = '1';
        dfs1(board, row, col - 1);
        dfs1(board, row, col + 1);
        dfs1(board, row - 1, col);
        dfs1(board, row + 1, col);
    }
}




// BFS can pass (Pay attention to Matrix position transformation)
public class Solution {
   public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int lenx = board.length;
        int leny = board[0].length;
        for (int i = 0; i < lenx; i++) {
            if (board[i][0] == 'O') bfs(board, i, 0);
            if (board[i][leny - 1] == 'O') bfs(board, i, leny - 1);
        }
        for (int i = 0; i < leny; i++) {
            if (board[0][i] == 'O') bfs(board, 0, i);
            if (board[lenx - 1][i] == 'O') bfs(board, lenx - 1, i);
        }

        for (int i = 0; i < lenx; i ++) {
            for (int j = 0; j < leny; j ++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        for (int i = 0; i < lenx; i ++) {
            for (int j = 0; j < leny; j ++) {
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }

    }

    public void bfs(char[][] board, int x, int y) {
        int lenx = board.length;
        int leny = board[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Integer> queue = new LinkedList<Integer>();
        board[x][y] = '1';
        queue.offer(x * leny + y);
        while(!queue.isEmpty()) {
            int id = queue.poll();
            int x1 = id / leny;
            int y1 = id % leny;
            for (int i = 0; i < 4; i++) {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];
                if (x2 >= 0 && x2 < lenx && y2 >= 0 && y2 < leny && board[x2][y2] == 'O') {
                    board[x2][y2] = '1';
                    queue.offer(x2 * leny + y2);
                }
            }
        }
    }
}