class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int target, int start, List<Integer> list, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i=start; i<nums.length && target >= nums[i]; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            backtrack(nums, target-nums[i], i+1, list, result);
            list.remove(list.size()-1);
        }
    }
}
