package boj;

import java.util.Arrays;

public class BOJ13423 {
    private static FastReader SC = new FastReader();
    private static int T;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        while (T > 0) {
            T--;

            int n = SC.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = SC.nextInt();
            }

            Arrays.sort(x);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int target = (x[j] + x[i]) / 2;
                    if (Math.abs(x[j] + x[i]) % 2 == 0 && binarySearch(x, target)) {
                        ans++;
                    }
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    private static boolean binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        boolean isFound = false;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                isFound = true;
                break;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return isFound;
    }

    private static void input() {
        T = SC.nextInt();
    }
}
