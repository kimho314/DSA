package boj;

public class BOJ1924 {
    private static FastReader SC = new FastReader();
    private static int X, Y;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int days = 0;
        for (int i = 1; i < X; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days += 31;
                    break;
                case 2:
                    days += 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days += 30;
                    break;
            }
        }
        days += Y;

        int res = days % 7;
        switch (res) {
            case 0:
                System.out.println("SUN");
                break;
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
        }
    }

    private static void input() {
        X = SC.nextInt();
        Y = SC.nextInt();
    }
}
