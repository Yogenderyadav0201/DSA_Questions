import java.util.Arrays;

public class MarixChainMultiplication {
    
    public static int MCM(int arr[] , int i, int j){
        if(i == j){
            return 0; //single matrix
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int cost1 = MCM(arr, i, k);
            int cost2 = MCM(arr, k+1, j);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }

        return ans; 
    }

    public static int MCMMemoziation(int arr[], int i, int j, int dp[][]){
        if(i == j){
            return 0;//for single matrix
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int cost1 = MCMMemoziation(arr, i, k, dp);
            int cost2 = MCMMemoziation(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans;
    }

    public static void main(String arg[]){
        int arr[] = {1,2,3,4,3};
        int n = arr.length;

        int dp[][] = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        // System.out.println(MCM(arr, 1, n-1));
        System.out.println(MCMMemoziation(arr, 1, n-1, dp));

    }
}
