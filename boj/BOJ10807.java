package boj;

public class BOJ10807 {
    static FastReader SC = new FastReader();
    static int N, V;
    static int[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        V = SC.nextInt();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == V) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
