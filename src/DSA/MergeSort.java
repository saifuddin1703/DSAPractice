package DSA;

import java.util.Scanner;

public class MergeSort {

	public int[] mergeSort(int a[],int start, int end) {
		System.out.println(start+ " "+end);
		int n = end - start +1;
//		if(n<=1) return a;
		if(start==end) return new int[] {a[start]};
		
		int mid = (start+end)/2;
		
		int[] left = mergeSort(a,start,mid);
		int[] right = mergeSort(a,mid+1,end);
		
		return merge(left,right);
	}
	
	private int[] merge(int[] left, int[] right) {
		 
		int i=0,j=0,k=0;
		int n = left.length,m = right.length;
		int[] mergedArray = new int[n+m];
		
		while(i<n&&j<m) {
			if(left[i]<right[j]) {
				mergedArray[k] = left[i];
				i++;
				k++;
			}else {
				mergedArray[k] = right[j];
				j++;
				k++;
			}
		}
		
		while(i<n) {
			mergedArray[k] = left[i];
			i++;
			k++;
		}
		
		while(j<m) {
			mergedArray[k] = right[j];
			j++;
			k++;
		}
		return mergedArray;
	}

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		int result[] = {5,4,3,2,1};
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		
		System.out.print(s);
//	   result = sort.mergeSort(result, 0, 4);
//	    for(int i:result) System.out.print(i+" ");
//	    Arrays
	}
}
