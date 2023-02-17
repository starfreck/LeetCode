class Solution {

    HashMap<Integer,HashSet<Character>> rows = new HashMap<>();
    HashMap<Integer,HashSet<Character>> cols = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            
            for(int j = 0; j < 9; j++){

                if(rows.get(i) == null){
                    rows.put(i,new HashSet<Character>());
                }

                if(cols.get(j) == null){
                    cols.put(j,new HashSet<Character>());
                }

                if(rows.get(i).contains(board[i][j]) || cols.get(j).contains(board[i][j]) || checkSmallSquare(board,i,j) ){
                    return false;
                } else {
                    if(board[i][j] != '.'){
                        rows.get(i).add(board[i][j]);
                        cols.get(j).add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    private boolean checkSmallSquare(char[][] board, int i, int j){

        if( 
            (i == 0 && j == 0) || (i == 0 && j == 3) || (i == 0 && j == 6) ||
            (i == 3 && j == 0) || (i == 3 && j == 3) || (i == 3 && j == 6) ||
            (i == 6 && j == 0) || (i == 6 && j == 3) || (i == 6 && j == 6)
        ){
            HashSet<Character> smallSquare = new HashSet<>();
            for(int k = i; k < i+3; k++){
                for(int l = j; l < j+3; l++){
                    if(board[k][l] != '.'){
                        if(smallSquare.contains(board[k][l])){
                            return true;
                        }
                        smallSquare.add(board[k][l]);
                    }
                }
            }
        }
        return false;
    }
}
// Time Complexity: O(n^4)
// Space Complexity: O(n)