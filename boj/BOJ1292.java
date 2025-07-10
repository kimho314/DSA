package boj;

public class BOJ1292 {
    private static FastReader SC = new FastReader();
    private static int A, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] arr = new int[1000];
        int n = 1;
        int cnt = 0;

        for (int i = 0; i < 1000; i++) {
            if (cnt == n) {
                n++;
                cnt = 1;
                arr[i] = n;
            }
            else {
                cnt++;
                arr[i] = n;
            }
        }

        int sum = 0;
        for (int i = A - 1; i < B; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
    }
}
