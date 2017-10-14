import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 7. 7..
 */
public class Problem10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int num = 0;
        int arr[] = new int[s.length()];
        for (int i =0; i<s.length(); i++){
            num += s.charAt(i) - 48;
            arr[i] = s.charAt(i) - 48;
        }
        String ans = "";
        Arrays.sort(arr);
        //30의 배수라는 것은 각 자리의 합이 3의 배수이고 일의자리가 0이라는 말이다.
        if (num%3==0 && arr[0]==0){
            //주어진 배열을 역순으로 출력.
            for (int i = arr.length-1; i>=0; i--){
                ans += arr[i]+"";
            }
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}
