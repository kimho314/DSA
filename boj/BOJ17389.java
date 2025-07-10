package boj;

public class BOJ17389 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        String input = SC.nextLine();
        char[] chars = input.toCharArray();

        int sum = 0;
        int bonus = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'O') {
                sum = sum + i + 1 + bonus;
                bonus++;
            }
            else {
                bonus = 0;
            }
        }

        System.out.println(sum);
    }
}
