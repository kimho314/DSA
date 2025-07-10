package boj;

public class BOJ13417 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            int n = SC.nextInt();
            String[] chars = new String[n];
            for (int i = 0; i < n; i++) {
                chars[i] = SC.next();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(chars[0]);
            for (int i = 1; i < n; i++) {
                if (String.valueOf(sb.charAt(0)).compareTo(chars[i]) < 0) {
                    sb.append(chars[i]);
                }
                else {
                    sb.insert(0, chars[i]);
                }
            }
            SB.append(sb).append('\n');
        }

        System.out.println(SB);
    }
}
