package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1015 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;

    static class Pair implements Comparable<Pair> {
        public int num;
        public int idx;

        public Pair() {
        }


        @Override
        public int compareTo(Pair o) {
            if (this.num != o.num) {
                return this.num - o.num;
            }
            return this.idx - o.idx;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "num=" + num +
                    ", idx=" + idx +
                    '}';
        }
    }

    public static void main(String[] args) {
        N = sc.nextInt();
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Pair pair = new Pair();
            pair.num = sc.nextInt();
            pair.idx = i;
            pairs.add(pair);
        }

        Collections.sort(pairs);

        int[] p = new int[N];
        for (int i = 0; i < pairs.size(); i++) {
            p[pairs.get(i).idx] = i;
        }
        for (int j : p) {
            sb.append(j).append(" ");
        }
        System.out.println(sb);
    }
}
