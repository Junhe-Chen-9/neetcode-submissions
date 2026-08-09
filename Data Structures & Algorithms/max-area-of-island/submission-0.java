class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1){
                    int size = explore(grid,i,j);
                    res = Math.max(res,size);
                }
            }
        }
        return res;
    }
    private int explore(int[][] grid, int i, int j){
        // base case 
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if(grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        int up = explore(grid,i + 1,j);
        int bot = explore(grid,i - 1,j);
        int left = explore(grid,i,j + 1);
        int right = explore(grid,i,j - 1);
        return up + bot + left + right + 1;
    }
}
