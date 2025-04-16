
class Pair{
    public int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }   
        if (!(other instanceof Pair)) {
            return false;
        }
        Pair p = (Pair) other;
        if(this.x == p.x && this.y == p.y){
            return true;
        }
        return false;
    }
}

class Solution {
    private int rows, cols;
    private HashSet<Pair> set;

    public int maxAreaOfIsland(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.set = new HashSet<>();
        int area = 0;

        for(int r=0; r < this.rows; r++){
            for(int c=0; c < this.cols; c++){
                if(grid[r][c] == 1){
                    area = Math.max(area, this.dfs(grid,r,c));
                } 
            }
        }
        return area;
    }
    
    private int dfs(int[][] grid, int r, int c){
        if(r < 0 || r >= this.rows || c < 0  || c >= this.cols || grid[r][c] == 0 || this.set.contains(new Pair(r,c))) {
            return 0;
        }
        this.set.add(new Pair(r,c));
        return 1 + 
            this.dfs(grid,r+1,c) + 
            this.dfs(grid,r-1,c) + 
            this.dfs(grid,r,c-1) + 
            this.dfs(grid,r,c+1);
    }
}