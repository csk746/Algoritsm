import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 6. 23..
 */
public class Problem2776 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++){
            int num1 = sc.nextInt();
            int arr[] = new int[num1];
            for (int j =0; j<arr.length; j++){
                arr[j] = sc.nextInt();
            }
            int num2 = sc.nextInt();
            int arr2[] = new int[num2];
            for(int j =0; j<arr2.length; j++){
                arr2[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            for(int j =0; j<arr2.length; j++){
                if (Arrays.binarySearch(arr, arr2[j])<0)
                    System.out.println(0);
                else
                    System.out.println(1);
            }
        }
    }
}
