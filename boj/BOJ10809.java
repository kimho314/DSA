package boj;

public class BOJ10809 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        String input = SC.nextLine();

        for (char i = 'a'; i <= 'z'; i++) {
            int idx = input.indexOf(String.valueOf(i));
            SB.append(idx).append(" ");
        }
        System.out.println(SB.toString());
    }
}
