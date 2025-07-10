package boj;

public class BOJ4892 {
    private static FastReader SC = new FastReader();
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        int t = 0;
        while (true) {
            int n0 = SC.nextInt();
            if (n0 == 0) {
                break;
            }
            t++;

            solve(t, n0);
        }
        System.out.println(SB);
    }

    private static void solve(int t, int n0) {
        int n1 = n0 * 3;
        if (n1 % 2 == 0) {
            int n4 = (3 * (n1 / 2)) / 9;
            SB.append(t).append(".").append(" ").append("even").append(" ").append(n4).append("\n");
        }
        else {
            int n4 = (3 * ((n1 + 1) / 2)) / 9;
            SB.append(t).append(".").append(" ").append("odd").append(" ").append(n4).append("\n");
        }
    }
}
