package leetcode;

import java.util.Arrays;

public class wordwrape {

    public int wordwrap(int [] nums,int index,int dp[] ,int k){
        if (index>= nums.length) return 0;

        if (index == nums.length -1){
            return 0;
        }

        if (dp[index] != -1) return dp[index];
        int min = Integer.MAX_VALUE;
        int oneline = 0;
        int lines =0 ;
        for (int i = index; i < nums.length; i++) {
            oneline = oneline + nums[i];
            if (oneline<=k){
                 int result = (k - oneline)*(k - oneline) + wordwrap(nums,i+1,dp,k);
//                System.out.println(index+" "+result+" "+min+" "+oneline);
                 if(i==nums.length-1){
                     return 0;
                 }
                oneline+=1;
                min = Math.min(result,min);
            }else {
               break;
            }
        }
//        System.out.println(index+" "+min);
        dp[index] = min;
        return min;
    }
    public int solveWordWrap (int[] nums, int k)
    {
         int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return wordwrap(nums,0,dp,k);
    }
}
