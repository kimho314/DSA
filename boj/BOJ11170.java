package boj;

public class BOJ11170 {
    static FastReader SC = new FastReader();
    static int T, N, M;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            N = SC.nextInt();
            M = SC.nextInt();
            int cnt = 0;
            for (int i = N; i <= M; i++) {
                for (Character ch : String.valueOf(i).toCharArray()) {
                    if (ch == '0') {
                        cnt++;
                    }
                }
            }
            SB.append(cnt).append('\n');
        }
        System.out.println(SB.toString());
    }
}
