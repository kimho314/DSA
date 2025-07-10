package boj;

public class BOJ19941 {
    static FastReader SC = new FastReader();
    static int N, K;

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();
        char[] arr = SC.nextLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                for (int j = i - K; j <= i + K; j++) {
                    if (j >= 0 && j < arr.length && arr[j] == 'H') {
                        arr[j] = 'X';
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
