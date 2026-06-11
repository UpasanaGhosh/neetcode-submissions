class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[i].length; j++){
                if(dfs(i, j, board, word, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int r, int c, char[][] board, String word, int idx){
        // 1. sucess scenario
        if(idx == word.length()){
            return true;
        }

        // 2. Exit conditions
        if(r < 0 || r >= board.length || c < 0 || c >= board[r].length
        || board[r][c] != word.charAt(idx) || board[r][c] == '#' ){
            return false;
        }

        // 3. board[r][c] == word.charAt(idx), so we mark it as '#'
        char temp = board[r][c];
        board[r][c] = '#';

        // 4. call dfs on all cells in up, down, left and right direction
        boolean res = dfs(r + 1, c, board, word, idx + 1) 
        || dfs(r - 1, c, board, word, idx + 1)
        || dfs(r, c + 1, board, word, idx + 1)
        || dfs(r, c - 1, board, word, idx + 1);

        // 5. Reset the cell for bactracking
        board[r][c] = temp;

        // 6. return the result after exploring all the routes from curr cell
        return res;
    }
}
