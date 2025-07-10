package boj;

public class BOJ15439 {
    static int N;
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        N = SC.nextInt();
        int res = N * (N - 1);
        System.out.println(res);
    }
}
