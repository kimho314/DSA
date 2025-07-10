package boj;

import java.util.Arrays;

public class BOJ11256 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();


    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            int j = SC.nextInt();
            int n = SC.nextInt();
            int[] boxes = new int[n];
            for (int i = 0; i < n; i++) {
                int r = SC.nextInt();
                int c = SC.nextInt();
                boxes[i] = r * c;
            }
            Arrays.sort(boxes);
            int cnt = 0;
            int remain = j;
            for (int i = n - 1; i >= 0; i--) {
                if (remain <= 0) {
                    break;
                }
                remain -= boxes[i];
                cnt++;
            }
            SB.append(cnt).append("\n");
        }

        System.out.println(SB.toString());
    }
}
