package hackerearth;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        TreeMap<Integer , String> map = new TreeMap<>();
        for(int a0 = 0; a0 < n; a0++){
            String s[] = in.nextLine().split(" ");
            int count_4 = 0;
            int count_7 = 0;
            
            for( int i = 0; i< s[1].length() ;i++ ){
                if( s[1].charAt(i) == '4' )
                    count_4++;
                else if( s[1].charAt(i) == '7' )
                    count_7++;
                else{
                    break;
                }  
            }
            if( count_4 + count_7 == s[1].length() && count_4 == count_7){
                map.put(Integer.parseInt(s[1]),s[0]);
            }
        }
        Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();
        if( itr.hasNext() )
            System.out.println(map.get(itr.next().getKey()));
        else 
            System.out.println("-1");
        
        in.close();
    }
}
