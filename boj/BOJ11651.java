package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ11651 {
    static FastReader SC = new FastReader();
    static int N;

    static private class Pos implements Comparable<Pos> {
        int x;
        int y;

        public Pos() {

        }

        public Pos(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }

    public static void main(String[] args) {
        N = SC.nextInt();
        List<Pos> poses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = SC.nextInt();
            int y = SC.nextInt();
            Pos pos = new Pos(x, y);
            poses.add(pos);
        }

        Collections.sort(poses);
        poses.forEach(pos -> System.out.println(pos.x + " " + pos.y));
    }
}
