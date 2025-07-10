package boj;

public class BOJ9656 {
    static FastReader SC = new FastReader();
    static int N;
    static String[] A = new String[1001];

    public static void main(String[] args) {
        N = SC.nextInt();
        for (int i = 1; i <= 1000; i++) {
            A[i] = i % 2 == 0 ? "SK" : "CY";
        }
        System.out.println(A[N]);
    }
}
