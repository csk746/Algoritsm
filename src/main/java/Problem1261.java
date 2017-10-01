import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by geonheelee on 2017. 4. 29..
 */
public class Problem1261 {
    //전체 노드맵
    static int[][] map = new int[101][101];
    static int[][] dist = new int[101][101];

    static final int[] row = {0, -1, 0, 1};
    static final int[] col = {-1, 0, 1, 0};

    static final int INF = Integer.MAX_VALUE;
    //시작과 동시에 배열을 무한대로 채우기
    static {
        for (int i = 0; i < 101; i++) {
            Arrays.fill(dist[i], INF);
        }
    }
    public static void main(String[] args) throws IOException {
        int N, M; // 맵의 크기 <= 100
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            String lineInfo = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = lineInfo.charAt(j - 1) - '0';
            }
        }
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.add(new Node(1, 1, 0));
        dist[1][1] = 0;
        while (!queue.isEmpty()) {
            //큐에서 하나꺼낸다
            Node u = queue.poll();
            if (dist[u.row][u.col] < u.cost) {
                continue;
            }
            for (int i = 0; i < 4; i++) {

                int nextRow = u.row + row[i];
                int nextCol = u.col + col[i];
                if (nextRow <= 0 || nextRow > N || nextCol <= 0 || nextCol > M) {
                    continue;
                }
                //새로 탐색한 경로가 기존의 경로보다 작다면 업데이트 후 우선순위 큐에 넣는다
                if (dist[nextRow][nextCol] > dist[u.row][u.col] + map[nextRow][nextCol]) {

                    dist[nextRow][nextCol] = dist[u.row][u.col] + map[nextRow][nextCol];

                    queue.add(new Node(nextRow, nextCol, dist[nextRow][nextCol]));
                }
            }
            if (u.row == N && u.col == M) {
                System.out.println(u.cost);
                break;
            }
        }
    }
}

class Node implements Comparable<Node> {

    int row;
    int col;
    int cost;

    Node(int row, int col, int cost) {

        this.row = row;
        this.col = col;
        this.cost = cost;
    }

    public int compareTo(Node o) {

        return this.cost < o.cost ? -1 : 1;
    }
}
