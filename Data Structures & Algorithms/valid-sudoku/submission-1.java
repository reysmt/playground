class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int rows = 0; rows < 9; rows++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++){
                if(board[rows][i] == '.') continue;
                if(seen.contains(board[rows][i])) return false;
                seen.add(board[rows][i]);
            }
        }

        for(int columns = 0; columns < 9; columns++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++){
                if(board[i][columns] == '.') continue;
                if(seen.contains(board[i][columns])) return false;
                seen.add(board[i][columns]);
            }
        }

        for(int squares = 0; squares < 9; squares++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++ ){
                    int row = (squares / 3) * 3 + i;
                    int col = (squares % 3) * 3 + j;
                    if(board[row][col] == '.') continue;
                    if(seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
