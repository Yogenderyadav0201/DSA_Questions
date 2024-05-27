public class LongestCommanString {
    /*
     * A Substring is a contiguous sequence of character within a string.
     */
    public static int LCString(String str1, String str2, int n, int m){ // using tabulations 
        //step - 1 
        int dp[][] = new int[n+1][m+1];
        int ans = 0;
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1;j++){
                dp[i][j] = 0;
            }
        }      

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        } 
        return ans;
    }


    public static void main(String arg[]){
        String str1 = "ABCDGH";
        String str2 = "ACDGHR"; //output = 4 // "CDGH"
        int n = str1.length();
        int m = str2.length();

        System.out.println(LCString(str1, str2, n, m));

    }
}
