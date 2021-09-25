package leetcode;
import java.util.*;

public class LetterCombinationsofaPhoneNumber {

	
	static List<String> permute(String [] strings, int left,int right, int n, String currentGeneratedString){
		
		List<String> permutations = new ArrayList<String>();
		String current = strings[left];
		if(n==0) return permutations;
		if(left==right) {
			
			for(int i =0; i<current.length(); i++) {
				char ch = current.charAt(i);
				permutations.add(currentGeneratedString+ch);
			}
			return permutations;
			
		}
		
		for(int i=0; i<current.length(); i++) {
			String ch = currentGeneratedString + current.charAt(i);
			permutations.addAll(permute(strings,left+1,right,n,ch));
		}
		
		return permutations;
	}
	public static void main(String[] args) {


		List<String> list = permute(new String[] {"abc","def"},0,1,2,"");
		System.out.print(list);
	}

}
