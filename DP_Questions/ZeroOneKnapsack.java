public class ZeroOneKnapsack {
    
    public static int knapsack(int val[], int wt[], int w, int i){
        if(w == 0 || i == 0){
            return 0;
        }

        if(wt[i-1] <= w){
            //inculde
            int ans1 = val[i-1] + knapsack(val, wt, w-wt[i-1], i-1); // profit of curr value + max profit of next values.

            //exclude
            int ans2 = knapsack(val, wt, w, i-1);

            return Math.max(ans1, ans2);
        }
        else{
            return knapsack(val, wt, w, i-1);
        }
    }

    // Using memoization
    public static int memiozation(int val[], int wt[], int w, int i, int DP[][]){
        if(i==0 || w==0){
            return 0;
        }

        if(DP[i][w] != -1){// it mean we alrady calculate the max value of DP[n][w] index
            return DP[i][w];
        }

        if(wt[i-1] <= w){
            int ans = val[i-1] + memiozation(val, wt, w-wt[i-1], i-1, DP);

            int ans1 = memiozation(val, wt, w, i-1, DP);

            DP[i][w] = Math.max(ans, ans1);
            return DP[i][w];

        }
        else{
            DP[i][w] = memiozation(val, wt, w, i-1, DP);
            return DP[i][w];
        }
    }



    public static int Tabliation(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        //initilzation 0th index. 
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        //initilzation 1st index.
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        // now check one by one calculate the profit of index.
        //we start from 1 st index bcz at 0 index we fill 0 values.
        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                int v = val[i-1]; //ith item val
                int w = wt[i-1]; //ith item weight

                if(w <= j){ // valid condition, mean total weight is less than the jth index weight.
                    int incprofit = v + dp[i-1][j-w];

                    int excprofit = dp[i-1][j];

                    dp[i][j] = Math.max(incprofit, excprofit);
                   
                }
                else{ // invalid condition
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W]; // value of the last index element
    }


    public static void main(String args[]){
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int w = 7;
        int DP[][] = new int[val.length+1][w+1];
        for(int i=0; i<DP.length; i++){
            for(int j=0; j<DP[0].length; j++){
                DP[i][j] = -1;
            }
        }
        System.out.println(knapsack(val, wt, w, val.length)); 
        System.out.println(memiozation(val, wt, w, val.length, DP));
        System.out.println(Tabliation(val, wt, w));
    }
}
