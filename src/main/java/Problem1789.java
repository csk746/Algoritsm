import java.util.Scanner;

/**
 * Created by csk746(csk746@naver.com) on 2017. 11. 4..
 */
public class Problem1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int index = (int) Math.sqrt(2*num);
        while (true){
            if (index*(1+index) < 2*num){
                break;
            }
            index--;
        }
        if (num==1)
            index = 1;
        System.out.println(index);
    }
}
