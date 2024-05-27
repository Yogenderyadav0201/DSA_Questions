
public class MiniPartitioning {
    
    public static int MinPart(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }

        int weight = sum/2;
        int dp[][] = new int[n+1][weight+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<weight+1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][weight];
        int sum2 = sum - sum1;
        
        //if we need to check mini. diff is zero
        // if(sum1 == weight){
        //     return true;
        // }
        // else{
        //     return false;
        // }

        //we need to find the min. diff.
        return Math.abs(sum1 - sum2);
    }
    public static void main(String arg[]){
        int arr[] = {1,6,11,5};
        // int arr[] = {1,2,3};

        System.out.println(MinPart(arr));
    }
}
