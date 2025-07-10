package boj;

public class BOJ12933 {
    private static FastReader SC = new FastReader();
    private static char[] INPUT;
    private static char[] QUACK = {'q', 'u', 'a', 'c', 'k'};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        if (INPUT.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        int remain = INPUT.length;
        int cnt = 0;
        while (remain != 0) {
            int pointer = 0;
            int idx = 0;
            boolean check = false;
            int[] tmp = new int[5];

            while (idx < INPUT.length) {
                if (INPUT[idx] == QUACK[pointer]) {
                    tmp[pointer++] = idx;
                    if (pointer == 5) {
                        check = true;
                        remain -= 5;
                        pointer = 0;
                        for (int i = 0; i < 5; i++) {
                            INPUT[tmp[i]] = '\0';
                        }
                    }
                }
                idx++;
            }

            if (check) {
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(remain == 0 ? cnt : -1);
    }

    private static void input() {
        INPUT = SC.nextLine().toCharArray();
    }
}
