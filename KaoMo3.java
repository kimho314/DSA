public class KaoMo3 {
    public static void main(String[] args) {
        KaoMo3 kaoMo3 = new KaoMo3();
        System.out.println(kaoMo3.solution(new int[]{3, 2, 3, 2, 3}));
        System.out.println(kaoMo3.solution(new int[]{7, 4, -2, 4, -2, -9}));
        System.out.println(kaoMo3.solution(new int[]{7, -5, -5, -5, 7, -1, 7}));
        System.out.println(kaoMo3.solution(new int[]{4}));
    }

    public int solution(int[] A) {
        // Handle edge cases
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }

        int maxLength = 1;

        // Try each possible starting position
        for (int start = 0; start < A.length; start++) {
            // For each starting position, try to extend as far as possible
            int evenValue = Integer.MIN_VALUE; // Value for even positions
            int oddValue = Integer.MIN_VALUE;  // Value for odd positions
            boolean evenInitialized = false;
            boolean oddInitialized = false;

            int length = 0;
            for (int i = start; i < A.length; i++) {
                // Determine if current position is even or odd relative to the starting position
                if ((i - start) % 2 == 0) {
                    // Even position
                    if (!evenInitialized) {
                        evenValue = A[i];
                        evenInitialized = true;
                        length++;
                    }
                    else if (A[i] == evenValue) {
                        length++;
                    }
                    else {
                        break;
                    }
                }
                else {
                    // Odd position
                    if (!oddInitialized) {
                        oddValue = A[i];
                        oddInitialized = true;
                        length++;
                    }
                    else if (A[i] == oddValue) {
                        length++;
                    }
                    else {
                        break;
                    }
                }
            }

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
