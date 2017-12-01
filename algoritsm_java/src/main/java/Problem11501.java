import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 7. 7..
 */
public class Problem11501 {
    public static void main(String[] args) {
        // 1 4 5 3 1 2
        // 1 1 2 3 4 5
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i<tc; i++){
            int count = sc.nextInt();
            int arr[] = new int[count];
            int tempArr[] = new int[count];
            int ans = 0;
            for (int j = 0; j<count; j++){
                arr[j] = sc.nextInt();
                tempArr[j] = arr[j];
            }
            Arrays.sort(tempArr);

            int max = tempArr[count-1];
            tempArr[count-1] = 0;
            for(int j =0; j<count; j++){
                Arrays.sort(tempArr);
                if (arr[j] == max){
                    max = tempArr[count-1];
                    tempArr[count-1]=0;

                } else {
                    ans += max - arr[j];
                    int idx = Arrays.binarySearch(tempArr,arr[j]);
                    tempArr[idx] = 0;
                }
            }
            System.out.println(ans);

        }
    }
}
