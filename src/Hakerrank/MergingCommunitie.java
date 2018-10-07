package Hakerrank;

import java.util.Scanner;

public class MergingCommunitie {
	int arr[];
	int size[];
	int sol[];
	int n;
	
	public MergingCommunitie(int n) {
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
		if(x == y)
            return;
		if(size[x] < size[y]){
			arr[x] = arr[y];
			size[y] += size[x];
		} else{
			arr[y] = arr[x];
			size[x] += size[y];
		}
	}
	int sol(int n){
		return size[root(n)];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		MergingCommunitie mc = new MergingCommunitie(n);
		sc.nextLine();
		for(int i = 0; i<q; i++){
			String qu[] = sc.nextLine().split("\\s");
			if(qu[0].equals("Q")){
				System.out.println(mc.sol(Integer.parseInt(qu[1])));
			}else{
				mc.union(Integer.parseInt(qu[1]), Integer.parseInt(qu[2]));
			}
			
		}
		
	}

}
