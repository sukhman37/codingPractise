package Tech_Question;

import java.util.Scanner;

public class Number_To_Word {
	
	final int Billion = 1000000000;
	final int Million = 1000000;
	final int Thousand = 1000;
	final int Hundard = 100;
	
	String onePlaceDigit[] = {"" , "one" , "two" , "three", "four", "five","six","seven","eight","nine"};
	
	String twoPlaceDigit[] = {"","ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
	
	public String doubleDigitToWord( int num ){
		if(num == 11) return "eleven";
		if(num == 12) return "twelve";
		if(num == 13) return "thirteen";
		if(num == 14) return "fourteen";
		if(num == 15) return "fifeteen";
		if(num == 16) return "sixteen";
		if(num == 17) return "seventeen";
		if(num == 18) return "eighteen";
		if(num == 19) return "nineteen";
		else
			return twoPlaceDigit[num/10] +" "+ onePlaceDigit[num%10];
	}
	int getBase(int num){
		if(num/Billion >= 1) return Billion;
		if(num/Million >= 1) return Million;
		if(num/Thousand >= 1) return Thousand;
		if(num/Hundard >= 1) return Hundard;
		return -1;
	}
	
	String baseToWord(int num){
		if(num == Billion) return "billion";
		if(num == Million) return "million";
		if(num == Thousand) return "thousand";
		if(num == Hundard) return "hundred";
		return "";
	}
	// Recursive call to function
	String numToWord(int num){
		String finalString = "";
		if(num < 10) finalString = onePlaceDigit[num];
		else if(num >=10 && num < 100) finalString = doubleDigitToWord(num);
		else{
			int m = getBase(num); //find base
			finalString =  numToWord(num/m) +" "+ baseToWord(m) +" "+ numToWord(num%m);
		}
		return finalString;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Number_To_Word ntw = new Number_To_Word();
		System.out.println(ntw.numToWord(sc.nextInt()));
	}
}
