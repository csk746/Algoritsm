import java.util.*;

/**
 * Created by geonheelee on 2017. 5. 9..
 */
public class Problem1260 {
    static int N;
    static int M;
    static int map[][];
    static List<Integer> list = new ArrayList<Integer>();
    static int visit[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int startNum = sc.nextInt();
        visit = new int[N+1];
        map = new int[N+1][N+1];

        for (int i = 0; i < M; i++ ){
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
        }

//        for (int i = 0; i < N+1; i++){
//            for (int j=0; j<N+1; j ++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
        dfs(1);
        for (int i =0; i<list.size()-1; i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println(list.get(list.size()-1));
        Arrays.fill(visit,0);
        list = new ArrayList<Integer>();
        bfs(1);
        for (int i =0; i<list.size()-1; i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.print(list.get(list.size()-1));

    }
    static void dfs(int start){
        if (visit[start]==1){
            return;
        }
        visit[start] = 1;
        list.add(start);
        for(int i =1; i<N+1; i++){
            if (map[start][i]!=0){
                dfs(i);
            }
        }
    }
    static void bfs(int start){
        List<Integer> q = new ArrayList<Integer>();
        q.add(start);
        int point;
        while (!q.isEmpty()){

            point = q.get(0);
            if (visit[point]==0) {
                visit[point] = 1;
                list.add(point);
            }
            q.remove(0);
            for(int i =1; i<N+1; i++){
                if (map[point][i]!=0 && visit[i] == 0){
                    q.add(i);
                }
            }

        }
    }
}
