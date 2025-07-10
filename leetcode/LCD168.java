package leetcode;

public class LCD168 {
    public static void main(String[] args) {
        LCD168 sol = new LCD168();
        System.out.println(sol.convertToTitle(1));
        System.out.println(sol.convertToTitle(28));
        System.out.println(sol.convertToTitle(701));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (((columnNumber) % 26) + 'A'));
            columnNumber = (columnNumber) / 26;
        }
        return sb.reverse().toString();
    }
}
