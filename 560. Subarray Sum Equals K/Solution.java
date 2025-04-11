class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int total = 0;
        for(int j=0; j<prefix.length; j++) {
            int curr = prefix[j];
            if(map.containsKey(curr-k)) {
                total += map.get(curr-k);
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return total;
    }
}
