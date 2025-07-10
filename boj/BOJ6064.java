package boj;

import java.util.*;

public class BOJ6064 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();

        while (T > 0) {
            T--;
            int M = SC.nextInt();
            int N = SC.nextInt();
            int x = SC.nextInt();
            int y = SC.nextInt();
            solve(M, N, x, y);
        }

        System.out.println(SB);
    }

    private static void solve(int M, int N, int x, int y) {
        int last = lcm(M, N);
        int n = 0;
        int result = -1;

        while (n * M < last) {
            if ((n * M + x - y) % N == 0) {
                result = n * M + x;
                break;
            }
            n++;
        }
        SB.append(result).append("\n");
    }

    private static int lcm(int num1, int num2) {
        return num1 * num2 / gcd(num1, num2);
    }

    private static int gcd(int num1, int num2) {
        int tmp = 0;
        while (num2 > 0) {
            tmp = num1 % num2;
            num1 = num2;
            num2 = tmp;
        }
        return num1;
    }

    private static void input() {
        T = SC.nextInt();
    }
}
