package leetcode;

public class longestPalindromicSubstirng {
    public String longestPalindrome(String s) {

        String longestSubstring = "";
        int maxlength = -1;
        int n = s.length();

        int[][] dp = new int[n][124];

        dp[0][s.charAt(0)]++;
        for (int i = 1; i < n; i++) {
            dp[i][s.charAt(i)]++;
            for (int j = '0'; j <= 'z'; j++) {
                dp[i][j] += dp[i-1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int oddcount =0;
                if (i-1>=0){

                    for (int k = '0'; k <= 'z'; k++) {
                       int diff = dp[j][k] - dp[i-1][k];
                       if (diff%2!=0) oddcount++;
                    }
                }else{
                    for (int k = '0'; k <= 'z'; k++) {
                        int diff = dp[j][k];
                        if (diff%2!=0) oddcount++;
                    }
                }
                if (oddcount<2){
//                        longestSubstring =
                    int len = j-1 +1;
                    if (len>maxlength){
                        longestSubstring = s.substring(i,j+1);
                        maxlength = len;
                    }
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = '0'; j <= 'z'; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
     return longestSubstring;
    }
}
