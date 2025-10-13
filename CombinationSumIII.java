class Solution {
    int k;

    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        int[] candidates = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        this.k = k;
        rec(0, candidates, target, ans, new LinkedList<>(), 0);
        return ans;
    }

    public void rec(int level, int[] candidates, int target, List<List<Integer>> ans, List<Integer> currAns,
            int currSum) {
        if (currSum == target && currAns.size() == k) {
            ans.add(new LinkedList<>(currAns));
            return;
        }
        if (level >= candidates.length ) {
            return;
        }

        //choice 1 take
        if((currSum + candidates[level] <= target) && (currAns.size() + 1 <= k)) {
            currSum += candidates[level];
            currAns.add(candidates[level]);
            rec(level + 1, candidates, target, ans, currAns, currSum);
            // undo
            currSum -= candidates[level];
            currAns.removeLast();
        }
        //choice 2 not take
        rec(level + 1, candidates, target, ans, currAns, currSum);
    }

}
