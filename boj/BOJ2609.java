package boj;

public class BOJ2609 {
    private static FastReader SC = new FastReader();
    private static int NUM1, NUM2;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int gcd = findGcd(NUM1, NUM2);
        int lcm = findLcd(gcd, NUM1, NUM2);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int findLcd(int gcd, int num1, int num2) {
        int res = (num1 / gcd) * (num2 / gcd) * gcd;
        return res;
    }

    private static int findGcd(int num1, int num2) {
        int max = 0;
        for (int i = 1; i <= Math.min(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                max = Math.max(max, i);
            }
        }

        return max;
    }

    private static void input() {
        NUM1 = SC.nextInt();
        NUM2 = SC.nextInt();
    }
}
