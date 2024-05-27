public class RodCutting {
    
    public static int totalrodCutting(int length[], int price[], int TotalLenght){
        int n = length.length;
        int dp[][] = new int[n+1][TotalLenght+1];
        //this is the inilization
        for(int i=0; i<n+1; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<TotalLenght+1; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<TotalLenght+1; j++){
                if(length[i-1] <= j){
                    dp[i][j] = Math.max((price[i-1] + dp[i-1][j-length[i-1]]) , dp[i-1][j]);
                }

                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        printDP(dp);
        return dp[n][TotalLenght];
    }

    public static void printDP(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String arg[]){
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int TotalLenght = 8;


        System.out.println(totalrodCutting(length, price, TotalLenght));
    }
}
