package dynamic_programing;

/**
 * https://leetcode.com/submissions/detail/116247486/
 * 方法一: 动态规划, 使用额外的空间，不改变输入
 * 方法二: 动态规划, 使用现有的空间，改变了输入
 */
public class MinimumPathSum {

    public int minPathSum1(int[][] grid) {

        if(grid==null){
            return -1;
        }
        int m = grid.length; int n = grid[0].length;
        int [][]dp = new int [m][n];

        int sum=0;
        for(int i=n-1;i>=0;i--){
            sum += grid[m-1][i];
            dp[m-1][i] = sum;
        }

        sum=0;
        for(int i=m-1;i>=0;i--){
            sum += grid[i][n-1];
            dp[i][n-1] = sum;
        }

        for(int i=m-2; i>=0; i--){
            for(int j=n-2 ; j>=0; j--){
                dp[i][j] = dp[i+1][j] < dp[i][j+1] ? dp[i+1][j] : dp[i][j+1] ;
                dp[i][j] += grid[i][j];
            }
        }

        return dp[0][0];
    }


    public int minPathSum2(int[][] grid) {

        if(grid==null){
            return -1;
        }
        int m = grid.length; int n = grid[0].length;

        int sum=0;
        for(int i=n-1;i>=0;i--){
            sum += grid[m-1][i];
            grid[m-1][i] = sum;
        }

        sum=0;
        for(int i=m-1;i>=0;i--){
            sum += grid[i][n-1];
            grid[i][n-1] = sum;
        }

        for(int i=m-2; i>=0; i--){
            for(int j=n-2 ; j>=0; j--){
                grid[i][j] += grid[i+1][j] < grid[i][j+1] ? grid[i+1][j] : grid[i][j+1] ;
            }
        }

        return grid[0][0];
    }
}
