package Hakerrank;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
class MyCompRev implements Comparator<String>{
	
	@Override
	public int compare(String str1, String str2) {
		String s1 = str1;
		String s2 = str2;
		boolean flag1 = false;
		if( s1.startsWith("0") ){
			for( int i = 0 ;i<s1.length();i++ ){
				if( s1.charAt(i) != '0' ){
					s1 = s1.substring(i);
					flag1 = true;
					break;
				}
			}
			if( flag1 == false )
				s1 = "0";
		}
		boolean flag2 = false;
		if( s2.startsWith("0") ){
			for( int i = 0 ;i<s2.length();i++ ){
				if( s2.charAt(i) != '0' ){
					s2 = s2.substring(i);
					flag2 = true;
					break;
				}
			}
			if( flag2 == false )
				s2 = "0";
		}
		if( s1.equals(s2) ){
			if(s1.length()>s2.length())
				return 1;
			else
				return -1;
		}
			
		if(s1.length() != s2.length())
			return s2.length() - s1.length();
		return s2.compareTo(s1);
		
	}
}
class MyCompInc implements Comparator<String>{
	
	@Override
	public int compare(String str1, String str2) {
		String s1 = str1;
		String s2 = str2;
		boolean flag1 = false;
		if( s1.startsWith("0") ){
			for( int i = 0 ;i<s1.length();i++ ){
				if( s1.charAt(i) != '0' ){
					s1 = s1.substring(i);
					flag1 = true;
					break;
				}
			}
			if( flag1 == false )
				s1 = "0";
		}
		boolean flag2 = false;
		if( s2.startsWith("0") ){
			for( int i = 0 ;i<s2.length();i++ ){
				if( s2.charAt(i) != '0' ){
					s2 = s2.substring(i);
					flag2 = true;
					break;
				}
			}
			if( flag2 == false )
				s2 = "0";
		}
		
		if( s1.equals(s2) ){
			if(s1.length()>s2.length())
				return 1;
			else if (s1.length()<s2.length()) 
				return -1;
			else
				return 1;
		}
		if(s1.length() != s2.length())
			return s1.length() - s2.length();
		return s1.compareTo(s2);
		
	}
}

public class SortStrings {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String s[][] = new String[n][];
		for( int i =0; i < n; i++ ){
			String x[] = sc.nextLine().split(" ");
			s[i] = x;
		}

		String query[] = sc.nextLine().split(" ");



		if( query[2].equals("lexicographic")  ){

			TreeMap<String, String[]> map = null;
			if(query[1].equals("false")){
				map = new TreeMap<>((s1,s2) -> {
					return s1.compareTo(s2);
				});
			}else{
				map = new TreeMap<>((s1,s2) -> {
					return s2.compareTo(s1);
				});
			}


			for(int j =0 ;j < s.length;j++)
				map.put(s[j][Integer.parseInt(query[0])-1], s[j]);


			for( Entry<String, String[]> itr : map.entrySet() ){
				for( int i = 0 ; i < itr.getValue().length ;i++ ){
					if( i == itr.getValue().length - 1)
						System.out.print(itr.getValue()[i]);
					else
						System.out.print(itr.getValue()[i]+" ");
				}
				System.out.println();
			}

		} else{
			TreeMap<String, String[]> map = null;
			if(query[1].equals("false")){
				map = new TreeMap<>(new MyCompInc());
			}else{
				map = new TreeMap<>(new MyCompRev());
			}

			for(int j =0 ;j < s.length;j++){
				String store = s[j][Integer.parseInt(query[0])-1];
				
				map.put(store, s[j]);
			}


			for( Entry<String, String[]> itr : map.entrySet() ){
				for( int i = 0 ; i < itr.getValue().length ;i++ ){
					if( i == itr.getValue().length - 1)
						System.out.print(itr.getValue()[i]);
					else
						System.out.print(itr.getValue()[i]+" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
