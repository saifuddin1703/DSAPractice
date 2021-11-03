package leetcode;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int st = newInterval[0];
        int en = newInterval[1];

        int nst = 0;
        int i =0;
        int n = newInterval.length;
        for (i = 0; i < n && newInterval[0]<=intervals[i][0]; i++) {

        }

        if (i-1>=0){
             if (intervals[i-1][0] == newInterval[0]) nst = i-1;


            for (int j = 0; j < n&& intervals[j][1]<newInterval[1]; j++){}


        }
        return new int[1][1];
    }
}
