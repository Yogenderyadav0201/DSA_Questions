public  class MinCostJump{

    //using memoziation
    public static int mincostMemo(int cost[], int n){
        int dp[] = new int[n+1];
        if(n < 0) return 0;
        if(n==1 || n==0) return cost[n];

        if(dp[n] != 0) return dp[n];
        // System.out.println(cost[n-1]);
        dp[n] = cost[n-1] + Math.min(mincostMemo(cost, n-1), mincostMemo(cost, n-2));
        
        return Math.min(dp[n-1], dp[n-2]);

    }

    // using tabulization
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            if (i<2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
    public static void main(String arg[]){
        int cost[] = {10,15,20};
        int n = cost.length;
        // System.out.println(minCostClimbingStairs(cost));
        System.out.println(mincostMemo(cost, n));
    }
}