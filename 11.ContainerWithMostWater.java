class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int area = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (min(height[i], height[j]) * (j - i) > area) {
                    area = min(height[i], height[j]) * (j - i);
                }
            }
        }
        return area;
    }

    public int min(int a, int b) {
        return a > b ? b : a;
    }
}