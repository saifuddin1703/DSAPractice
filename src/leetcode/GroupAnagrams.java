package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        int chars [][] = new int[n][124];

        for (int j = 0; j < n; j++) {
            String word = strs[j];
           for (int i = 0; i < word.length(); i++) {
               chars[j][(int) word.charAt(i)]++;
           }
       }

        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            String word = strs[i];
            List<String> group = new ArrayList<>();
            if (!visited[i]) {
                group.add(word);
                for (int j = i+1; j < n; j++) {
                        if (word.length()== strs[j].length()){
                            boolean isanagram = true;
                            for (int k = 'a'; k <= 'z'; k++) {
                                if (chars[i][k]!=chars[j][k]){
                                    isanagram = false;
                                }
                            }
                            if (isanagram) {
                                group.add(strs[j]);
                                visited[j] = true;
                            }
                        }
                }
                ans.add(group);
            }
        }
         return ans;
    }
    public static void main(String[] args){
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
