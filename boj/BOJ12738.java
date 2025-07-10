package boj;

import java.util.ArrayList;

public class BOJ12738 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(A[0]);

        for (int i = 1; i < N; i++) {
            if (A[i] > list.get(list.size() - 1)) {
                list.add(A[i]);
            } else {
                int idx = binarySearch(i, list);
                list.set(idx, A[i]);
            }

        }


        System.out.println(list.size());
    }

    private static int binarySearch(int i, ArrayList<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= A[i]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
