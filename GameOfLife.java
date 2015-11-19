/*According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?*/

/*To solve it in place, we use 2 bits to store 2 states:

[2nd bit, 1st bit] = [next state, current state]

- 00 dead (current) -> dead (next)
- 01 live (current) -> dead (next)
- 10 dead (current) -> live (next)
- 11 live (current) -> live (next)
In the beginning, every 2nd state is 0; when next becomes alive change 2nd bit to 1:

live -> die: nbs < 2 || nbs > 3 (we don't need to care!)
live -> live: nbs >= 2 && nbs <= 3
dead -> live: nbs == 3
To get this state, we simple do:

board[i][j] & 1
To get next state, we simple do:

board[i][j] >> 1
Hope this helps!*/


public class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dir ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int live=0;
                for(int[] d:dir){
                    if(d[0]+i<0 || d[0]+i>=board.length || d[1]+j<0 || d[1]+j>=board[0].length) continue;
                    if(board[d[0]+i][d[1]+j]==1 || board[d[0]+i][d[1]+j]==2) live++;
                }
                if(board[i][j]==0 && live==3) board[i][j]=3;
                if(board[i][j]==1 && (live<2 || live>3)) board[i][j]=2;
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] %=2; // Good thought
            }
        }
    }
}


