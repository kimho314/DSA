package boj;

public class BOJ27866 {
    static FastReader SC = new FastReader();
    static String S;
    static int I;

    public static void main(String[] args) {
        S = SC.nextLine();
        I = SC.nextInt();

        char[] chs = S.toCharArray();
        System.out.println(chs[I - 1]);
    }
}
