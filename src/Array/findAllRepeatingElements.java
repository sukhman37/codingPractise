package Array;

public class findAllRepeatingElements {
	public static void main(String[] args) {
		int input[] = {1,5,3,5,1};
		
		for(int i = 0 ;i < input.length;i++) {
			if(input[Math.abs(input[i])-1] < 0)
				System.out.println("repeating  = "+Math.abs(input[i]));
			else {
				
				input[Math.abs(input[i])-1] = -input[Math.abs(input[i])-1];
			}
		}
	}
}
