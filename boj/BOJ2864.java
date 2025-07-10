package boj;

public class BOJ2864 {
    static FastReader SC = new FastReader();
    static int N, M;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();

        String minN = String.valueOf(N).replaceAll("6", "5");
        String minM = String.valueOf(M).replaceAll("6", "5");
        int min = Integer.parseInt(minN) + Integer.parseInt(minM);

        String maxN = String.valueOf(N).replaceAll("5", "6");
        String maxM = String.valueOf(M).replaceAll("5", "6");
        int max = Integer.parseInt(maxN) + Integer.parseInt(maxM);

        System.out.println(min + " " + max);
    }
}
