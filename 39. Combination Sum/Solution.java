class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, new ArrayList<>(), res, target, 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res, int target, int start) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, list, res, target-nums[i], i);
            list.remove(list.size()-1);
        }
    }
}
