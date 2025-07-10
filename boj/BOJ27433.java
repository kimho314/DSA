package boj;

public class BOJ27433 {
    static int N;
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        N = SC.nextInt();
        System.out.println(factorial(N));
    }

    private static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
