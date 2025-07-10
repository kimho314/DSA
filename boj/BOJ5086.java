package boj;

public class BOJ5086 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            if (n1 == 0 && n2 == 0) {
                break;
            }

            if (n2 % n1 == 0) {
                SB.append("factor").append('\n');
            }
            else if (n1 % n2 == 0) {
                SB.append("multiple").append('\n');
            }
            else {
                SB.append("neither").append('\n');
            }
        }

        System.out.println(SB.toString());
    }
}
