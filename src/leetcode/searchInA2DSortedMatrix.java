package leetcode;

public class searchInA2DSortedMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0;
        int hi = m-1;

        while (lo<=hi){
            int mid = (lo+hi)/2;

            if (target>=matrix[mid][0]&&target<=matrix[mid][n-1]){
                int l = 0;
                int r = n-1;
                while (l<=r){
                    int rmid = (l+r)/2;
                    if (matrix[mid][rmid] == target) return true;

                    if (matrix[mid][rmid] > target) r = rmid -1;
                    else
                        l = mid+1;
                }
                return false;
            }

            if (matrix[mid][0]>target)
                hi = mid -1;
            else lo = mid +1;
        }
        return false;
    }

}
