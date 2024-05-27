public class particesQuestion1 {
    
    public static boolean equalSum(int nums[]){
        int n = nums.length;
        int sum = 0;
        int TargetSum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }
        if(sum%2 != 0){ 
            return false;
        }
        else{
            TargetSum = sum/2;
        }

        boolean dp[][] = new boolean[n+1][TargetSum+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<TargetSum+1; j++){
                int v = nums[i-1];
                if(v <= j && dp[i-1][j-v]== true){
                    dp[i][j] = true;
                }
                else if(dp[i-1][j]== true){
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][TargetSum];
    }
    
    public static void main(String[] args) {
        int nums[] = {1,2,3,5};
        System.out.println(equalSum(nums));
    }
}
