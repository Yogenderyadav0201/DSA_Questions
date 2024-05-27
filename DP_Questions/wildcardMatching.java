public class wildcardMatching {
    
    public static boolean matches(String str, String pattern){

        int n = str.length();
        int m = pattern.length();

        boolean dp[][] = new boolean[n+1][m+1];

        //initialzation
        dp[0][0] = true;
        //if pattern string is empty
        for(int i=1; i<n+1; i++){
            dp[i][0] = false;
        }
        //if String is empty
        for(int j=1; j<m+1; j++){
            //now we check if pattern have '*' 
            if(pattern.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        //Fill bottom to up
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] ||  dp[i][j-1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        
        //print the DP.
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();


        return dp[n][m];
    }

    public static void main(String arg[]){
        String s = "abc";
        String p = "**?b*";

        System.out.println(matches(s, p));
    }
}
