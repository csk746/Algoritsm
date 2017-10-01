import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 8. 19..
 */
public class Problem1697 {

    public static boolean visited[];
    public static int minTime = 100000000;
    public static int max;
    public static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int old = sc.nextInt();
        int young = sc.nextInt();

        visited = new boolean[1000000];

        if (old>young){
            max = old;
            min = young;
        } else {
            max = young;
            min = old;
        }
        find(old,young,0);
        System.out.println(minTime);

    }
    public static void find (int now, int young, int time){
        Queue<Time> q = new LinkedList<Time>();
        q.add(new Time(now,time));

        while (!q.isEmpty()){
            Time t = q.poll();
            now = t.now;
            time = t.time;

            if (now == young){
                minTime = Math.min(minTime,time);
                continue;
            }

            visited[now] = true;

            if (now+1 <= max +1 && !visited[now+1])
                q.add(new Time(now+1, time+1));
            if (now-1 >= 0 && !visited[now-1])
                q.add(new Time(now-1, time+1));
            if (now*2 <max+1 && !visited[now*2])
                q.add(new Time(now*2,time+1));
        }
    }
}

class Time{
    int now;
    int time;

    public Time(int now, int time){
        now = now;
        time = time;
    }
}
