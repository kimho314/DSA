package boj;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BOJ9506 {
    private static FastReader SC = new FastReader();
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            int n = SC.nextInt();
            if (n == -1) {
                break;
            }

            solve(n);
        }

        System.out.println(SB);
    }

    private static void solve(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        long sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
//                System.out.println(i);
                list.add(i);
                sum += i;
            }
        }

        if (sum == n) {
            String str = list.stream().map(String::valueOf).collect(Collectors.joining(" + "));
            SB.append(n).append(" = ").append(str).append("\n");
        }
        else {
            String str = String.format("%d is NOT perfect.", n);
            SB.append(str).append("\n");
        }
    }
}
