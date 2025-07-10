package boj;

public class BOJ10820 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        int n = 0;
        while (n < 100) {
            n++;
            String input = SC.nextLine();
            if (input == null) {
                break;
            }
            solve(input);
        }
    }

    private static void solve(String input) {
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int cnt4 = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLowerCase(input.charAt(i))) {
                cnt1++;
            }
            else if (Character.isUpperCase(input.charAt(i))) {
                cnt2++;
            }
            else if (Character.isDigit(input.charAt(i))) {
                cnt3++;
            }
            else {
                cnt4++;
            }
        }
        System.out.println(cnt1 + " " + cnt2 + " " + cnt3 + " " + cnt4);
    }

}
