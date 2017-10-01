import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by geonheelee on 2017. 7. 7..
 */
public class Problem2533 {
    private static ArrayList<Integer>[] nodes;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        nodes = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new ArrayList<Integer>();
        }

        int node1, node2;
        for (int i = 1; i < N; i++) {
            node1 = scanner.nextInt()-1;
            node2 = scanner.nextInt()-1;
            nodes[node1].add(node2);
            nodes[node2].add(node1);
        }

        subCount(-1, 0);

        System.out.println(answer);
    }

    private static int subCount(int parentNode, int node) {
        int sub = 0;

        for (int i = 0; i < nodes[node].size(); i++) {
            if (nodes[node].get(i) != parentNode) {
                sub += subCount(node, nodes[node].get(i));
            }
        }

        if (sub > 0) {
            answer++;
            return 0;
        } else {
            return 1;
        }
    }
}
