class Solution {
    private int target;
    private int dp[];
    public int climbStairs(int n) { 
        if(n==0 || n==1) return 1;
        int first = 1, second = 2;
        for(int i=3; i<=n; i++) {
            int ways = first + second;
            first = second;
            second = ways;
        }
        return second;
    }
    public int climbStairsDP(int n) {
        target = n;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return rec(0, target);
    }
    public int rec(int level, int target) {
        // if(level>target) return 0; //out of bounds pruning
        if(level==target) return 1; // we reached the target level so we have to return it as a valid ans and since it's a couting problme we will have to return 1;
        if(dp[level]!=-1) return dp[level];
        //loop on choices so we have 2 choices 1 and 2
        int ans=0;
        for(int step = 1; step<=2; step++) {
            //validate a choice
            if(level+step<=target) {
                ans += rec(level+step, target); // we have to find total ways and from each step multiple ways exist and since they are additive in nature so we have to add all of them
            }
        }
        dp[level] = ans;
        return ans;
    }
}
