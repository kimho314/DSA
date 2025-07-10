package boj;

public class BOJ3003 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();
    static int[] PIECE = {1, 1, 2, 2, 2, 8};

    public static void main(String[] args) {
        int[] inputs = new int[PIECE.length];
        for (int i = 0; i < PIECE.length; i++) {
            inputs[i] = SC.nextInt();
        }

        for (int i = 0; i < PIECE.length; i++) {
            int diff = PIECE[i] - inputs[i];
            SB.append(diff).append(" ");
        }
        System.out.println(SB.toString());
    }
}
