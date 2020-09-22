class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] robList = new int[nums.length];
        robList[0] = nums[0];
        robList[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int value = nums[i];
            robList[i] = Math.max(robList[i - 1], robList[i - 2] + value);
        }
        return robList[robList.length - 1];
    }
}