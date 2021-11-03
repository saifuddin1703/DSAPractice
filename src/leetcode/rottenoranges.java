package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class rottenoranges {
    public int orangesRotting(int[][] grid) {
        int time =-1;

        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2){
                    int pos = n* i + j;
                    bfs.add(pos);
                    break;
                }
            }
        }

        while (!bfs.isEmpty()){
            int k = bfs.size();
            System.out.println(bfs);
            for (int i = 0; i < k; i++) {
                int pos = bfs.remove();
                int row = pos/n;
                int col = pos%n;

                if (row -1>=0&&grid[row -1][col] != 0&&grid[row -1][col] != 2){
                    grid[row -1][col] = 2;
                    bfs.add(n* (row-1) + (col));
                }

                if (row+1<m&&grid[row+1][col]!=0&&grid[row+1][col]!=2){
                    grid[row+1][col] = 2;
                    bfs.add(n* (row+1) + (col));

                }

                if (col-1>=0&&grid[row][col-1]!=0&&grid[row][col-1]!=2){
                    grid[row][col-1] = 2;
                    bfs.add(n* (row) + (col-1));

                }
                if (col+1<n&&grid[row][col+1]!=0&&grid[row][col+1]!=2){
                    grid[row][col+1] = 2;
                    bfs.add(n* (row) + (col+1));

                }
            }
            time++;
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                   return -1;
                }
            }
        }
          return time;
    }
}
