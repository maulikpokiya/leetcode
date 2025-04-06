class NumArray {
    int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? prefix[right] : prefix[right] - prefix[left - 1];
    }
}
