import java.util.Arrays;

/**
 * Created by csk746(csk746@naver.com) on 2017. 11. 3..
 */
public class CodilityTest {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3};
        System.out.println(solution(a));
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        if (A[A.length-1] < 1){
            return 1;
        }
        for (int i = 0; i < A.length; i++){
            if (Arrays.binarySearch(A,i+1) < 0){
                return i+1;
            }
        }
        return A[A.length-1]+1;
    }
}
