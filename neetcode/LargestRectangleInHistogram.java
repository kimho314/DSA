import java.util.*;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        LargestRectangleInHistogram sol = new LargestRectangleInHistogram();
        int res = sol.largestRectangleArea(new int[] {7, 1, 7, 2, 2, 4});
        IO.println(res);
        res = sol.largestRectangleArea(new int[] {1, 3, 7});
        IO.println(res);
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] leftMost = new int[len];
        int[] rightMost = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            leftMost[i] = -1;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            rightMost[i] = len;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek();
            }
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            leftMost[i] += 1;
            rightMost[i] -= 1;
            maxArea = Math.max(maxArea, heights[i] * (rightMost[i] - leftMost[i] + 1));
        }

        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        int maxArea = 0;

        for (int i = 0; i < len; i++) {
            int height = heights[i];

            int rightMost = i + 1;
            while (rightMost < len && heights[rightMost] >= height) {
                rightMost++;
            }
            int leftMost = i;
            while (leftMost >= 0 && heights[leftMost] >= height) {
                leftMost--;
            }
            rightMost--;
            leftMost++;

            maxArea = Math.max(maxArea, height * (rightMost - leftMost + 1));
        }

        return maxArea;
    }
}
