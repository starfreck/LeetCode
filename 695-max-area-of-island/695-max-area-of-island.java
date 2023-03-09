class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    int result = DFS(grid,i,j);
                    count = Math.max(count,result);
                }
            }
        }
        return count;
        
    }
    
    public int DFS(int[][] grid, int x, int y){

        if(x < 0 || y < 0 || x > grid.length-1 || y > grid[x].length-1){
            return 0;
        }
        
        if(grid[x][y] != 1){
            return 0;
        }
        
        grid[x][y] = -1;
        
        return 1 + DFS(grid,x+1,y) + DFS(grid,x-1,y) + DFS(grid,x,y-1) + DFS(grid,x,y+1);
        
       
        
    }
}