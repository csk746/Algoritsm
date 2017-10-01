import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 4. 8..
 */
public class Problem_1003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int arr[] = new int[num];

        for (int i=0; i<num; i++){
            arr[i] = scanner.nextInt();
        }
        for (int a: arr) {
            fibonacci(a);
            System.out.println(zero+" "+one);
            one=0;
            zero=0;
        }

    }
    static int one=0;
    static int zero=0;
    public static int fibonacci(int n){
        if(n==0){
//            System.out.printf("0");
            zero++;
            return 0;
        } else if (n==1){
            one++;
//            System.out.printf("1");
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
