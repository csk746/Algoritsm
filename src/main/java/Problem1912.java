import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by csk746(csk746@naver.com) on 2017. 10. 22..
 */
public class Problem1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int arr[] = new int[num];
        for (int i = 0; i< num; i++){
            arr[i] = sc.nextInt();
        }
        //가장 큰수와 두 번째로 큰 수를 더하면 되기 때문에
        //정렬을 한 뒤 가장 뒤 인덱스, 그 이전 인덱스의 값을 더해준다.
        Arrays.sort(arr);
        int sum = arr[arr.length-1]+arr[arr.length-2];
        System.out.println(sum);
    }
}
