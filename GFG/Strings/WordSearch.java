/*
Word Search
Medium

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
*/

class WordSearch {
    int R, C;
    private boolean util(char[][] board, int i, int j, String word, int index)
    {
        if(index == word.length())
            return true;

        if(i<0 || i>=R || j<0 || j>=C || board[i][j]!=word.charAt(index))
            return false;

        board[i][j] = '*';//so that it's not considered for other cases

        boolean res = util(board, i , j+1 , word, index+1 ) ||
                      util(board, i , j-1 , word, index+1 ) ||
                      util(board, i+1 , j , word, index+1 ) ||
                      util(board, i-1 , j , word, index+1 ) ;//in all directions

        board[i][j] = word.charAt(index);//backtrack

        return res;
    }
    public boolean exist(char[][] board, String word) {

        R = board.length;
        C = board[0].length;

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                if(util(board,i,j,word,0))
                    return true;

        return false;
    }
}