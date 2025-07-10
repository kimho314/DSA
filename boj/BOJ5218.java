package boj;

public class BOJ5218 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        while (T > 0) {
            T--;
            String str1 = SC.next();
            String str2 = SC.next();
            solve(str1, str2);
        }
        System.out.println(SB.toString());
    }

    private static void solve(String str1, String str2) {
        SB.append("Distances:");
        for (int i = 0; i < str1.length(); i++) {
            int x = str1.charAt(i) - 'A' + 1;
            int y = str2.charAt(i) - 'A' + 1;
            int dist = 0;
            if (x > y) {
                dist = (y + 26) - x;
            }
            else {
                dist = y - x;
            }
//            System.out.println(x + " " + y + " " + dist);
            SB.append(" ").append(dist);
        }
        SB.append("\n");
    }


    private static void input() {
        T = SC.nextInt();
    }
}
