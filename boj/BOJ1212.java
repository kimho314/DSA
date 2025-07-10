package boj;

public class BOJ1212 {
    private static FastReader SC = new FastReader();
    private static String INPUT;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        String[] numbers = INPUT.split("");
        if (numbers[0].equals("0")) {
            System.out.println(0);
            return;
        }

        for (String n : numbers) {
            change(Integer.parseInt(n));
        }

        String result = SB.toString();

        while (result.charAt(0) == '0') {
            result = result.substring(1);
        }
        System.out.println(result);
    }

    private static void change(int n) {
        String tmp = "";

        for (int i = 0; i < 3; i++) {
            tmp = (n % 2) + tmp;
            n /= 2;
        }
        SB.append(tmp);
    }

    private static void input() {
        INPUT = SC.nextLine();
    }
}
