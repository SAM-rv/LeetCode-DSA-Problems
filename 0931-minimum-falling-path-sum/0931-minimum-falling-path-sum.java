class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int result=Integer.MAX_VALUE;
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        java.util.Arrays.fill(dp[i],Integer.MAX_VALUE);
        for(int i=0;i<matrix[0].length;i++){
            result=Math.min(result,path(0,i,matrix,dp));
        }
        return result;
    }

    public int path(int i,int j,int[][] matrix,int[][] dp){
        if(i==matrix.length)
        return 0;
        if(i<0 || j<0 || j>=matrix[0].length)
        return Integer.MAX_VALUE;

        if(dp[i][j]==Integer.MAX_VALUE){
        dp[i][j]=matrix[i][j]+Math.min(path(i+1,j,matrix,dp),Math.min(path(i+1,j+1,matrix,dp),path(i+1,j-1,matrix,dp)));
        }
        return dp[i][j];
    }
}