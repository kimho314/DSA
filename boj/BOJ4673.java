package boj;

public class BOJ4673 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        boolean[] check = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int n = d(i);

            if (n < 10001) {
                check[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            if (!check[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static int d(int number) {
        int sum = number;

        while (number != 0) {
            sum += (number % 10);
            number /= 10;
        }

        return sum;
    }
}
