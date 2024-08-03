import java.util.*;

public class Main {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < strs.size();i++) {
            sb.append(strs.get(i).length()+"/"+strs.get(i));
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        int pos = 0;
        List<String> list = new ArrayList<>();
        while(pos < str.length()) {
          int start = str.indexOf("/", pos);
          int len = Integer.valueOf(str.substring(pos,start));
          pos = start + 1;
          String decodeStr = str.substring(pos, pos+len);
          list.add(decodeStr);
          pos = pos + decodeStr.length();
        }
        return list;
    }
    
    public static void main(String[] args) {
      List<String> test = new ArrayList<>();
      test.add("man");
      test.add("cat");
      test.add("rat");
      test.add("psnd bcd hcd");
      String encode = encode(test);
      System.out.println(encode);
      System.out.println(decode(encode));
    }
}