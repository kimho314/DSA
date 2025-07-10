package boj;

public class BOJ1032 {
    static FastReader SC = new FastReader();
    static int N;
    static String[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextLine();
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A[0].length(); i++) {
            boolean isSame = true;
            for (int j = 1; j < N; j++) {
                if (A[j - 1].charAt(i) != A[j].charAt(i)) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                sb.append('?');
            }
            else {
                sb.append(A[0].charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
