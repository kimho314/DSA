package boj;

public class BOJ2702 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            int a = SC.nextInt();
            int b = SC.nextInt();

            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= Math.min(a, b); i++) {
                if (a % i == 0 && b % i == 0) {
                    max = Math.max(max, i);
                }
            }

            int min = max * (a / max) * (b / max);
            SB.append(min).append(' ').append(max).append('\n');
        }
        System.out.println(SB.toString());
    }
}
