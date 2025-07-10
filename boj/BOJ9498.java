package boj;

public class BOJ9498 {
    private static FastReader SC = new FastReader();
    private static int SCORE;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        if (SCORE <= 100 && SCORE >= 90) {
            System.out.println("A");
        }
        else if (SCORE >= 80 && SCORE <= 89) {
            System.out.println("B");
        }
        else if (SCORE >= 70 && SCORE <= 79) {
            System.out.println("C");
        }
        else if (SCORE >= 60 && SCORE <= 69) {
            System.out.println("D");
        }
        else {
            System.out.println("F");
        }
    }

    private static void input() {
        SCORE = SC.nextInt();
    }
}
