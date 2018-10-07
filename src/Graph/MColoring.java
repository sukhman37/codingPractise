package Graph;

import java.util.ArrayList;
import java.util.Scanner;


class NodeGraph {
    int to;
    public NodeGraph(int to) {
	 this.to = to;
	}
}

class GraphMcolor {
		
	ArrayList<ArrayList<NodeGraph>> list = new ArrayList<ArrayList<NodeGraph>>();
	int node;
    public GraphMcolor(int node) {
        this.node = node;
        for(int i = 0 ; i< node ;i++){
        	list.add(new ArrayList<NodeGraph>());
        }
    }
    
    public void addEgdes(int from, int to){
        list.get(from).add(new NodeGraph(to));
        list.get(to).add(new NodeGraph(from));
    }
    
    public void graphColoring(int numberOfColor) {
    	int color[] = new int[node];
    	if(!GraphUtil(color, numberOfColor, 0))
    		return;
    	for(int i = 0 ;i < node ;i++) {
    		System.out.println("vertex = "+i+" color = "+color[i]);
    	}
    }
    
    public boolean GraphUtil(int color[],int numberOfColor, int v) {
    	if(v==node)
    		return true;
    	for(int c = 1; c <= numberOfColor; c++) {
    		if(isSafe(v, c, color)) {
    			color[v] = c;
    			if(GraphUtil(color, numberOfColor, v+1))
    				return true;
    			color[v] = 0;
    		}
    	}
    	return false;
    }
    
    public boolean isSafe(int v, int c, int color[]) {
    	for(int i =0 ; i< list.get(v).size(); i++) {
    		if(color[list.get(v).get(i).to] == c)
    			return false;
    	}
    	return true;
    }
    
    
}

public class MColoring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		GraphMcolor gmc = new GraphMcolor(n);
		int edge = sc.nextInt();
		for(int i =0; i < edge; i++) {
			gmc.addEgdes(sc.nextInt(), sc.nextInt());
		}
		
		gmc.graphColoring(3);
		sc.close();
	}
}
