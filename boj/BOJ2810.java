package boj;

public class BOJ2810 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        String seat = SC.nextLine();
        String replacedSeat = seat.replaceAll("LL", "L");
        int maxNumOfCups = (replacedSeat.length() - 1) + 2;
        int res = N;
        if (maxNumOfCups < N) {
            res = maxNumOfCups;
        }
        System.out.println(res);
    }
}
