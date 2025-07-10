package boj;

public class BOJ2745 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        String input = SC.next();
        Integer base = SC.nextInt();

        int res = 0;
        int cnt = 0;
        for (char ch : input.toCharArray()) {
            int num = 0;
            if (ch >= 'A' && ch <= 'Z') {
                num = (int) ch - 55;
            }
            else {
                num = Integer.parseInt(String.valueOf(ch));
            }
            res += num * (int) (Math.pow(base, input.length() - 1 - cnt));
            cnt++;
        }

        System.out.println(res);
    }
}
