import java.util.Scanner;

/**
 * Created by csk746(csk746@naver.com) on 2017. 10. 22..
 */
public class Problem2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        int ans = 0;

        ans =(int) Math.ceil((double)(v-a)/(double)(a-b)+1);
        System.out.println(ans);

    }
}
