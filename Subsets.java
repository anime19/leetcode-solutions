class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        rec(0, nums, new LinkedList<>(), ans);
        return ans;
    }
    public void rec(int level, int[] nums, List<Integer> currAns, List<List<Integer>> ans) {
        if(level > nums.length) return;
        if(level == nums.length) {
            ans.add(new LinkedList<>(currAns));
            return;
        }
        currAns.add(nums[level]); //take
        rec(level+1, nums, currAns, ans);
        currAns.removeLast(); //not take
        rec(level+1, nums, currAns, ans);
    }
}
