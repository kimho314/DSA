package boj;

public class BOJ10952 {
    private static FastReader SC = new FastReader();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int a = SC.nextInt();
            int b = SC.nextInt();
            if (a == 0 && b == 0) {
                break;
            }

            int res = solve(a, b);
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }

    private static int solve(int a, int b) {
        return a + b;
    }

}
