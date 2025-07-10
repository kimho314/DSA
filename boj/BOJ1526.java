package boj;

public class BOJ1526 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();

        int res = 0;
        for (int i = 4; i <= N; i++) {
            if (isDetermine(i)) {
                res = Math.max(res, i);
            }
        }
        System.out.println(res);
    }

    private static boolean isDetermine(int n) {
        String str = String.valueOf(n);
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '4' && str.charAt(i) != '7') {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
