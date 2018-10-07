package String;
/*package whatever //do not write package name here */

import java.util.*;


class Node{
	int index;
	int count;
	 Node(int index,int count){
		this.index = index;
		this.count = count;
	}
	public int getCount() {
		return count;
	}
	public int getIndex() {
		return index;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Node increseCount(){
		count++;
		return this;
	}
}
class GFG {
	
	
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    sc.nextLine();
	    while(t-- > 0){
	        HashMap<Character,Node> map = new HashMap<>();
	        String s = sc.nextLine();
	        for(int i = 0; i < s.length();i++){
	            if(map.containsKey(s.charAt(i))){
	                map.put(s.charAt(i),map.get(s.charAt(i)).increseCount());
	            }else{
	                map.put(s.charAt(i),new Node(i,1));
	            }
	        }
	        char x = 'a';
	        int index = Integer.MAX_VALUE;
	        for(int i = 0 ; i < 256 ; i++){
	            if(map.containsKey(x) && index > map.get(x).getIndex() && map.get(x).count > 1){
	                index = map.get(x).getIndex();
	            }
	        x++;
	      //  System.out.print(" char = "+x);
	        }
	        if(index == Integer.MAX_VALUE)
	             System.out.println("-1");
	         else
	             System.out.println(s.charAt(index));
	    }
	    
	}
}