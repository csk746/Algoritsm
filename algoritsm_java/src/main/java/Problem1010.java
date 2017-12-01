import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 5. 25..
 */
public class Problem1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int ii = 0; ii < N; ii++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[][] c = new int[a+1][b+1];
            for (int i =0; i<=b; i++){
                c[1][i]=i;
            }
            for (int i = 2; i<=a; i++)
                for (int j =i; j<=b; j++)
                    for (int k=j; k>=i; k--) {
                        c[i][j] += c[i - 1][k - 1];
//                        System.out.println(c[i][j]);
            }
            System.out.println(c[a][b]);
        }
    }
}
