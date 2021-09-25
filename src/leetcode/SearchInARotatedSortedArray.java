package leetcode;

public class SearchInARotatedSortedArray {

	 public static int search(int[] nums, int target) {
		 
		 int lo =0 ; 
		 int hi = nums.length-1;
		 
		 
//		 while(lo<=hi) {
//			 int mid = (lo+hi)/2;
//			 System.out.println(mid);
//			 if(nums[mid]==target) return mid;
//			 
//			 if(lo==hi) {
//				 if(nums[hi]==target) return hi;
//				 else return -1;
//			 }
//			 if(mid==lo) {
//				 if(nums[mid]==target) return mid;
//				 else return -1;
//			 }
//			 if(mid==hi) {
//				 if(nums[mid]==target) return mid;
//				 else return -1;
//			 }
//			 if(nums[lo]<=nums[mid-1]) {
//				 if(target>=nums[lo]&&target<=nums[mid-1]) {
//					 hi = mid-1;
//					 continue;
//				 }else {
//					 lo = mid+1;
//					 continue;
//				 }
//			 }
//			 
//			 if(nums[mid+1]<=nums[hi]) {
//				 if(target>=nums[mid+1]&&target<=nums[hi]) {
//					 lo = mid+1;
//				 }else {
//					 lo = mid-1;
//				 }
//			 }
//		 }
//	        return -1;
		 
		 
		 while(lo<=hi) {
			 int mid = (lo+hi)/2;
			 if(nums[mid]==target) return mid;
			 
			 
			 if(nums[lo]<=nums[mid]) {
				 if(target>=nums[lo]&&target<=nums[mid]) {
					 hi = mid-1;
				 }else {
					 lo = mid+1;
				 }
			 }else {
				 if(target>=nums[mid]&&target<=nums[hi]) {
					 lo = mid+1;
				 }else {
					 hi = mid-1;
				 }
			 }
			 
		 }
		 return -1;
	    }
	 
	public static void main(String[] args) {
		System.out.println("hellow");
		System.out.println("searched element is : "+search(new int[] {1,2},2));
	}

}
