package boj;

import java.util.Arrays;

public class BOJ1931 {
    static FastReader SC = new FastReader();
    static int N;

    static class Room implements Comparable<Room> {
        int start;
        int end;
        int duration;

        public Room() {

        }

        public Room(int _start, int _end, int _duration) {
            this.start = _start;
            this.end = _end;
            this.duration = _duration;
        }

        @Override
        public int compareTo(Room o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) {
        N = SC.nextInt();
        Room[] rooms = new Room[N];
        for (int i = 0; i < N; i++) {
            int start = SC.nextInt();
            int end = SC.nextInt();
            Room room = new Room(start, end, end - start);
            rooms[i] = room;
        }

        Arrays.sort(rooms);
        int cnt = 1;
        int to = rooms[0].end;
        for (int i = 1; i < N; i++) {
            if (to <= rooms[i].start) {
                to = rooms[i].end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
