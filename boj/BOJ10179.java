package boj;

public class BOJ10179 {
    private static FastReader SC = new FastReader();
    private static int T;

    public static void main(String[] args) {
        input();
        StringBuilder sb = new StringBuilder();
        while (T > 0) {
            T--;
            double original = SC.nextDouble();
            double discounted = original * 0.8;
            sb.append("$").append(String.format("%.2f", discounted)).append("\n");
        }
        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
    }
}
