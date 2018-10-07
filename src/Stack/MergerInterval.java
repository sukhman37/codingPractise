package Stack;

import java.util.Arrays;
import java.util.Stack;
/*
 * https://www.geeksforgeeks.org/merging-intervals/
 * 
 * Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. Similarly {5, 7} and {6, 8} should be merged and become {5, 8}
 */
class Interval implements Comparable<Interval>{
	int start;
	int end;
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
	public int compareTo(Interval in) {
		if(start > in.start)
			return 1;
		else if(start < in.start)
			return -1;
		else
			return 0;
	}
	@Override
	public String toString() {
		return "{ start:"+start+" end:"+end+" }";
	}
}
public class MergerInterval {

	public static void main(String[] args) {

		Interval In[] = {new Interval(1, 3),new Interval(2, 4),new Interval(5, 7),new Interval(6, 8)};
		Arrays.sort(In);
		Stack<Interval> stack = new Stack<>();
		stack.push(In[0]);
		
		for(int i = 1; i < In.length; i++){
			Interval top = stack.peek();
			
			if(top.end < In[i].start){ //if start is greater from previous interval so it is not overlapping interval
				stack.push(In[i]);
			}else if( top.end < In[i].end){ // else it is overlapping and find out whether current interval end is greater than previous one if yes then update the interval top of the stack
				Interval it = stack.pop();
				it.end = In[i].end;
				stack.push(it);
			}
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.peek());
			stack.pop();
		}
	}
}
