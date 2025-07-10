package boj;

public class BOJ1259 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            int n = SC.nextInt();
            if (n == 0) {
                break;
            }

            if (isPalindrome(n)) {
                SB.append("yes").append("\n");
            }
            else {
                SB.append("no").append("\n");
            }
        }
        System.out.println(SB.toString());
    }

    private static boolean isPalindrome(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        boolean flag = true;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
