package Stack;

import java.util.Scanner;
import java.util.Stack;

class BalanceBracket{
	boolean bracketPairCheck(char a, char b) {
		
		if( a =='(' && b == ')' )
			return true;
		else if( a == '[' && b == ']' )
			return true;
		else if( a == '{' && b == '}' )
			return true;
		else 
			return false;
	}
	
	boolean bracketCheck( String bracket ) {
		
		Stack<Character> st = new Stack<Character>();
		
		for(int i = 0 ;i < bracket.length() ; i++ ) {
			
			if(bracket.charAt(i) == '{' || bracket.charAt(i) == '[' || bracket.charAt(i) == '('){
				st.push( bracket.charAt(i) );
				System.out.print(bracket.charAt(i));
			} else {
				System.out.print(bracket.charAt(i));
				if( st.isEmpty() )
					return false;
				
				if( bracketPairCheck( st.pop(), bracket.charAt(i) ) == false )
					return false;	
				
			}
			
		}
		
		if( st.isEmpty() )
			return true;
		else 
			return false;				
	}
	
	
}

public class BalancedBrackets {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BalanceBracket balanceBracket = new BalanceBracket();
		int n = sc.nextInt();	
		
		for( int i =0; i<n; i++ ){
			
			String brackets = sc.next();
			
			if( balanceBracket.bracketCheck(brackets) ){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		}
		sc.close();
	}

}
