package leetcode;
class Solution {

    String addTwoStrings(String s1,String s2){
        StringBuilder ans = new StringBuilder();

        int i = s1.length()-1;
        int j = s2.length()-1;
        int carry = 0;
        while (i>=0&&j>=0){
            int digit1 = s1.charAt(i) - '0';
            int digit2 = s2.charAt(j) - '0';
            int sum = digit1 + digit2 + carry;
            carry = sum/10;
            int anschar = (sum%10) + '0';
            ans.append((char) anschar);
            i--;
            j--;
        }

        while (i>=0){
            int digit1 = s1.charAt(i) - '0';
            int sum = digit1 + carry;
            carry = sum/10;
            int anschar = (sum%10) + '0';
            ans.append((char) anschar);
            i--;
        }
        while (j>=0){
            int digit2 = s2.charAt(j) - '0';
            int sum = digit2 + carry;
            carry = sum/10;
            int anschar = (sum%10) + '0';
            ans.append((char) anschar);
            j--;
        }

        if(carry!=0){
            int temp = '0' + carry;
            ans.append((char) temp);
        }
        ans = ans.reverse();
        return ans.toString();
    }
    String singleMultiply(String num, int mul,int zeros){
        char [] array = num.toCharArray();
        int carry =0 ;
        StringBuilder ans = new StringBuilder();
        for(int i=num.length()-1; i>=0; i--){
            int digit = array[i] - '0';
            int temp = digit * mul + carry;
            carry = temp/10;
            int multemp = '0'+temp%10;
            char multipliedchar = (char)multemp;
            ans.append(multipliedchar);
        }
        if(carry!=0){
            int temp = '0' + carry;
            ans.append((char) temp);
        }
       ans =  ans.reverse();
        while(zeros-->0){
            ans.append("0");
        }
         return ans.toString();
    }

    boolean isOnlyZero(String ans){
        boolean onlyzero = true;
        for (int i =0; i<ans.length(); i++){
            if (ans.charAt(i) != '0') {
                onlyzero = false;
                break;
            }
        }
        return onlyzero;
    }
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        String ans = "0";
        for (int i =0 ; i<n; i++){
            int digit = num1.charAt(i) - '0';
           ans = addTwoStrings(ans,singleMultiply(num2,digit,n-i-1));
        }
        if (isOnlyZero(ans)) return "0";
        return ans;
    }
}
public class MuliplyStrings {
      public static void main(String []args){
          Solution sc = new Solution();
          System.out.println(sc.multiply("12","62"));
      }
}
