package Hakerrank;

import java.util.Scanner;

public class JourneyToMoon {
	int arr[];
	int size[];
	int sol[];
	int n;
	
	public JourneyToMoon(int n) {
		this.n = n;
		arr = new int[n];
		sol = new int[n];
		size = new int[n];
		for(int i =0; i<n; i++){
			arr[i] = i;
			size[i] = 1;
		}
	}
	
	int root(int n){
		
		while(arr[n]!=n){
			arr[n] = arr[arr[n]];
			n = arr[n];
		}
		return n;
	}
	
	void union(int a, int b){
		int x = root(a);
		int y = root(b);
		if(size[x] < size[y]){
			arr[x] = arr[y];
			size[y] += size[x];
		} else{
			arr[y] = arr[x];
			size[x] += size[y];
		}
	}
	int sol(){
		int opt[] = new int[n];
		for(int i =0 ; i<n ; i++){
			sol[root(arr[i])]++;
		}

		opt[n-1] = sol[n-1];
		for( int i=n-2; i>0; i-- ){
			opt[i] = opt[i+1] + sol[i];
		}
			
//		for(int i =0 ; i<n ; i++){
//			System.out.print(opt[i]+" ");
//		}
//		System.out.println();
//		for(int i =0 ; i<n ; i++){
//			System.out.print(sol[i]+" ");
//		}
//		System.out.println();
		int ans=0;
		for(int i =0 ;i <n-1 ;i++){
			ans = ans + sol[i]*opt[i+1];
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		JourneyToMoon jtm = new JourneyToMoon(n);
		for(int i = 0; i<q; i++){
			sc.nextLine();
			int x = sc.nextInt();
			int y = sc.nextInt();
			jtm.union(x, y);
			
		}
		System.out.println(jtm.sol());
	}

}
