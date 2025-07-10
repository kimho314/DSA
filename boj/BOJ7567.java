package boj;

public class BOJ7567 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        char[] arr = SC.nextLine().toCharArray();

        int res = 10;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                res += 10;
            }
            else {
                res += 5;
            }
        }
        System.out.println(res);
    }
}
