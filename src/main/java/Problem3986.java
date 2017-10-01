import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by geonheelee on 2017. 6. 23..
 */
public class Problem3986 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        int result = 0;

        while(tc-- > 0){

            Stack<Character> stack = new Stack<Character> ();

            String input = sc.next();

            for(int i = 0; i < input.length();i ++){
                //스택이 비어있지 않고 맨 위의 값이 문자열의 i번째와 같으면 값을 뺀다(좋은단어)
                if(!stack.isEmpty() && stack.peek() == input.charAt(i)){
                    stack.pop();
                }else{
                    //스택이 비어있거나 스택의 맨 위값과 문자열의 i번째와 다르면 값을 넣는다
                    stack.push(input.charAt(i));
                }
            }

            if(stack.isEmpty()){
                result ++;
            }
        }

        System.out.println(result);
    }
}
