package boj;

public class BOJ3062 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        for (int i = 0; i < N; i++) {
            solve(SC.nextInt());
        }

        System.out.println(SB.toString());
    }

    private static void solve(int input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        String num = sb.toString();
        String reverse = sb.reverse().toString();
        int sum = Integer.parseInt(num) + Integer.parseInt(reverse);

        boolean flag = true;
        char[] chs = String.valueOf(sum).toCharArray();
        for (int i = 0; i < chs.length / 2; i++) {
            if (chs[i] != chs[chs.length - 1 - i]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            SB.append("YES");
        }
        else {
            SB.append("NO");
        }
        SB.append("\n");
    }

    private static void input() {
        N = SC.nextInt();
    }
}
