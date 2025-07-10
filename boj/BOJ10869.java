package boj;

public class BOJ10869 {
    private static FastReader SC = new FastReader();
    private static int A, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int addition = A + B;
        int subtraction = A - B;
        int multiplication = A * B;
        int division = A / B;
        int modular = A % B;

        System.out.println(addition);
        System.out.println(subtraction);
        System.out.println(multiplication);
        System.out.println(division);
        System.out.println(modular);
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
    }
}
