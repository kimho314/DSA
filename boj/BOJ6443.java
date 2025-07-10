package boj;

import java.util.*;

public class BOJ6443 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
    }

    private static void solve() {
        int[] cnt = new int['z' - 'a' + 1];
        while (N > 0) {
            N--;

            char[] arr = SC.nextLine().toCharArray();
            Arrays.sort(arr);
            Arrays.fill(cnt, 0);
            for (int i = 0; i < arr.length; i++) {
                cnt[arr[i] - 'a']++;
            }

            recFunc(0, arr, cnt, "");
        }

        System.out.println(SB);
    }

    private static void recFunc(int k, char[] arr, int[] cnt, String str) {
        if (k == arr.length) {
            SB.append(str.toString()).append("\n");
        } else {
            char prev = ' ';
            for (int i = 0; i < arr.length; i++) {
                if (prev != arr[i] && cnt[arr[i] - 'a'] > 0) {
                    cnt[arr[i] - 'a']--;
                    prev = arr[i];
                    recFunc(k + 1, arr, cnt, str + arr[i]);
                    cnt[arr[i] - 'a']++;
                }
            }
        }
    }
}
