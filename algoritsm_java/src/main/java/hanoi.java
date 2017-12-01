/**
 * Created by geonheelee on 2017. 9. 17..
 */
public class hanoi {
    public static void main(String[] args) {
        move(3,'A','B','C');
    }
    static void move(int n, char start, char mid, char end){

        if (n == 1) {
            System.out.println(n + " 이동 " + start + " 부터 " + end + "까지");
        } else {
            move(n-1, start, end, mid);
            System.out.println(n + " 이동 " + start + " 부터 " + end + "까지");
            move(n-1, mid, start, end);
        }

    }
}
