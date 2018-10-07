package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimsAlgo {
	
	class Node {
		
	    int to;
	    int weight;
	    
	    public Node(int to,int weight) {
		 this.to = to;
		 this.weight = weight;
		}
	    
	}
	
	ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
	int node;
	
	public PrimsAlgo( int node ) {
		this.node = node;
		for( int i = 0; i < node; i++ ){
			list.add(new ArrayList<Node>());
		}
	}
	
	 public void addEgdes(int from, int to, int weight) {
	        list.get(from).add(new Node(to, weight));
	        list.get(to).add(new Node(from, weight));
	    }
	 
	 public int minDistance(int dist[] , boolean visited[]) {
	        int min = Integer.MAX_VALUE;
	        int min_index = -1;
	        for(int i=0; i<node; i++) {
	            if(visited[i] == false && dist[i]<min){
	                min = dist[i];
	                min_index = i;
	            }
	        }
	        return min_index;
	    }
	 
	 
	 public void Prims() {
	    	
	        boolean mstSet[] = new boolean[node];
	        int key[] = new int[node];
	        int parent[] = new int[node];
	        
	        
	        for(int i = 0 ; i<node ; i++) {
	            key[i] = Integer.MAX_VALUE;
	        }
	       
	        key[0] = 0;
	        
	        parent[0] = -1;
	        
	        
	        for(int count=0 ; count<node-1 ; count++) {
	            int u = minDistance(key,mstSet);
	            System.out.println(u);
	            mstSet[u] = true;
	            
	            for(int i =0; i<list.get(u).size(); i++) {
	            	
	                int weight = list.get(u).get(i).weight;
	                int to = list.get(u).get(i).to;
	                
	                if( key[u] != Integer.MAX_VALUE && mstSet[to] == false && weight < key[to] ) {
	                	key[to] = weight;
	                	parent[to] = u;
	                }
	                
	            }
	        }
	        
	        for(int i = 0 ;i < node; i++) {
	        	System.out.println("distance src = "+parent[i]+" node = "+i+" = "+key[i]);
	        }
	        
	    }
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 PrimsAlgo pa = new PrimsAlgo(n);
		 int edge = sc.nextInt();
			for(int i =0; i < edge; i++) {
				pa.addEgdes(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			pa.Prims();
			sc.close();
	}

}
