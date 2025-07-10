package boj;

import java.util.*;

public class BOJ16508 {
    private static FastReader SC = new FastReader();
    private static String T;
    private static int N;
    private static Book[] BOOKS;
    private static Book[] SELECTED;
    private static int MIN;

    private static class Book implements Comparable<Book> {
        public int price;
        public String title;

        Book(int price, String title) {
            this.price = price;
            this.title = title;
        }

        @Override
        public int compareTo(Book w) {
            return this.price - w.price;
        }


        @Override
        public String toString() {
            return "(" + this.price + " " + this.title + ")";
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        // Arrays.sort(BOOKS);

        for (int i = 1; i <= N; i++) {
            SELECTED = new Book[i];
            recFunc(0, -1, i);
        }

        if (MIN == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(MIN);
        }
    }

    private static void recFunc(int k, int prev, int len) {
        if (k == len) {
            String[] split = T.split("");
            for (Book b : SELECTED) {
                String[] split2 = b.title.split("");
                for (int i = 0; i < split2.length; i++) {
                    for (int j = 0; j < split.length; j++) {
                        if (!split[j].equals("x") && !split2[i].equals("x")
                                && split[j].equals(split2[i])) {
                            split[j] = "x";
                            split2[i] = "x";
                        }
                    }
                }
            }

            boolean isFound = true;
            for (String s : split) {
                if (!s.equals("x")) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                int sum = 0;
                for (Book b : SELECTED) {
                    sum += b.price;
                }
                MIN = Math.min(MIN, sum);
            }

        } else {
            for (int i = prev + 1; i < N; i++) {
                SELECTED[k] = BOOKS[i];
                recFunc(k + 1, i, len);
                SELECTED[k] = null;
            }
        }
    }

    private static void input() {
        T = SC.nextLine();
        N = SC.nextInt();
        BOOKS = new Book[N];
        for (int i = 0; i < N; i++) {
            Book w = new Book(SC.nextInt(), SC.next());
            BOOKS[i] = w;
        }
        MIN = Integer.MAX_VALUE;
    }
}
