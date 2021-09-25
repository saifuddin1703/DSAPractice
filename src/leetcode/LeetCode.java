package leetcode;
import java.util.*;

public class LeetCode {

	
    static List<String> generateParenthesis(String brackets,int opening, int closing,int n ){
    	List<String> list = new ArrayList<>();
    	if(opening==0&&closing==0) {
    		list.add(brackets);
    		return list;
    	}
    	
    	if(opening != 0) {
//    		brackets+='(';
    		list.addAll(generateParenthesis(brackets+'(',opening-1,closing,n));
    		 
    	}
    	if(closing!=0&& (n-closing)<(n-opening)) {
    		list.addAll(generateParenthesis(brackets+')',opening,closing-1,n));
    	}
    	return list;
    }
	public static void main(String[] args) {

           List<String> ans = generateParenthesis("",3,3,3);
//           for(String i:ans) System.out.println(i);
           System.out.println(ans);

	}

}
