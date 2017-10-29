import java.util.Scanner;

/**
 * Created by csk746(csk746@naver.com) on 2017. 10. 29..
 */
public class Problem10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] dp = new int[101][10];
        final int mod = 1000000000;
        // 1자리수는 자기밖에 없기 때문에 1로 초기화
        for (int i = 1; i<=9; i++){
            dp[1][i] = 1;
        }
        // 십의 자리가 2인경우 일의자리는 1,3이 가능하다.
        // 백의잡리가 3인경우 십의자리가 2,4 가 가능한데
        // 이는 십의자리가 2,4일때 밑의 경우의 수의 합이기 때문에
        // dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod; 라는 점화식이 나온다.
        // 앞의 자리가 1과 9같은경우 하위 수가 하나이기 때문에 예외처리한다

        for (int i = 2; i<=num; i++){
            for (int j = 0; j<=9; j++){
                if (j==0){
                    dp[i][0] += dp[i-1][1] % mod;
                    continue;
                }
                if(j==9){
                    dp[i][9] += dp[i-1][8] % mod;
                    continue;
                }

                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }
        int sum = 0;
        for (int i =0; i<=9; i++){
            sum = (sum + dp[num][i]) % mod;
        }
        System.out.println(sum%mod);
    }
}
