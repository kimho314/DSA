package boj;

public class BOJ12891 {
    private static FastReader SC = new FastReader();
    private static int S, P;
    private static String STR;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;

        int[] a = new int[4];
        for (int i = 0; i < P; i++) {
            char ch = STR.charAt(i);
            if (ch == 'A') {
                a[0]++;
            }
            else if (ch == 'C') {
                a[1]++;
            }
            else if (ch == 'G') {
                a[2]++;
            }
            else {
                a[3]++;
            }
        }
        boolean flag = true;
        for (int k = 0; k < 4; k++) {
            if (A[k] > a[k]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            cnt++;
        }

        for (int i = P; i < S; i++) {
            char ch1 = STR.charAt(i);
            if (ch1 == 'A') {
                a[0]++;
            }
            else if (ch1 == 'C') {
                a[1]++;
            }
            else if (ch1 == 'G') {
                a[2]++;
            }
            else {
                a[3]++;
            }

            char ch2 = STR.charAt(i - P);
            if (ch2 == 'A') {
                a[0]--;
            }
            else if (ch2 == 'C') {
                a[1]--;
            }
            else if (ch2 == 'G') {
                a[2]--;
            }
            else {
                a[3]--;
            }

            flag = true;
            for (int k = 0; k < 4; k++) {
                if (A[k] > a[k]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void input() {
        S = SC.nextInt();
        P = SC.nextInt();
        STR = SC.nextLine();
        A = new int[4];
        for (int i = 0; i < 4; i++) {
            A[i] = SC.nextInt();
        }
    }
}
