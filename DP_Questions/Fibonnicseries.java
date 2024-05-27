public class Fibonnicseries{

    public static int fibo(int n, int f[]){ // this memiozation
        if(n == 0 || n == 1){
            return n;
        }

        if(f[n] != 0){ //check f[1], f[2], f[3].... are calculated and not.
            return f[n];
        }
        
        f[n] = fibo(n-1, f) + fibo(n-2, f);
        // System.err.println(f[n]);
        return f[n];
    }

    public static int fiboTabulation(int n){ //O(n) Linear Time complxty
        int Dp[] = new int[n+1];
        Dp[0] = 0;
        Dp[1] = 1;
        for(int i=2; i<=n; i++){
            Dp[i] = Dp[i-1] + Dp[i-2]; 
        }

        return Dp[n];
    }
    public static void main(String arg[]){
        int n = 6;
        int f[] = new int[n+1];
        System.out.println(fibo(n, f));
        System.out.println(fiboTabulation(n));
    }
}