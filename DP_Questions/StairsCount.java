import java.util.*;
public class StairsCount {
    
    public static int countWays(int n){ // this is recursion
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        return countWays(n-1) + countWays(n-2);
    }

    public static int countwaysMemozation(int n, int ways[]){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        if(ways[n] != -1){
            return ways[n];
        }

        ways[n] =  countwaysMemozation(n-1, ways) + countwaysMemozation(n-2, ways);

        return ways[n];
    }

    public static int countwaysTablutions(int n){
        int ways[] = new int[n+1];
        ways[0] = 1;

        for(int i=1; i<=n; i++){
            if( i == 1){
                ways[i] = ways[i-1] + 0;
            }
            else{
                ways[i] = ways[i-1] + ways[i-2];
            }
            
        }

        return ways[n];
    }
    public static void main(String arg[]){
        int n = 5;
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1); //by default in java a empty array have 0 value on each index but this function we update with -1 on each index
        // System.out.println(countWays(n));
        // System.out.println(countwaysMemozation(n, ways));
        System.out.println(countwaysTablutions(n));
    }
}
