import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by csk746(csk746@naver.com) on 2017. 11. 4..
 */
public class woowa_02 {
    public static void main(String[] args) {
        String s = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";
        solution(s);
    }

    public static String solution(String S) {
        // write your coSde in Java SE 8
        String arr[] = S.split("\n");
        List<Photo> list = new ArrayList<Photo>();
        Set s = new HashSet();
        for (int i = 0; i < arr.length; i++) {

            String photoInfo[] = arr[i].split(" ");
            photoInfo[0] = photoInfo[0].replace(",", "");
            photoInfo[1] = photoInfo[1].replace(",", "");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date d = null;

            try {
                d = format.parse(photoInfo[2] + " " + photoInfo[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            s.add(photoInfo[1]);
            list.add(new Photo(photoInfo[0], photoInfo[1], d, i));
        }
        List<Photo> sortList = new ArrayList<Photo>();

        for (Photo p : list)
            sortList.add(p);

        Map<String, Integer> locationMap = new HashMap<String, Integer>();
        Map<String, Integer> locationMapCount = new HashMap<String, Integer>();
        Iterator<String> iterator = s.iterator();

        while (iterator.hasNext()) {
            String tmpString = iterator.next();
            locationMap.put(tmpString, 1);
            locationMapCount.put(tmpString, 1);
        }

        for (Photo p : list)
            locationMapCount.put(p.getLocation(), locationMapCount.get(p.getLocation()) + 1);

        Collections.sort(sortList);

        for (Photo p : sortList) {
            int num = 0;

            if (locationMapCount.get(p.getLocation()) < 10)
                num = 1;
            else if (locationMapCount.get(p.getLocation()) >= 10 && locationMapCount.get(p.getLocation()) < 100)
                num = 2;
            else
                num = 3;

            String ext = p.getName().split("\\.")[1];
            Photo tmp = list.get(p.getIndex());
            tmp.setAlias(tmp.getLocation() + String.format("%0" + num + "d", locationMap.get(tmp.getLocation()))+"."+ext);
            locationMap.put(tmp.getLocation(), locationMap.get(tmp.getLocation()) + 1);
        }

        String ans = "";

        for (Photo p : list)
            ans += p.getAlias()+"\n";

        return ans;
    }

    private static class Photo implements Comparable<Photo> {

        String name;

        String alias;

        String location;

        Date d;

        int index;

        Photo(String name, String location, Date d, int index) {
            this.name = name;
            this.location = location;
            this.d = d;
            this.index = index;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getName() {
            return name;
        }

        public String getAlias() {
            return alias;
        }

        public String getLocation() {
            return location;
        }

        public Date getD() {
            return d;
        }

        public int getIndex() {
            return index;
        }

        public int compareTo(Photo p) {
            if (d.getTime() - p.getD().getTime() > 0)
                return 1;
            else
                return -1;
        }
    }
}
