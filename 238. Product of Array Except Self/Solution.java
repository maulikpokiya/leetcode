class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int prefixProduct = 1;
        int postfixProduct = 1;
        int[] result = new int[N];

        for (int i = 1; i < N; i++) {
            prefixProduct *= nums[i - 1];
            result[i] = prefixProduct;
        }

        for (int j = N - 2; j > 0; j--) {
            postfixProduct *= nums[j + 1];
            result[j] *= postfixProduct;
        }
        result[0] = postfixProduct * nums[1];

        return result;
    }
}
