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
            // 연종이가 하루 동안 본 수
            int arr[] = new int[num1];
            for (int j =0; j<arr.length; j++){
                arr[j] = sc.nextInt();
            }
            int num2 = sc.nextInt();
            // 연종이가 봤다고 하는 수
            int arr2[] = new int[num2];
            for(int j =0; j<arr2.length; j++){
                arr2[j] = sc.nextInt();
            }

            // 연종이가 봤다는 주장하는 수 중 실제로 존재하는 수 인지 판단하기 위해
            // 이진탐색을 이용하여 존재여부를 판단한다
            // 2진탐색을 하기 위해서 연종이가 본 수를 정렬한다
            Arrays.sort(arr);
            // 연종이가 봤다고하는 수를 모두 비교 해봐야 하기 때문에 수 만큼 반복문
            for(int j =0; j<arr2.length; j++){
                // 실제로 본 수 중에 봤다고 주장하는 수가 없다면 0, 있다면 1
                if (Arrays.binarySearch(arr, arr2[j])<0)
                    System.out.println(0);
                else
                    System.out.println(1);
            }
        }
    }
}
