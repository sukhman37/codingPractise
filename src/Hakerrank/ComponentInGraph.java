package Hakerrank;

import java.util.Scanner;

public class ComponentInGraph {
	int arr[];
	int size[];
	int sol[];
	int n;
	
	public ComponentInGraph(int n) {
		this.n = n;
		arr = new int[n];
		sol = new int[n];
		size = new int[n];
		for(int i =1; i<n; i++){
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
	void sol(){
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i =1 ; i < n;i++){
			int x = size[root(i)];
			if(x==1)
				continue;
			if(x > max)
				max = x;
			if(x<min)
				min = x;
		}
		System.out.println(min+" "+max);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ComponentInGraph cg = new ComponentInGraph(2*n+1);
		sc.nextLine();
		for(int i = 0; i<n; i++){
			cg.union(sc.nextInt(),sc.nextInt());
			}
			cg.sol();
		}
		
	}


