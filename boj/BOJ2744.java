package boj;

public class BOJ2744 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        String input = SC.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
            else {
                sb.append(Character.toUpperCase(ch));
            }
        }
        System.out.println(sb.toString());
    }
}
