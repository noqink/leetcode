public class Code746_minCostClimbingStairs {
    public static int minCostClimbingStairs1(int[] cost) {
        // 暴力递归
        return Math.min(f(cost, 0), f(cost, 1));
    }
    public static int f(int[] cost, int n){
        // n表示走到哪
        if (n >= cost.length){
            return 0;
        }
        return Math.min(f(cost, n + 1), f(cost, n + 2)) + cost[n];
    }

    public static int minCostClimbingStairs(int[] cost) {
        // 动态规划
        if (cost.length <= 0){
            return 0;
        }
        if (cost.length == 1){
            return cost[0];
        }
        int N = cost.length;
        int[] dp = new int[N + 1];

//        if (n >= cost.length){
//            return 0;
//        }
        // 转化为
        dp[N] = 0;
        // return Math.min(f(cost, n + 1), f(cost, n + 2)) + cost[n];
        // dp[N-1] = cost[N-1] + min(0, 越界)
        // dp[N-2] = cost[N-2] + min(0, cost[N-1])
        // 所以
        dp[N - 1] = cost[N - 1];
        dp[N - 2] = cost[N - 2];

        for (int i = N - 3; i >= 0; i--){
            dp[i] = Math.min(dp[i+1],dp[i + 2]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        int[] cost = {0, 0, 1, 0, 1};
        int c = minCostClimbingStairs(cost);
        System.out.println(c);
    }

}
