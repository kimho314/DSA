package boj;

public class BOJ10162 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();
    static int T;

    public static void main(String[] args) {
        T = SC.nextInt();
        int[] time = new int[]{300, 60, 10};
        for (int i = 0; i < time.length; i++) {
            int cnt = T / time[i];
            SB.append(cnt).append(' ');
            T -= (time[i] * cnt);
        }

        if (T == 0) {
            System.out.println(SB);
        }
        else {
            System.out.println(-1);
        }
    }
}
