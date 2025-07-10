package boj;

public class BOJ11720 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        String[] str = new String[N];
        String[] input = SC.nextLine().split("");
        for (int i = 0; i < N; i++) {
            str[i] = input[i];
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(str[i]);
        }
        System.out.println(sum);
    }
}
