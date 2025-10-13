class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(candidates);
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
            currSum += candidates[level];
            currAns.add(candidates[level]);
            rec(level + 1, candidates, target, ans, currAns, currSum);
            while (level + 1 < candidates.length && candidates[level] == candidates[level + 1]) {
                level++;
            }

            //choice 2 not take
            currSum -= candidates[level];
            currAns.removeLast();
        }

        rec(level + 1, candidates, target, ans, currAns, currSum);
    }

}
