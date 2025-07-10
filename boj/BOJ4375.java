package boj;

public class BOJ4375 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            String str = SC.nextLine();
            if (str == null || str.isEmpty()) {
                break;
            }

            int n = Integer.parseInt(str);
            long num = 1;
            int cnt = 1;
            while (true) {
                if (num % n == 0) {
                    System.out.println(cnt);
                    break;
                }
                ++cnt;
                num = (num * 10 + 1) % n;
            }
        }
    }
}
