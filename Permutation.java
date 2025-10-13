class Solution {
    int used[];
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        used = new int[nums.length];
        Arrays.fill(used,-1);
        rec(nums, ans, new LinkedList<>());
        return ans;
    }
    public void rec(int[] nums, List<List<Integer>> ans, List<Integer> currAns) {
        if(currAns.size()==nums.length) {
            ans.add(new LinkedList<>(currAns));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(used[i]==-1) {
                used[i]=1;
                currAns.add(nums[i]);
                rec(nums, ans, currAns);
                currAns.removeLast();
                used[i]=-1;
            }
        }
    }
}
