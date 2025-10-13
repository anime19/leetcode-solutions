class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        rec(0, candidates, target, ans, new LinkedList<>(), 0);
        return ans;
    }

    public void rec(int level, int[] candidates, int target, List<List<Integer>> ans, List<Integer> currAns,
            int currSum) {
        if (currSum == target) {
            ans.add(new LinkedList<>(currAns));
            return;
        }
        if (level >= candidates.length) {

            return;
        }

        //choice 1 take
        if (currSum + candidates[level] <= target) {
            currAns.add(candidates[level]);
            rec(level, candidates, target, ans, currAns, currSum + candidates[level]);
            currAns.removeLast();
        }

        //choice 2 not take

        rec(level + 1, candidates, target, ans, currAns, currSum);

    }

}
