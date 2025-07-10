package boj;

public class BOJ9086 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            String str = SC.nextLine();
            SB.append(str.charAt(0)).append(str.charAt(str.length() - 1)).append("\n");
        }
        System.out.println(SB.toString());
    }
}
