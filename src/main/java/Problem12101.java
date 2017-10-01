import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geonheelee on 2017. 4. 29..
 */
public class Problem12101 {
    static int n, k;
    static int[] path = new int[11];
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //주어진 수
        n = Integer.parseInt(st.nextToken());
        //구하고자 하는 k번째줄
        k = Integer.parseInt(st.nextToken());
        dfs(0, 0);
        if (count != k) System.out.println(-1);
    }
    static boolean dfs(int node, int step) {
        if (node > n) {return false;}
        //노드의 합이 n이 된다면
        if (node == n) {
            //카운트 증가 (count번째 줄)
            count++;
            //카운트가 목표에 도달했다면
            if (count == k) {
                // path 출력
                for (int i = 0; i < step - 1; i++) {
                    System.out.print(path[i] + "+");
                }
                System.out.print(path[step - 1]);
                return true;
            }
        }
        for (int i = 1; i <= 3; i++) {
            path[step] = i;
            if (dfs(node + i, step + 1)) return true;
        }
        return false;
    }
}

