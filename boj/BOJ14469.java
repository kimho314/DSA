package boj;

import java.util.Arrays;

public class BOJ14469 {
    static FastReader SC = new FastReader();
    static int N;

    static class Cow implements Comparable<Cow> {
        public int arriveAt;
        public int examDuration;

        @Override
        public int compareTo(Cow o) {
            return this.arriveAt - o.arriveAt;
        }
    }

    public static void main(String[] args) {
        N = SC.nextInt();
        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            Cow cow = new Cow();
            cow.arriveAt = SC.nextInt();
            cow.examDuration = SC.nextInt();
            cows[i] = cow;
        }
        Arrays.sort(cows);

        int endTime = cows[0].arriveAt + cows[0].examDuration;
        for (int i = 1; i < N; i++) {
            if (endTime > cows[i].arriveAt) {
                endTime += cows[i].examDuration;
            }
            else {
                endTime = (cows[i].arriveAt + cows[i].examDuration);
            }
        }
        System.out.println(endTime);
    }
}
