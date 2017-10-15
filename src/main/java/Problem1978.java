import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 10. 15..
 */
public class Problem1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=0;
        int numofNumber = sc.nextInt();
        for (int i = 0; i < numofNumber; i++) {
            int num = sc.nextInt();
            //소수이면 1증가
            if (sosu(num)) {
                count++;
            }
        }
        System.out.println(count);

    }
    public static boolean sosu(int num){
        //1이면 소수가 아니다.
        if (num!=1) {
            // 2부터 돌면서 나누어 떨어지는지 판단.
            for (int i = 2; i < num; i++) {
                if (num%i==0) {
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }
}
