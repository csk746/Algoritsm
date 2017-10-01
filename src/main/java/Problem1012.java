import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 8. 19..
 */
public class Problem1012 {
    static int N,M,V;
    static int[][] arr;
    static int[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i =0; i<tc; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            V = sc.nextInt();
            arr = new int[V + 1][V + 1];
            visited = new int[V + 1];
            for (int j = 1; j <= V; j++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();
                arr[parent][child] = 1;
                arr[child][parent] = 1;
            }
            DFS(V);
            System.out.println();
            BFS(V);
            sc.close();
        }
    }
    static void DFS(int v){
        visited[v] = 1;
        System.out.print(v+" ");
        for(int i = 1; i<=N;i++){
            if(arr[v][i] == 1 && visited[i] == 0){
                DFS(i);
            }
        }
    }
    static void BFS(int v){
        int[] visited = new int[N+1];
        visited[v] = 1;
        Qu q = new Qu(1000);
        q.push(v);

        while(!q.isEmpty()){
            int next = q.pop();
            System.out.print(next+" ");
            for(int i = 1; i <= N; i++){
                if(arr[next][i] == 1 && visited[i] == 0){
                    visited[i] = 1;
                    q.push(i);
                }
            }
        }
    }
}
class Qu{
    private int front;
    private int rear;
    private int max_size;
    private int[] arr;

    public Qu(int size){
        front = -1;
        rear = -1;
        max_size = size;
        arr = new int[max_size];
    }

    public void push(int item){
        arr[++rear] = item;
    }

    public int pop(){
        return arr[++front];
    }

    public int peek(){
        int index = front;
        return arr[++index];
    }

    public boolean isEmpty(){
        return (front == rear);
    }
}
