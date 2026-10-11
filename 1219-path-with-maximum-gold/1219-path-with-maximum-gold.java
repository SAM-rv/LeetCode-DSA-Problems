class Solution {
    int result;
    public int getMaximumGold(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)
                continue;
                travel(i,j,grid,0);
            }
        }
        return result;
    }

    public void travel(int i,int j,int[][] grid,int path){
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0 || grid[i][j]==0){
            result=Math.max(result,path);
            return;
        }

        path+=grid[i][j];
        int temp=grid[i][j];
        grid[i][j]=0;

        travel(i+1,j,grid,path);
        travel(i-1,j,grid,path);
        travel(i,j+1,grid,path);
        travel(i,j-1,grid,path);

        grid[i][j]=temp;
        path-=grid[i][j];
    }

}