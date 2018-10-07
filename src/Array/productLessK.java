package Array;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class productLessK {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String[] line1 = br.readLine().trim().split(" ");
			int n = Integer.parseInt(line1[0]);
			long k = Long.parseLong(line1[1]);
			String[] line = br.readLine().trim().split(" ");
			int arr[] = new int[line.length];
			for(int i = 0;i < line.length ; i++){
				arr[i] = Integer.parseInt(line[i]);
			}

			long product = 1;
			long ways = 0;
			for (int start = 0, end = 0; end < line.length; end++) {

				product = product * arr[end];


				while(start < end && product >= k){
					product = product / arr[start];
					start++;
				}  
				if(product < k){

					ways = ways + 1 + (end - start);
				}

			}
			System.out.println(ways);
		}
	}
}