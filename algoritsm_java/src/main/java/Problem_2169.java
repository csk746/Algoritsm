import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 4. 22..
 */
public class Problem_2169 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);


        int x = sc.nextInt();
        int y = sc.nextInt();
        int i = x;
        int j = x;
        int map[][] = new int[x+1][y+1];
        int dp[][] = new int[x+1][y+1];
        int max[][] = new int[2][y+2];

        for(i=1;i<=x;i++)
            for(j=1;j<=y;j++)
                map[i][j] = sc.nextInt();

        dp[1][1] = map[1][1];
        for(i=2;i<=y;i++) dp[1][i] = dp[1][i-1] + map[1][i];

        for (i = 2; i <= x; i++) {
            max[0][0] = dp[i - 1][1];
            for (j = 1; j <= y; j++)
                max[0][j] = Math.max(max[0][j - 1], dp[i - 1][j]) + map[i][j];

            max[1][y + 1] = dp[i - 1][y];
            for (j = y; j >= 1; j--)
                max[1][j] = Math.max(max[1][j + 1], dp[i - 1][j]) + map[i][j];

            for(j=1;j<=y;j++)
                dp[i][j] = Math.max(max[0][j], max[1][j]);
        }
        System.out.println(dp[x][y]);
    }
}
