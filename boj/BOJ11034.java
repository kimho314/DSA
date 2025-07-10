package boj;

public class BOJ11034 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            try {
                String input = SC.nextLine();
                if (input.isEmpty()) {
                    break;
                }

                String[] poses = input.split(" ");
                int a = Integer.parseInt(poses[0]);
                int b = Integer.parseInt(poses[1]);
                int c = Integer.parseInt(poses[2]);

                int max = Math.max(b - a, c - b);
                SB.append(max - 1).append('\n');
            }
            catch (Exception e) {
                break;
            }

        }

        System.out.println(SB.toString());
    }
}
