package boj;

public class BOJ13144 {
    static FastReader sc = new FastReader();
    static int N;
    static int[] NUMS;

    public static void main(String[] args) {
        N = sc.nextInt();
        NUMS = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            NUMS[i] = sc.nextInt();
        }

        long ans = 0;
        int[] count = new int[100_000 + 1];
        for (int left = 1, right = 0; left <= N; left++) {
            // right 이동
            while (right + 1 <= N && count[NUMS[right + 1]] == 0) {
                right++;
                count[NUMS[right]]++;
            }

            // 숫자의 갯수
            ans += (right - left + 1);

            // left의 갯수 감소
            count[NUMS[left]]--;
        }
        System.out.println(ans);
    }
}
