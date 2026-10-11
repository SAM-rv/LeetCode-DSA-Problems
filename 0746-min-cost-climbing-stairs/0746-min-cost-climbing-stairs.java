class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        java.util.Arrays.fill(dp,-1);
        return Math.min(climbing(0,cost,dp),climbing(1,cost,dp));
    }

    public int climbing(int i,int[] cost,int[] dp){
        if(i>=cost.length)
        return 0;

        if(dp[i]==-1){
            dp[i]=cost[i]+Math.min(climbing(i+1,cost,dp),climbing(i+2,cost,dp));
        }
        return dp[i];
    }
}