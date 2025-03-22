class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int left=0;
        int right=0;
        int zeroCount=0;
        int maxLen=0;

        while(right < nums.length) {
            if(nums[right] == 0) {
                if(zeroCount < k) {
                    zeroCount++;
                } else {
                    maxLen = Math.max(right-left, maxLen);
                    while(nums[left] == 1) {
                        left++;
                    }
                    left++;
                }
            }
            right++;
        }
        maxLen = Math.max(right-left, maxLen);
        return maxLen;
    }
}
