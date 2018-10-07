package Hakerrank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RoadsAndLibraries {
	 
		 int node;
		 ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		 int disConnectedComp[];
		 
		 public RoadsAndLibraries(int node) {
			this.node = node;
			disConnectedComp = new int[node+1];
			for(int i = 0; i <= node; i ++)
				list.add(new ArrayList<Integer>());
		}
		 void addEdge(int from,int to){
			 list.get(from).add(to);
			 list.get(to).add(from);
		 }
		 
		 public void DFSearchUtil(int vertex, boolean visited[], int index ){
				visited[vertex] = true;
				disConnectedComp[index] = disConnectedComp[index] +1; 
				
				Iterator<Integer> iter = list.get(vertex).iterator();
				while(iter.hasNext()) {
					int data = iter.next();
					if(visited[data] == false){
						DFSearchUtil(data, visited, index);
					}
				}
				
			}
		
	public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            int n = in.nextInt();
	            RoadsAndLibraries rl = new RoadsAndLibraries(n);
	            int m = in.nextInt();
	            long x = in.nextLong();
	            long y = in.nextLong();
	            
	            if( m == 0 ){
	            	System.out.println(n*x);
	            	continue;
	            }
	            
	            for(int a1 = 0; a1 < m; a1++){
	                int city_1 = in.nextInt();
	                int city_2 = in.nextInt();
	                rl.addEdge(city_1, city_2);
	            }
	            boolean visited[] = new boolean[n+1];
	            int count = 1 ;
	            for(int i = 1; i<=n; i++){
	            	if(visited[i] == false){
	            		rl.DFSearchUtil(i, visited, count);
	            		count++;
	            	}
	            }
	            
	            long ans = 0;
	            for(int i =1 ; i<n; i++){
	            	if(rl.disConnectedComp[i] == 0)
	            		break;
	            	if( x < y )
	            		ans = ans + (x*rl.disConnectedComp[i]);
	            	else
	            		ans = ans + x + ( y * (rl.disConnectedComp[i]-1));
	            }
	            System.out.println(ans);
	            
	        }
	}

}
