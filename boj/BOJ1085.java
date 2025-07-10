package boj;

public class BOJ1085 {
    static FastReader SC = new FastReader();
    static int X, Y, W, H;

    public static void main(String[] args) {
        X = SC.nextInt();
        Y = SC.nextInt();
        W = SC.nextInt();
        H = SC.nextInt();

        int dist1 = Math.min(X, W - X);
        int dist2 = Math.min(Y, H - Y);
        System.out.println(Math.min(dist1, dist2));
    }
}
