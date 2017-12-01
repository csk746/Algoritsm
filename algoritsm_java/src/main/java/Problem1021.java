import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 10. 5..
 */
public class Problem1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //큐 사이즈
        int queueSize = sc.nextInt();
        //뽑아내려는  수 의 사이즈
        int pollSize = sc.nextInt();
        ArrayList arr = new ArrayList();

        for(int i = 0; i < pollSize; i++){
            arr.add(sc.nextInt());
        }

        CQueue c = new CQueue(queueSize,arr);


        System.out.println(c.count);
    }
    static class CQueue{
        LinkedList list = new LinkedList();
        int count = 0;
        ArrayList arr;

        CQueue(int size, ArrayList arr){
            for (int i =1; i<size+1; i++){
                list.add(i);
            }
            this.arr = arr;
            ans();
        }

        void ans(){
            for(int i =0;i<arr.size(); i++){
                cal((Integer) arr.get(i));
            }
        }

        void cal(int num){
            while (true) {
                // 큐가 8이고 찾는 수가 2일때 예시
                int cursor = list.indexOf(num);
                int size = list.size();
                // 왼쪽으로 돌리기의 기준
                int left = cursor;
                // 오른쪽으로 돌리기의 기준
                // 큐가 8 커서가 2인경우 오른쪽은 5이 된다
                int right = size - cursor - 1;

                if (left == 0){
                    list.remove(cursor);
                    break;
                }
                //오른쪽이 더 크기 때문에 왼쪽으로 돌리게 된다
                if (left<=right){
                    //처음 것 꺼내서 마지막에 넣기 = 왼쪽으로 한칸 돌리기
                    list.addLast(list.removeFirst());
                    ++count;
                } else {
                    //마지막 것 꺼내서 처음에 넣기 = 오른쪽으로 한간 돌리기
                    list.addFirst(list.removeLast());
                    ++count;
                }
            }
        }
    }
}
