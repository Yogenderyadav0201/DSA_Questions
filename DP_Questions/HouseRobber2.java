import java.util.Arrays;
public class HouseRobber2 {
    
    public static int Robbercount(int arr[], int n, int dp[]){
        
        if(n >= arr.length){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        
        int yes = arr[n] + Robbercount(arr, n+2, dp);
        int no = Robbercount(arr, n+1, dp);

        return dp[n] = Math.max(yes, no);
    }

    public static void main(String arg[]){
        int nums[] = {1,2,3};
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(Robbercount(nums, 0, dp));
    }
}
