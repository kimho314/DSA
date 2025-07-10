package boj;

import java.util.Arrays;

public class BOJ26168 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static long[] A;
    private static long[][] OPS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            long op = OPS[i][0];
            if (op == 1) {
                int low = binarySearch1(OPS[i][1]);
                if (low == -1) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(N - low).append('\n');
                }
            } else if (op == 2) {
                int low = binarySearch2(OPS[i][1]);
                if (low == -1) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(N - low).append('\n');
                }
            } else {
                int lower = lowerBinarySearch3(OPS[i][1]);
                int upper = upperBinarySearch(OPS[i][2]);
                if (lower == -1 || upper == -1) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(upper - lower + 1).append('\n');
                }
            }
        }

        System.out.println(sb);
    }

    private static int upperBinarySearch(long j) {
        int l = 0;
        int r = N - 1;
        int res = 0;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (A[mid] <= j) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private static int lowerBinarySearch3(long i) {
        int l = 0;
        int r = N - 1;
        int res = -1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (A[mid] >= i) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private static int binarySearch2(long k) {
        int l = 0;
        int r = N - 1;
        int res = -1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (A[mid] > k) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private static int binarySearch1(long k) {
        int l = 0;
        int r = N - 1;
        int res = -1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (A[mid] >= k) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextLong();
        }
        OPS = new long[M][3];
        for (int i = 0; i < M; i++) {
            long n1 = SC.nextLong();
            if (n1 == 1 || n1 == 2) {
                OPS[i] = new long[]{n1, SC.nextLong(), -1};
            } else {
                OPS[i] = new long[]{n1, SC.nextLong(), SC.nextLong()};
            }
        }
    }
}
