package boj;

public class BOJ2947 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        while (true) {
            for (int i = 0; i < NUMS.length - 1; i++) {
                boolean isSwitched = false;
                if (NUMS[i + 1] < NUMS[i]) {
                    int temp = NUMS[i];
                    NUMS[i] = NUMS[i + 1];
                    NUMS[i + 1] = temp;
                    isSwitched = true;
                }
                if (isSwitched) {
                    print();
                }
            }

            boolean check = check();
            if (check) {
                break;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < 5; i++) {
            System.out.print(NUMS[i] + " ");
        }
        System.out.println();
    }

    private static boolean check() {
        int[] answers = new int[5];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = i + 1;
        }

        boolean check = true;
        for (int i = 0; i < 5; i++) {
            if (NUMS[i] != answers[i]) {
                check = false;
                break;
            }
        }
        return check;
    }

    private static void input() {
        NUMS = new int[5];
        for (int i = 0; i < 5; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
