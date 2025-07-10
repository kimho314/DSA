package boj;

public class BOJ11365 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = SC.nextLine();
            if (input.equals("END")) {
                break;
            }

            for (int i = input.length() - 1; i >= 0; i--) {
                sb.append(input.charAt(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
