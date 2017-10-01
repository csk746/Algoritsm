import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 5. 5..
 */
public class Problem9520 {
    static int num;
    static int map[][];
    static int dp[] = new int[num+1];
    static int minNum = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        map = new int[num+1][num+1];
        int buffer[] = new int[num*2+1];
        int left = num, right = num;

        for (int i = 1; i < num + 1; i++){
            for(int j = 1; j < num +1; j++){
                map[i][j] = sc.nextInt();
            }
        }

        buffer[left] = 1;
        System.out.println(dp(buffer,2,right+1,left,1));

    }

    static int dp(int buffer[], int newNum, int right, int left ,int direction){
        int nBuffer[] = new int[buffer.length];
        for (int i=0; i<buffer.length; i++)
            nBuffer[i] = buffer[i];

        if (direction ==1 ){
            nBuffer[right] = newNum;
        } else {
            nBuffer[left] = newNum;
        }

//        for(int i =0; i<buffer.length; i++){
//            System.out.print(nBuffer[i]+" ");
//        }
//        System.out.println();

        int sum =0;
        for(int i=0; i<nBuffer.length-1; i++){
            sum+=map[nBuffer[i]][nBuffer[i+1]];
        }
        if (sum >= minNum){
            return Integer.MAX_VALUE;
        }
        if (newNum == num ){
            if (minNum > sum)
                minNum = sum;
            return sum;
        } else {
            newNum++;
            int r = dp(nBuffer, newNum, right+1, left, 1);
            int l = dp(nBuffer, newNum, right,left-1,-1);
            return r>l ? l:r;
        }

    }
    static int min(int n, int m){
        if(n<m)
            return -1;
        else
            return 1;
    }
}