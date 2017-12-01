/**
 * Created by csk746(csk746@naver.com) on 2017. 11. 4..
 */
public class woowa_01 {
    /*
    양수 V가 주어진다.
    2가지 액션이 주어진다
    V가 홀수면 1을 뺀다
    V가 짝수면 2로 나눈다
    V가 0이 될 때 까지 반복한다.
    처음값으로 28이 주어딘다면 7스텝 뒤에 0이 된다.
    N개의 문자로 이루어진 String으로 주어진다
    String 은 2진
     */
    public static void main(String[] args) {
        System.out.println(solution("11"));
    }
    public static int solution(String S) {
        // write your code in Java SE 8
        int num = 0;
        int  seq = 1;

        for (int i = (S.length()-1); i>=0; i--){
            num += (S.charAt(i)-48)*seq;
            seq*=2;
        }

        int count = 0;

        while (true){

            if (num%2 ==0)
                num/=2;

            else if (num%2==1){
                num-=1;
            }

            count++;

            if (num==0)
                break;
        }

        return count;
    }
}
