package leetcode;

public class minimumpathsum {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        int min = Integer.MAX_VALUE;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (j+1>=n&&i+1>=m){
                    dp[i][j] = grid[i][j];
                }else
                if (j+1>=n){
                    dp[i][j] = dp[i+1][j] + grid[i][j];
                }else
                if (i+1>=m){
                    dp[i][j] = dp[i][j+1]+ grid[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) + grid[i][j];
                }
            }
        }

        return dp[0][0];
    }
}
