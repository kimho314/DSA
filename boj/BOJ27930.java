package boj;

public class BOJ27930 {
    private static FastReader SC = new FastReader();
    private static char[] ARR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        char[] korea = "KOREA".toCharArray();
        char[] yonsei = "YONSEI".toCharArray();

        int cntKorea = 0;
        int cntYonsei = 0;
        boolean foundKorea = false;
        boolean foundYonsei = false;
        for (int i = 0; i < ARR.length; i++) {
            if (ARR[i] == korea[cntKorea]) {
                cntKorea++;
            }
            if (ARR[i] == yonsei[cntYonsei]) {
                cntYonsei++;
            }

            if (cntKorea == korea.length) {
                foundKorea = true;
                break;
            }
            if (cntYonsei == yonsei.length) {
                foundYonsei = true;
                break;
            }
        }

        if (foundKorea) {
            System.out.println("KOREA");
        }
        if (foundYonsei) {
            System.out.println("YONSEI");
        }
    }

    private static void input() {
        ARR = SC.nextLine().toCharArray();
    }
}
