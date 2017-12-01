import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 5. 17..
 */
public class Problem11048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int map[][] = new int[1005][1005];
        int dp[][] = new int[1005][1005];
        for (int i =1; i<=N; i++){
            for (int j =1; j<=M;j++){
                map[i][j] = sc.nextInt();
            }
        }
        for (int i =1; i<=N; i++){
            for (int j =1; j<=M;j++){
                //이전 움직임중 대각선, 왼쪽, 오른쪽으로 가는 것중 최고값과
                //지금 값을 더한 값을 dp값으로 산정한다
                //dp[i][j]는 i, j일때 최대값이기 때문에 다음 수에서 이 d[i][j]와
                //그 다음 비용을 더하면 된다.
                dp[i][j] = max(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]) + map[i][j];
            }
        }
        System.out.println(dp[N][M]);

    }
    static int max(int n, int m, int l){

        int max =0;
        if (n > max)
            max = n;
        if (m > max)
            max = m;
        if (l > max)
            max = l;
        return max;
    }
}
