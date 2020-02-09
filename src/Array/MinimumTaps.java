package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinimumTaps {
    class Point {
        int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int minTaps(int n, int[] ranges) {
        ArrayList<Point> list = new ArrayList<>();
        for(int i = 0;i < ranges.length;i++){
            if(ranges[i] != 0){
                int x = i - ranges[i];
                int y = i + ranges[i];
                x = (x < 0) ? 0 : x;
                y = (y > n) ? n : y;
                list.add(new Point(x, y));
            }
        }

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x < o2.x) return -1;
                if(o1.x > o2.x) return 1;
                if(o1.y > o2.y) return -1;
                return 0;
            }
        });

        for(int i = 0;i < list.size() - 1;) {
            Point one = list.get(i);
            Point two = list.get(i + 1);
            if(one.x <= two.x && two.x <= one.y && one.x <= two.y && two.y <= one.y){
                list.remove(i + 1);
            }
            else
                i++;
        }

        int last = (list.size() > 0) ? list.get(0).y : 0;

        for(int i = 0;i < list.size() - 1;i++) {
            Point one = list.get(i);
            Point two = list.get(i + 1);
            if(two.x > one.y)
                break;
            last = two.y;
        }

        return (last == n) ? list.size() : -1;
    }

    public static void main(String args[]) {
        System.out.println(new MinimumTaps().minTaps(5, new int[]{3,4,1,1,0,0}));
        System.out.println(new MinimumTaps().minTaps(3, new int[]{0,0,0,0}));
        System.out.println(new MinimumTaps().minTaps(7, new int[]{1,2,1,0,2,1,0,1}));
        System.out.println(new MinimumTaps().minTaps(8, new int[]{4,0,0,0,0,0,0,0,4}));
        System.out.println(new MinimumTaps().minTaps(8, new int[]{4,0,0,0,4,0,0,0,4}));
    }
}
