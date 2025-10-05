class Solution {
    int dp[];

    public int climbStairs(int n, int[] costs) {
        if (n == 0)
            return 0;
        if (n == 1)
            return costs[0] + 1 * 1;
        if (n == 2) {
            int path1 = costs[0] + 1 * 1 + costs[1] + 1 * 1; // 0->1->2
            int path2 = costs[1] + 2 * 2; // 0->2
            return Math.min(path1, path2);
        }

        int dp0 = 0; // cost to reach step 0
        int dp1 = costs[0] + 1 * 1; // cost to reach step 1 from 0
        int dp2 = Math.min(
                dp1 + costs[1] + 1 * 1, // step 1 → 2
                dp0 + costs[1] + 2 * 2 // step 0 → 2
        );

        int first = dp0; // i-3
        int second = dp1; // i-2
        int third = dp2; // i-1

        for (int i = 3; i <= n; i++) {
            int current = Math.min(
                    third + costs[i - 1] + 1 * 1,
                    Math.min(
                            second + costs[i - 1] + 2 * 2,
                            first + costs[i - 1] + 3 * 3));
            first = second;
            second = third;
            third = current;
        }

        return third;

    }

    public int climbStairsTopDownMemo(int n, int[] costs) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return rec(0, n, costs);
    }

    public int rec(int level, int n, int[] costs) { //return minimum cost to reach n from level if we know the min cost from 0 to level-1
        if (level == n) {
            return 0;
        }
        if (dp[level] != -1)
            return dp[level];

        int cost = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
            if (level + i <= n) {
                cost = Math.min(cost, costs[level + i - 1] + i * i + rec(level + i, n, costs));
            }
        }
        return dp[level] = cost;

    }
}
