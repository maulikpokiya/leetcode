class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid + 1] > nums[mid]) {
                s = mid + 1;
            } else if (nums[mid - 1] > nums[mid]) {
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
