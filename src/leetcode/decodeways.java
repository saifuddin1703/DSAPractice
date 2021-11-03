package leetcode;

import java.util.Arrays;

public class decodeways {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return decode(s,0,s.length()-1,dp);
    }

    public int decode(String s, int st, int en, int[] dp){

        if (st==en)
            if (s.charAt(st)=='0') return 0;
            else
        return 1;
        if (st>en) return 1;
        if (s.charAt(st)=='0') return 0;

        if (dp[st]!=-1) return dp[st];

            int ways = 0;
        for (int i = st; i < st+2&&i<=en; i++) {
            if (i==st+1){
                int digit = (s.charAt(st)-'0')*10 + (s.charAt(i) - '0');
                if (digit>26) return ways;
            }
            ways += decode(s,i+1,en, dp);
//            ways++;
        }
        dp[st] = ways;
        return ways;
    }
}
