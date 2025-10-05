class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums); //bring duplicates togetther
        rec(0, nums, new LinkedList<>());
        return ans;
    }
    public void rec(int index, int []nums, List<Integer> currAns) {
        if(index>=nums.length) {
            ans.add(new ArrayList<>(currAns));
            return;
        }

        currAns.add(nums[index]);
        rec(index+1, nums, currAns);

        currAns.removeLast();
        while(index+1<nums.length && nums[index]==nums[index+1]) {
            index++;
        }
        rec(index+1, nums, currAns);
    }
}
