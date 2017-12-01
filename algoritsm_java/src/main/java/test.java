import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by geonheelee on 2017. 5. 9..
 */
public class test {
    public static void main(String[] args) {
        List<Integer> q = new ArrayList<Integer>();
        List<Integer> q2 = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);

        q.remove(0);
        System.out.println(q.get(0));

    }
}
