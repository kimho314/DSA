package boj;

public class BOJ1075 {
    static FastReader SC = new FastReader();
    static int N, F;

    public static void main(String[] args) {
        N = SC.nextInt();
        F = SC.nextInt();

        String res = "";
        for (int i = 0; i < 100; i++) {
            String zeroPaddedNUmber = String.format("%02d", i);
            int fraction1 = N / 100;
            String newInt = fraction1 + zeroPaddedNUmber;
            if (Integer.parseInt(newInt) % F == 0) {
                res = zeroPaddedNUmber;
//                System.out.println(newInt);
                break;
            }
        }
        System.out.println(res);
    }
}
