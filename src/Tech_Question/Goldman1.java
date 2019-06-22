package Tech_Question;

import java.util.*;

public class Goldman1 {
	
	static long gcd(long x, long y) {
		return (y==0) ? x : gcd(y,x%y);
	}
	
	static String asFraction(int num, int dem) throws NumberNotEqualToNull {
		if(dem == 0)
			throw new NumberNotEqualToNull("Denominator Number not equal to zero",dem);
		if(num == 0)
			return "0/0";
		long gcd = gcd(num,dem);
		return num/gcd+"/"+dem/gcd;
	}
	
	public static void main(String ...arg) {
		//Scanner sc = new Scanner(System.in);
		//int num =  sc.nextInt();
		//int dem = sc.nextInt();
		
		try {
			System.out.println(asFraction(0, 0));
		} catch (NumberNotEqualToNull e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
class NumberNotEqualToNull extends Exception{
	
	int number;
	private static final long serialVersionUID = 1L;

	NumberNotEqualToNull(String errorMsg,int number){
		super(errorMsg);
		this.number = number;
	}
	public String getMessage(){
		return super.getMessage()+" = "+number;
	}
}
