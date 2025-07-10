package boj;

public class BOJ1264 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            String input = SC.nextLine();
            if (input.equals("#")) {
                break;
            }

            int cnt = 0;
            for (int i = 0; i < input.length(); i++) {
                String str = String.valueOf(input.charAt(i));
                if (str.equalsIgnoreCase("a") ||
                        str.equalsIgnoreCase("e") ||
                        str.equalsIgnoreCase("i") ||
                        str.equalsIgnoreCase("o") ||
                        str.equalsIgnoreCase("u")
                ) {
                    cnt++;
                }
            }
            SB.append(cnt).append('\n');
        }

        System.out.println(SB.toString());
    }
}
