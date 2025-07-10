package boj;

public class BOJ15904 {
    static FastReader SC = new FastReader();
    static char[] UCPC = {'U', 'C', 'P', 'C'};

    public static void main(String[] args) {
        String input = SC.nextLine();

        int idx = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == UCPC[idx]) {
                idx++;
            }
            if (idx == 4) {
                break;
            }
        }

        if (idx == 4) {
            System.out.println("I love UCPC");
        }
        else {
            System.out.println("I hate UCPC");
        }
    }
}
