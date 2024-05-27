public class LongestCommanSubseq {
    
    @SuppressWarnings("unused")
    /*
     * In Longest Comman Subsequence we take without continous form means we can add the char without any sequence.
     * step for Longest Comman Subsequence
     * step -1
     * create the 2D array
     * 
     * step-2
     * initializat the zero index.
     * 
     * step-3
     * run lop n+1, m+1 index.
     * for valid condition
     * if str1(i-1) == str2(j-1) than we minus in both lenghts of string and add one in result bcz for matched chara.
     * else we find max value b/w minus in one length and second one and find the max both tham.
     * 
     * step-4
     * return dp[n][m] bcz at end of the matrix we have answer.
     */
    public static int LCS(String str1, String str2, int n, int m){ // using tabulation

        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }   
            }
        }
    

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    int ans1 = dp[i-1][j];
                    int asn2 = dp[i][j-1];

                    dp[i][j] = Math.max(ans1, asn2);
                }
            }
        }

        return dp[n][m];
    }

    public static int LCSMemoization(String str1, String str2, int i, int j, int dp[][]){
        //base case
    
        if(i == 0 || j == 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(str1.charAt(i-1) == str2.charAt(j-1)){
            return dp[i][j] = LCSMemoization(str1, str2, i-1, j-1, dp) + 1;
        }
        else{
            int ans1 = LCSMemoization(str1, str2, i-1, j, dp);
            int ans2 = LCSMemoization(str1, str2, i, j-1, dp);

            return dp[i][j] = Math.max(ans1, ans2);
        }
    }

    public static void main(String arg[]){
        String str1 = "abcdge";
        String str2 = "abedg";  //output is 4 == "abdg"
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(LCS(str1, str2, n, m));
        System.out.println(LCSMemoization(str1, str2, n, m, dp));
    }
}
