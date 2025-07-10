package boj;

public class BOJ5355 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static String[] INPUTS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (String input : INPUTS) {
            String[] split = input.split(" ");
            double num = Double.parseDouble(split[0]);
            for (int i = 1; i < split.length; i++) {
                num = operate(num, split[i]);
            }
            sb.append(String.format("%.2f", num)).append("\n");
        }

        System.out.println(sb);
    }

    private static double operate(double num, String op) {
        double res = num;
        switch (op) {
            case "@":
                res = num * 3.0;
                break;
            case "%":
                res = num + 5.0;
                break;
            case "#":
                res = num - 7.0;
                break;
        }
        return res;
    }

    private static void input() {
        T = SC.nextInt();
        INPUTS = new String[T];
        for (int i = 0; i < T; i++) {
            INPUTS[i] = SC.nextLine();
        }
    }

}
