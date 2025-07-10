package boj;

public class BOJ1436 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();

        int res = 0;
        int cnt = 0;
        for (int i = 666; i <= 10000000; i++) {
            boolean contains = String.valueOf(i).contains("666");
            if (contains) {
//                System.out.println(i);
                cnt++;
            }

            if (cnt == N) {
                res = i;
                break;
            }
        }
//        System.out.println("=====");
        System.out.println(res);
    }
}
