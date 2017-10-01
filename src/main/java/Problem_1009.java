import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 4. 8..
 */
public class Problem_1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        int a[] = new int[testCount];
        int b[] = new int[testCount];
        for (int i = 0; i < testCount; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < testCount; i++) {
            int start = a[i];
            int end = b[i];
            int cal = start;
            if (end != 1) {
                for (int j = 0; j < end - 1; j++) {
                    cal = cal * start % 10;
                    if (cal==0)
                        cal=10;
                }
            } else {
                cal = start % 10;
                if (cal==0)
                    cal=10;
            }
            System.out.println(cal);
        }
    }
}
