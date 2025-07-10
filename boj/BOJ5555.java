package boj;

public class BOJ5555 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static String TARGET;
    private static int CNT;

    public static void main(String[] args) {
        input();
        while (N > 0) {
            N--;
            String str = SC.next();
            solve(str);
        }
        System.out.println(CNT);
    }

    private static void solve(String str) {
        boolean isExisted = false;
        for (int i = 0; i < str.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < TARGET.length(); j++) {
                if (TARGET.charAt(j) == str.charAt((i + j) % str.length())) {
                    cnt++;
                }
            }
            if (cnt == TARGET.length()) {
                isExisted = true;
                break;
            }
        }

        if (isExisted) {
            CNT++;
        }
    }

    private static void input() {
        TARGET = SC.next();
        N = SC.nextInt();
        CNT = 0;
    }
}
