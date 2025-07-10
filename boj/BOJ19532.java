package boj;

public class BOJ19532 {
    static FastReader SC = new FastReader();
    static int A, B, C, D, E, F;

    public static void main(String[] args) {
        A = SC.nextInt();
        B = SC.nextInt();
        C = SC.nextInt();
        D = SC.nextInt();
        E = SC.nextInt();
        F = SC.nextInt();

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                boolean match1 = A * x + B * y == C;
                boolean match2 = D * x + E * y == F;
                if (match1 && match2) {
                    System.out.println(x + " " + y);
                    break;
                }
            }
        }
    }
}
