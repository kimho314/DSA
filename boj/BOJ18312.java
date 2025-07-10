package boj;

public class BOJ18312 {
    private static FastReader SC = new FastReader();
    private static int N, K;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;
        int limitTime = convertToSec(N, 59, 59);
//        System.out.println("limitTime = " + limitTime);
        for (int i = 0; i <= limitTime; i++) {
            int[] time = convertToTime(i);
            boolean isK = false;
            for (int j = 0; j < 6; j++) {
                if (time[j] == K) {
                    isK = true;
                    break;
                }
            }
//            System.out.println("isK = " + isK + " " + Arrays.toString(time));
            if (isK) {
                res++;
            }
        }

        System.out.println(res);
    }

    private static int convertToSec(int hour, int minute, int second) {
        int res = 0;
        res += (hour * 3600);
        res += (minute * 60);
        res += second;
        return res;
    }

    private static int[] convertToTime(int second) {
        int[] time = new int[6];
        int hour = second / 3600;
        int min = second % 3600 / 60;
        int sec = second % 3600 % 60;
        time[0] = hour / 10;
        time[1] = hour % 10;
        time[2] = min / 10;
        time[3] = min % 10;
        time[4] = sec / 10;
        time[5] = sec % 10;
        return time;
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
    }
}
