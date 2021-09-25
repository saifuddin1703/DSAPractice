package HackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    // Write your code here
          
          Stack<Character> balance = new Stack();
          int n = s.length();
          for(int i=0; i<n; i++){
              char ch = s.charAt(i);
              if(ch== '('||ch=='{'||ch == '['){
                  balance.push(ch);
              }else{
                  if(balance.isEmpty()) return "NO";
                  char top = balance.peek();
                  
                  if(
                      (ch==')'&&top=='(')||
                      (ch==']'&&top=='[')||
                      (ch=='}'&&top=='{')
                  ) balance.pop();
                  else return "NO";
              }
          }
          
          if(balance.isEmpty()) return "YES";
          return "NO";
    }

}

public class BalaceParenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
