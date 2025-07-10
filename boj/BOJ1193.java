package boj;

public class BOJ1193 {
    private static FastReader SC = new FastReader();
    private static int X;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int crossCount = 1;
        int prevCountSum = 0;

        while (true) {
            if (X <= prevCountSum + crossCount) {
                if (crossCount % 2 == 1) {
                    System.out.println((crossCount - (X - prevCountSum - 1)) + "/" + (X - prevCountSum));
                    break;
                }
                else {
                    System.out.println((X - prevCountSum) + "/" + (crossCount - (X - prevCountSum - 1)));
                    break;
                }
            }
            else {
                prevCountSum += crossCount;
                crossCount++;
            }
        }
    }

    private static void input() {
        X = SC.nextInt();
    }
}
