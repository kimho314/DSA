package boj;

public class BOJ4470 {
    static FastReader SC = new FastReader();
    static int N;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        N = SC.nextInt();
        for (int i = 1; i <= N; i++) {
            String input = SC.nextLine();
            SB.append(i).append(". ").append(input).append("\n");
        }
        System.out.println(SB.toString());
    }
}
