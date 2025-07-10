public class TsPy20241 {
    public static void main(String[] args) {
        TsPy20241 toss = new TsPy20241();
        int answer1 = toss.solution(new int[]{30, 30, 60, 90, 60, 15, 15, 60});
        System.out.println(answer1);
        int answer2 = toss.solution(new int[]{45, 15, 30});
        System.out.println(answer2);
    }

    public int solution(int[] schedules) {
        int answer = 0;

        int[] dp = new int[schedules.length];
        dp[0] = schedules[0];
        dp[1] = schedules[1];
        dp[2] = schedules[2] + dp[0];
        for (int i = 3; i < schedules.length; i++) {
            dp[i] = Math.max(dp[i - 2] + schedules[i], dp[i - 3] + schedules[i]);
        }

        answer = dp[1];
        for (int i = 1; i < dp.length; i++) {
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
