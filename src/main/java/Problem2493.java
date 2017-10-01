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
        int towerCnt = sc.nextInt();
        int[] height = new int[towerCnt + 1];
        int[] result = new int[towerCnt + 1];

        for(int i=1;i<=towerCnt;i++) {
            height[i] = sc.nextInt();
        }

        for(int i=towerCnt;i>0;i--){
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