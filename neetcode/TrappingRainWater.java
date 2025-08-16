

/**
 * https://neetcode.io/problems/trapping-rain-water?list=neetcode150
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater sol = new TrappingRainWater();
        System.out.println(sol.trap(new int[] {0, 2, 0, 3, 1, 0, 1, 3, 2, 1}));
        System.out.println(sol.trap2(new int[] {0, 2, 0, 3, 1, 0, 1, 3, 2, 1}));
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = height[i];
            int rightMax = height[i];

            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}
