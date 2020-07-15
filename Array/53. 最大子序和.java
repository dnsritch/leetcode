class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxRes = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxRes = Math.max(pre, maxRes);
        }
        return maxRes;
    }
}