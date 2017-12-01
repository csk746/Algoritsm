import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 5. 2..
 */
public class Problem2579 {

    static int dp[] = new int[301];
    static int stair[] = new int[301];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        for(int i=1; i<cnt+1; i++){
            stair[i]=sc.nextInt();
        }
        dp[1] = stair[1];
        dp[2] =dp[1]+stair[2];
        dp[3] = max(stair[2]+stair[3],stair[1]+stair[3]);
        for(int i=4; i<cnt+1; i++){
            dp[i] = max(dp[i-2]+stair[i],dp[i-3]+stair[i]+stair[i-1]);
        }
        System.out.println(dp[cnt]);

    }
    static int max(int n, int m){
        if(n>=m)
            return n;
        else
            return m;
    }
}
