import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 5. 23..
 */
public class Problem2042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        int[][] arr2 = new int[3][M+K];

        for (int i = 0; i< M+K; i++){
            for (int j =0; j<3; j++){
                arr2[j][i] = sc.nextInt();
            }
        }
    }
}
