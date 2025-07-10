package boj;

public class BOJ10953 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();
    static int T;

    public static void main(String[] args) {
        T = SC.nextInt();

        while (T > 0) {
            T--;
            String input = SC.nextLine();
            int sum = add(input.split(","));
            SB.append(sum).append("\n");
        }
        System.out.println(SB.toString());
    }

    private static int add(String[] split) {
        return Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
    }
}
