import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 8. 18..
 */
public class Problem9465 {
    public static void main(String[] args) {
        int tc;
        int n;
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();
        for(int k = 0; k<tc; k++) {
            n = sc.nextInt();
            int[][] map = new int[2][n];
            for(int i = 0; i<2; i++) {
                for(int j = 0; j<n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int[][] dp = new int[2][n];
            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];
            dp[0][1] = dp[1][0] + map[0][1];
            dp[1][1] = dp[0][0] + map[1][1];
            for(int i = 2; i<n; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2])+map[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2])+map[1][i];
            }
            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }
    }
}
