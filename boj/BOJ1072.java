package boj;

public class BOJ1072 {
    static FastReader SC = new FastReader();
    static int X, Y;

    public static void main(String[] args) {
        X = SC.nextInt();
        Y = SC.nextInt();

        int res = -1;
        if (X == Y) {
            System.out.println(res);
        }
        else {
            int l = 1;
            int r = 1000000000;
            while (l <= r) {
                int mid = (r + l) / 2;
                boolean isChanged = determine(mid);
                if (isChanged) {
                    res = mid;
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            System.out.println(res);
        }
    }

    private static boolean determine(int add) {
        long winRate = ((long) Y * 100 / X);
        long newWinRate = (long) (Y + add) * 100 / (long) (X + add);
//        System.out.println(winRate + " " + newWinRate + " " + add);
        return winRate != newWinRate;
    }
}
