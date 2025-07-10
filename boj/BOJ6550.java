package boj;

public class BOJ6550 {
    static FastReader SC = new FastReader();
    static String S, T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            try {
                String input = SC.nextLine();
                S = input.split(" ")[0];
                T = input.split(" ")[1];

                char[] target = S.toCharArray();

                int cnt = 0;
                for (int i = 0; i < T.length(); i++) {
                    if (cnt >= target.length) {
                        break;
                    }
                    if (target[cnt] == T.charAt(i)) {
                        cnt++;
                    }
                }

                if (cnt == target.length) {
                    SB.append("Yes").append('\n');
                }
                else {
                    SB.append("No").append('\n');
                }
            }
            catch (Exception e) {
                break;
            }
        }

        System.out.println(SB.toString());
    }
}
