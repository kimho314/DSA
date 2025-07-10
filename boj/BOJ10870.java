package boj;

public class BOJ10870 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] D;

    public static void main(String[] args) {
        N = SC.nextInt();
        D = new int[21];

        D[0] = 0;
        D[1] = 1;
        for (int i = 2; i <= 20; i++) {
            D[i] = D[i - 1] + D[i - 2];
        }


        System.out.println(D[N]);
    }
}
