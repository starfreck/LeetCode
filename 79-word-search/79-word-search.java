class Solution {
     
    String word;
    boolean[][] state;
    
    public boolean exist(char[][] board, String word) {
        
        this.word = word;
        this.state = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            
            for(int j = 0; j < board[i].length; j++){
                
                if(dfs(board,i,j,0,state)){
                    
                    return true;
                    
                }
            }
        }
        return false;
    }


    private boolean dfs(char[][] board, int x, int y, int index, boolean[][] state){

    	if( x < 0 || y < 0 || x >= board.length || y >= board[x].length || state[x][y] || index >= word.length()) {
    		return false;
    	}

    	if(index == word.length()-1 && board[x][y] == word.charAt(index)){
            
    		return true;
    	}

    	if(board[x][y] == word.charAt(index)){
            
            state[x][y] = true;
            
    		// Right
    		if(
                dfs(board, x+1, y, index+1, state) || 
                dfs(board, x-1, y, index+1, state) || 
                dfs(board, x, y-1, index+1, state) || 
                dfs(board, x, y+1, index+1, state)
            ) {
              return true;  
            }
            
           state[x][y] = false;
    	}
        
        return false;

    }
}

// Time Complexity: O(?)
// Space Complexity: O(?)