package boj;

public class BOJ2511 {
    private static FastReader SC = new FastReader();
    private static int[] A, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        String[] winner = new String[10];
        for (int i = 0; i < 10; i++) {
            if (A[i] > B[i]) {
                winner[i] = "A";
            }
            else if (A[i] < B[i]) {
                winner[i] = "B";
            }
            else {
                winner[i] = "D";
            }
        }

        int cntA = 0;
        int cntB = 0;
        for (int i = 0; i < 10; i++) {
            if (winner[i].equals("A")) {
                cntA += 3;
            }
            if (winner[i].equals("B")) {
                cntB += 3;
            }
            if (winner[i].equals("D")) {
                cntA++;
                cntB++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cntA).append(" ").append(cntB).append("\n");
        if (cntA > cntB) {
            sb.append("A");
        }
        else if (cntA < cntB) {
            sb.append("B");
        }
        else {
            String finalWinner = "D";
            for (int i = 9; i >= 0; i--) {
                if (!winner[i].equals("D")) {
                    finalWinner = winner[i];
                    break;
                }
            }
            sb.append(finalWinner);
        }

        System.out.println(sb);
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
