package leetcode;

public class DivideWithoutOperator {
	  public static String timeConversion(String s) {
		    // Write your code here

		        String meridian = s.substring(s.length()-2,s.length());
		        int hours = Integer.parseInt(s.substring(0,2));
		        String result = "";
		        String remainingTime = s.substring(2,s.length()-2);
		        if(meridian.equals("AM")){
		            if(hours==12){
		                result = "00";
		            }else{
		                return s.substring(0,s.length()-2);
		            }
		        }else{
		            if(hours<12){
		                result = String.valueOf(hours+12);
		            }
		        }
//		        return result+remainingTime;
		        return meridian ;
		    }
	 public static int divide(long dividend, long divisor) {
	        
	        int ans =0;
	        long dividend2 = dividend;
	        long divisor2 = divisor;
	        if((dividend<0&&divisor<0)||(dividend>0&&divisor>0)){
	        while(Math.abs(dividend)>=Math.abs(divisor)){
	            dividend -= divisor;
	            ans++;
//	            System.out.println(ans);
	        }
	        }
	        else{
	          while(Math.abs(dividend)>=Math.abs(divisor)){
	            dividend += divisor;
	            ans--;
	        }  
	         
	        }
	        if(ans==Integer.MIN_VALUE) return Integer.MAX_VALUE;
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
             
		 long divisor2 = 2147483648L;
		 String s= "111111";
		System.out.println(timeConversion("01:00:00AM"));
	}

}
