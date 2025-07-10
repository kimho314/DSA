package boj;

public class BOJ10801 {
    private static FastReader SC = new FastReader();
    private static int[] A, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        String[] wins = new String[10];
        for (int i = 0; i < 10; i++) {
            if (A[i] > B[i]) {
                wins[i] = "A";
            }
            else if (A[i] < B[i]) {
                wins[i] = "B";
            }
            else {
                wins[i] = "D'";
            }
        }

        int cntA = 0;
        int cntB = 0;
        for (int i = 0; i < 10; i++) {
            if (wins[i].equals("A")) {
                cntA++;
            }
            if (wins[i].equals("B")) {
                cntB++;
            }
        }

        if (cntA > cntB) {
            System.out.println("A");
        }
        else if (cntA < cntB) {
            System.out.println("B");
        }
        else {
            System.out.println("D");
        }
    }

    private static void input() {
        A = new int[10];
        B = new int[10];
        for (int i = 0; i < 10; i++) {
            A[i] = SC.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            B[i] = SC.nextInt();
        }
    }
}
