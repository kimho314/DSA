package boj;

public class BOJ9184 {
    static FastReader SC = new FastReader();
    static int A, B, C;
    static int[][][] W;

    public static void main(String[] args) {
        W = new int[102][102][102];
        // -51 - 0
        // -50 - 1
        // ...
        // -1 - 50
        // 0 - 51
        // 1 - 52
        // 2 - 53
        // ...
        // 50 - 101

        // W(1,1,1) = W(0,1,1)+W(-1,-1,0)+W(-1,0,-1)-W(-1,-1,-1)
        // 1 +1+1-1
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    if (i == 0 || j == 0 || k == 0)
                        W[i][j][k] = 1;

                    else if (i < j && j < k) {
                        W[i][j][k] = W[i][j][k - 1] + W[i][j - 1][k - 1] - W[i][j - 1][k];
                    }
                    else {
                        W[i][j][k] = W[i - 1][j][k] + W[i - 1][j - 1][k] + W[i - 1][j][k - 1] - W[i - 1][j - 1][k - 1];
                    }

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            A = SC.nextInt();
            B = SC.nextInt();
            C = SC.nextInt();
            if (A == -1 && B == -1 && C == -1) {
                break;
            }
            sb.append("w(").append(A).append(", ").append(B).append(", ").append(C).append(") = ");

            if (A <= 0 || B <= 0 || C <= 0)
                sb.append(1).append('\n');
            else if (A > 20 || B > 20 || C > 20)
                sb.append(W[20][20][20]).append('\n');
            else
                sb.append(W[A][B][C]).append('\n');
        }

        System.out.println(sb);
    }
}
