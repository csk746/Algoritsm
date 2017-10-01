import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 5. 19..
 */
public class Problem11437 {

    static int M = 20;

    static int[] depth;

    static int[][] parent;

    static ArrayList<Integer>[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new ArrayList[n+1];

        for (int i = 1; i<= n; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        depth = new int[n+1];



        parent = new int[M +1][n+1];

        for (int i = 0; i< n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            arr[u].add(v);
            arr[v].add(u);
        }

        dfs(1, 1, 0);

        for (int i = 0; i < M -1; i++){
            for(int j =1; j <= n; j++){
                parent[i+1][j] = parent[i][parent[i][j]];
            }
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(LCA(x,y));
        }
    }

    static void dfs(int cur, int d, int p){

        depth[cur] = d;

        parent[0][cur] = p;

        for (int nxt : arr[cur]){
            if (nxt != p){
                dfs(nxt, d +1, cur);
            }
        }
    }

    static int LCA(int u, int v){
        if (depth[u] < depth[v])
            return LCA(v, u);
        int d = depth[u] - depth[v];

        for (int i =0; i<M; i++){
            if ((d & 1 <<i) >0){
                u = parent[i][u];
            }
        }
        if (u == v)
            return v;
        for (int i = M -1; i >=0; --i){
            if (parent[i][u] != parent[i][v]){
                u = parent[i][u];
                v = parent[i][v];
            }
        }
        return parent[0][u];
    }
}
