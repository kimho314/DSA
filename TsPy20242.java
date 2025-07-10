import java.util.Arrays;

public class TsPy20242 {
    public static void main(String[] args) {
        TsPy20242 tsPy20242 = new TsPy20242();
        System.out.println(tsPy20242.solution(new int[]{10, 7, 8, 5, 8, 7, 6, 2, 9}, 3));
        System.out.println(tsPy20242.solution(new int[]{10, 7, 8, 5, 6, 4, 3, 2, 3}, 3));
    }

    public int solution(int[] prices, int k) {
        int answer = -1;

        int minIdx = 0;
        for (int i = 1; i < prices.length - 1 - k; i++) {
            if (prices[minIdx] > prices[i]) {
                minIdx = i;
            }
        }

        int sum = -1 * (prices[minIdx] * k);
        int[] copy = Arrays.copyOfRange(prices, minIdx + 1, prices.length);
        Arrays.sort(copy);
        for (int i = copy.length - 1; i >= copy.length - 3; i--) {
            sum += copy[i];
        }

        if (sum > 0) {
            answer = sum;
        }

        return answer;
    }
}
