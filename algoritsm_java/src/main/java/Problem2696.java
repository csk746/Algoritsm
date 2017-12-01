import java.util.*;

/**
 * Created by geonheelee on 2017. 5. 2..
 */
public class Problem2696 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=0; i<tc; i++){
            int len = sc.nextInt();
            List<Integer> arr = new ArrayList<Integer>();
            List<Integer> ans = new ArrayList<Integer>();
            for(int j=1; j< len+1; j++){
                arr.add(sc.nextInt());
                Collections.sort(arr);
                if (j%2==1){
                    ans.add(arr.get(arr.size()/2));
                }
            }
            System.out.println(ans.size());
            for (int j=0; j<ans.size(); j++){
                System.out.print(ans.get(j)+" ");
            }
            System.out.println();
        }
    }
}
