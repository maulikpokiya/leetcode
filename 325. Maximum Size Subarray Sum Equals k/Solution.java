class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] == k ? 1 : 0;
        }

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int maxSize = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < prefix.length; j++) {
            int curr = prefix[j];
            if (curr == k) {
                maxSize = Math.max(maxSize, j + 1);
            }
            if (map.containsKey(curr - k)) {
                maxSize = Math.max(maxSize, j - map.get(curr - k));
            }
            map.putIfAbsent(curr, j);
        }
        return maxSize;
    }
}
