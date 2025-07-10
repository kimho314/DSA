package boj;

public class BOJ11655 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        String input = SC.nextLine();
        solve(input);
    }

    private static void solve(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))) {
                char convertedCh = convert(input.charAt(i));
                sb.append(convertedCh);
            }
            else {
                sb.append(input.charAt(i));
            }
        }

        System.out.println(sb.toString());
    }

    private static char convert(char input) {
        char ch = (char) (input + 13);
        if (Character.isUpperCase(input)) {
            if (ch > 'Z') {
                ch = (char) (ch - 'Z' - 1 + 'A');
            }
        }
        else {
            if (ch > 'z') {
                ch = (char) (ch - 'z' - 1 + 'a');
            }
        }

        return ch;
    }
}
