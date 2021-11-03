package leetcode;

import java.util.Arrays;

public class JumpGame {
    public static int jumpgame(int[]nums,int dp[],int index,int moves){
//        if (index == nums.length -1) return 1;
        if (index >=nums.length) return -1;


        if (dp[index] > 0) return dp[index];
        if (dp[index] == -1) return -1;

        int maxJumps = nums[index];
        int minMoves = Integer.MAX_VALUE;

//        if (dp[index] == 0)
        for (int i = maxJumps; i >= 1; i--) {
            int destination = i + index;
            if (destination == nums.length -1) {
                dp[index] = 1;
                return 1;
            }
            int result = jumpgame(nums,dp,destination,moves+1);
            if (result != -1) {
                minMoves = Math.min(minMoves, result);
            }
        }


        if (minMoves == Integer.MAX_VALUE) {
            dp[index] = -1;
            minMoves = -1;
            return -1;
        }
        else
            dp[index] = minMoves+1;


        System.out.println(index+" "+(minMoves+1));
        return minMoves+1;
    }
    public static int jump(int[] nums) {
        int dp [] = new int[nums.length];
//        Arrays.fill(dp,-1);
         return jumpgame(nums,dp,0,0);
    }

    public static void main(String[]args){
        int a[] = {9,8,2,2,0,2,2,0,4,1,5,7,9,6,6,0,6,5,0,5};
//        int a[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38};
        System.out.println("result"+jump(a));
    }
}
