package boj;

public class BOJ13413 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            int n = SC.nextInt();
            String base = SC.nextLine();
            String target = SC.nextLine();
            int w = 0;
            int b = 0;
            for (int i = 0; i < n; i++) {
                if (base.charAt(i) != target.charAt(i)) {
                    if (base.charAt(i) == 'W') {
                        w++;
                    }
                    else {
                        b++;
                    }
                }
            }
            SB.append(Math.max(w, b)).append('\n');
        }
        System.out.println(SB.toString());
    }
}
