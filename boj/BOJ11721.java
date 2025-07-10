package boj;

public class BOJ11721 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        String str = SC.nextLine();
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        int next = 10;
        while (next < str.length()) {
            String sub = str.substring(cur, next);
            sb.append(sub).append("\n");
            cur = next;
            next = cur + 10;
        }
        sb.append(str, cur, Math.min(next, str.length())).append("\n");
        System.out.println(sb.toString());
    }
}
