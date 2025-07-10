package boj;

public class BOJ1590 {
    private static FastReader SC = new FastReader();
    private static int N, T;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int s = SC.nextInt();
            int l = SC.nextInt();
            int c = SC.nextInt();

            int[] times = new int[c];
            for (int j = 0; j < c; j++) {
                times[j] = s + (l * j);
            }

            int arrivalTime = -1;
            if (T <= times[0]) {
                arrivalTime = times[0] - T;
            }
            else if (T == times[c - 1]) {
                arrivalTime = times[c - 1] - T;
            }
            else if (T > times[c - 1]) {
                continue;
            }
            else {
                arrivalTime = binarySearch(times);
            }
            res = Math.min(res, arrivalTime);
        }

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(res);
        }
    }

    private static int binarySearch(int[] times) {
        int res = -1;
        int l = 0;
        int r = times.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (determine(times[mid])) {
                res = times[mid] - T;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return res;
    }

    private static boolean determine(int time) {
        return T <= time;
    }

    private static void input() {
        N = SC.nextInt();
        T = SC.nextInt();
    }
}
