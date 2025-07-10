package boj;

public class BOJ2857 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            String str = SC.nextLine();
            if (str.contains("FBI")) {
                SB.append(i).append(" ");
            }
        }

        if (SB.length() == 0) {
            System.out.println("HE GOT AWAY!");
        }
        else {
            System.out.println(SB.toString());
        }
    }
}
