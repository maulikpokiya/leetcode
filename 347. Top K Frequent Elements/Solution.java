class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counts = new HashMap<>();

        for(int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] sorted = new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer> entry : counts.entrySet()) {
            if(sorted[entry.getValue()] == null) {
                sorted[entry.getValue()] = new ArrayList<>();
            }
            sorted[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int r=0;
        for(int i=nums.length; i>0; i--) {
            if(sorted[i] != null) {
                for(int num : sorted[i]) {
                    result[r] = num;
                    r++;
                }
                if(r == k) {
                    break;
                }
            }
        }
       return result;
    }
}
