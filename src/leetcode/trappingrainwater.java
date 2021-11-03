package leetcode;

public class trappingrainwater {
    public int trap(int[] a) {
        int n = a.length;
        int current = 1;
        int low = 1;
        int high = n-1;
        int i =1;
        int j = n-1;
        int maxWater = 0;
        while(i<=j){

            if(low>high){
                if(a[j]>a[low]){
                    if(a[i]>a[high]){
                        low = high;
                        high = j;
                        i++;
                    }else{
                        low = j;
                        j--;
                    }
                }else{
                    maxWater = a[low] - a[j];
                    j--;
                }
            }else{
                if(a[i]>a[low]){
                    if(a[i]>a[high]){
                        low = high;
                        high = i;
                        j--;
                    }else{
                        low = i;
                        i++;
                    }
                }else{
                    maxWater = a[low] - a[i];
                    i++;
                }
            }
        }
        return maxWater;
    }
}
