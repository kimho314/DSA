package boj;

public class BOJ2302 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] VIP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int answer = 1;
        int preIdx = 0; // 곱셉을 위한 이전 위치
        for (int idx : VIP) {
            answer *= dp[idx - preIdx - 1]; // 인덱스 - 이전 인덱스 - 1을 함으로써 연속된 좌석을 길이 구하기
            preIdx = idx; // 인덱스를 업데이트하여 dp 길이
        }

        answer *= dp[N - preIdx]; // 마지막 고정석으로부터 연속된 좌석 dp
        System.out.println(answer);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        VIP = new int[M];
        for (int i = 0; i < M; i++) {
            VIP[i] = SC.nextInt();
        }
    }
}
