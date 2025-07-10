package boj;

public class BOJ2675 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();

        while (T > 0) {
            T--;

            int n = SC.nextInt();
            String s = SC.next();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                for (int j = 0; j < n; j++) {
                    SB.append(ch);
                }
            }
            SB.append("\n");
        }
        System.out.println(SB.toString());
    }
}
