package leetcode;

public class FindFirstandLastPositionofElementinSortedArray {

	public static int rangeStarting(int[] nums,int target , int lo ,int hi) {
		int mid = (lo+hi)/2;
		if(lo>hi) return -1;
		if(lo==hi) {
			if(nums[lo]==target)
			return lo;
			else
			return -1;
		}
		if(nums[mid]==target) {
			int ans = rangeStarting(nums,target ,lo,mid-1);
			return (ans==-1)? mid: ans;
		}else {
			int ans = rangeStarting(nums,target, mid +1,hi);
			return (ans==-1)? mid: ans;
		}
	}
	public static int rangeEnding(int[] nums,int target , int lo ,int hi) {
		int mid = (lo+hi)/2;
		if(lo>hi) return -1;
		System.out.println(lo+" "+hi);
		 
		if(lo==hi) {
			if(nums[lo]==target)
			return lo;
			else
			return -1;
		}
		if(nums[mid]==target) {
			int ans= rangeEnding(nums,target,mid+1,hi);
			return (ans==-1)? mid: ans;
		}else {
			int ans= rangeEnding(nums,target,lo,mid-1);
			return (ans==-1)? mid: ans;
		}
	}
	 public static int[] searchRange(int[] nums, int target) {
		 int ans [] = new int[2];
		 int lo = 0;
		 int hi = nums.length-1;
		 
		 
		 while(lo<=hi) {
			 int mid = (lo+hi)/2;
			 if(nums[mid]==target) {
				 ans[0] = rangeStarting(nums,target,lo,mid);
				 ans[1] = rangeEnding(nums,target,mid,hi);
				 return ans;
			 }
			 
			 if(target>nums[mid]) lo = mid+1;
			 else hi = mid-1;
			 
		 }
		 return ans;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans[] = searchRange(new int[] {1,2,2,2,3},2);
		System.out.println("searched element is : "+ans[0]+" "+ans[1]);
		System.out.print(Math.pow(2, -2147483648));
	}

}
