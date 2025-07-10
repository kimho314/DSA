package boj;

public class BOJ1244 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] SWITCH;
    private static int STUDENTS;
    private static int[][] INPUT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < STUDENTS; i++) {
            int n1 = INPUT[i][0];
            int n2 = INPUT[i][1];
            switch (n1) {
                case 1:
                    boySwitch(n2);
                    break;
                case 2:
                    girlSwitch(n2);
                    break;
                default:
                    break;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(SWITCH[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static void girlSwitch(int num) {
        SWITCH[num - 1] = SWITCH[num - 1] == 1 ? 0 : 1;
        int limit = Math.min(num - 1, N - num);
        for (int i = 1; i <= limit; i++) {
            int left = SWITCH[num - 1 - i];
            int right = SWITCH[num - 1 + i];
            if (left != right) {
                break;
            }
            SWITCH[num - 1 - i] = SWITCH[num - 1 - i] == 1 ? 0 : 1;
            SWITCH[num - 1 + i] = SWITCH[num - 1 + i] == 1 ? 0 : 1;
        }
    }

    private static void boySwitch(int num) {
        for (int i = num - 1; i < N; i++) {
            if ((i + 1) % num == 0) {
                SWITCH[i] = SWITCH[i] == 1 ? 0 : 1;
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        SWITCH = new int[N];
        for (int i = 0; i < N; i++) {
            SWITCH[i] = SC.nextInt();
        }
        STUDENTS = SC.nextInt();
        INPUT = new int[STUDENTS][2];
        for (int i = 0; i < STUDENTS; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            INPUT[i][0] = n1;
            INPUT[i][1] = n2;
        }
    }
}
