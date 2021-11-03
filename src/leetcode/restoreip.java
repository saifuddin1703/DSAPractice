package leetcode;

import java.util.ArrayList;
import java.util.List;

public class restoreip {

    public void restore(String s, String ip,int len,int dots,List<String>ips){

        if (dots==0){
            if (s.length()>3||s.length()==0) return ;
            if (s.charAt(0)=='0'&&s.length()>1) return;

            int val = Integer.parseInt(s.toString());
            if (val >255) return;
            ip+=s;
            System.out.println(ip);

            ips.add(ip);
        }

        if (len==0) return;

         StringBuilder num = new StringBuilder();
        for (int i = 0; i < 3&&i<len; i++) {
             num.append(s.charAt(i));
             int val = Integer.parseInt(num.toString());
             if (val >255) return;
            if (num.toString().equals("0")){
               restore(s.substring(i + 1, len),ip+num+'.', len - i - 1, dots - 1,ips);
               break;
            }
            restore(s.substring(i + 1, len),ip+num+'.', len - i - 1, dots - 1,ips);
        }
//        return ;
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<>();
        restore(s,"",s.length(),3,ips);
        return ips;
    }
}
