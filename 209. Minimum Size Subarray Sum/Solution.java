class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;
        while(right < nums.length) {
            if(nums[right] >= target) {
                return 1;
            }

            currSum += nums[right];

            while(currSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currSum -= nums[left];
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
