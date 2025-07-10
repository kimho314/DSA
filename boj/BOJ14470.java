package boj;

public class BOJ14470 {
    private static FastReader SC = new FastReader();
    private static int A, B, C, D, E;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int temp = A;
        boolean isFrozen = temp <= 0;

        int time = 0;
        while (temp < B) {
            if (temp < 0) {
                temp++;
                time += C;
            }
            else if (temp == 0) {
                if (isFrozen) {
                    time += D;
                    isFrozen = false;
                }
                else {
                    time += E;
                    temp++;
                }
            }
            else {
                time += E;
                temp++;
            }
        }

        System.out.println(time);
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
        C = SC.nextInt();
        D = SC.nextInt();
        E = SC.nextInt();
    }
}
