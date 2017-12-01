/**
 * Created by csk746(csk746@naver.com) on 2017. 11. 4..
 */
public class wooa_04 {
    public static void main(String[] args) {
        int a[] = {1,2,5,9,9,10,11};
        System.out.println(solution(a,11));
    }
    static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] >= X) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
}
