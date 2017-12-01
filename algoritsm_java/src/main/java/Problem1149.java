import java.util.*;

/**
 * Created by geonheelee on 2017. 5. 2..
 */
public class Problem1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int area = sc.nextInt();
        int arr[] = new int[cnt];
        for(int i=0; i<cnt; i++){
            arr[i]= sc.nextInt();
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i< cnt-area+1; i++){
            List<Integer> arrList = new ArrayList<Integer>();
            for(int j=i; j<i+area; j++){
                arrList.add(arr[j]);
                System.out.println("arr "+arr[j]);
            }
            Collections.sort(arrList);
            System.out.println(arrList.toString());
            System.out.println(arrList.get((area+1)/2)-1);
            ans.add(arrList.get((area+1)/2)-1);
        }
        long sum = 0;
        for(int i =0; i<ans.size(); i++){
            System.out.println(ans.get(i));
            sum+=ans.get(i);
        }
        System.out.println(sum);
    }
}
