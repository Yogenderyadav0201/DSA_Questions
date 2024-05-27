public class CoinsSum {
    
    public static int printSum(int coins[] , int sum, int n){
        int dp[][] = new int [n+1][sum+1];

        //i = coins,  j = changes/sum
        for(int i=0; i<coins.length+1; i++){
            dp[i][0] = 1;
        }
        for(int j=1; j<sum+1; j++){
            dp[0][j] = 0;
        }
        //O(n+sum)
        for (int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(coins[i-1] <= j){ //valid condition.
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]; //includ + exclude
                }
                else{ //invalid condition.
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];


    }

    public static void main(String arg[]){
        int coins[] = {1, 2, 3};
        int sum = 4;    
        int n = coins.length;

        System.out.println(printSum(coins, sum, n));
    }
}
