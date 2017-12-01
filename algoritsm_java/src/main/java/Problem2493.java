import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Problem2493 {

    public static void main(String[] args) throws IOException {
        Stack<Integer> st = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //타워의 갯수
        int towerCnt = sc.nextInt();
        //각 타워의 높이를 담는 배열
        int[] height = new int[towerCnt + 1];
        //결과를 담는 배열
        int[] result = new int[towerCnt + 1];

        for(int i=1;i<=towerCnt;i++) {
            height[i] = sc.nextInt();
        }
        //왼쪽부터 카운트 하기 때문에 인덱스가 카운트 개수부터
        for(int i=towerCnt;i>=1;i--){
            //스택이 비어있지 않고 스택의 맨 위 타워의 높이가 현재 타워의 높이보다 낮은 경우
            //스택에 타워를 하나씩 넣는데 뽑아서 비교를 했을때
            //더 크다는 것은 신호를 수신한다는 말이다
            //예를들어 문제의 ( 6 9 5 7 4 ) 경우
            //스택에 5(위),7이 들어있는경우 9와 비교할때
            //먼저 5와 9를 비교하고 5가 작기 때문에 9의 인덱스를 정답에 넣는다
            //그 뒤 7과 9를 비교하는데 다시 7이 작기 때문에 9의 인덱스를 정답에 넣는다.
            //만약 9가 아니라 6이었다면 ( 6 6 5 7 4 )
            //5와 6을 비교해서 5가 더 작기 때문에 6의 인덱스를 정답에 넣고
            //그 뒤 6과 7을 비교하여 7이 더 크기 때문에 정답에 넣지 않고 6의 인덱스를 스택에 넣는다
            while(!st.isEmpty() && height[st.peek()] < height[i]){
                result[st.pop()] = i;
            }
            st.push(i);
        }
        for(int i=1;i<=towerCnt;i++){
            System.out.print(result[i]+" ");
        }
    }
}