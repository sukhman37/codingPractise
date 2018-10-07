package testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class A {
	int a = 10;
	void print() {
		System.out.println("A");	
	}
}
class B extends A {
	int a = 20;
	void p() {
		System.out.println("B");
	}
}

class Result implements Comparable<Result>{
	public Result() {
		// TODO Auto-generated constructor stub
	}
	String uniqueId;
	String name;
	int marks;
	public String getName() {
		return name;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int compareTo(Result o) {
		int compare = o.getMarks();
		return this.marks - compare;
	}
}
public class Temp {
	
	public static void main(String []args) {
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		Stack st = new Stack<Integer>();
//		sc.nextLine();
//		for( int i =0 ;i <t; i++){
//			int n = sc.nextInt();
//			sc.nextLine();
//			if(n%2 == 1){
//				if(st.isEmpty())
//					st.push(sc.nextInt());
//			}
//				
//		}
		 
		//String line1 = "ENG - 4 - 63 HIN - 3 - 75 HCG - 5 - 57 CC MAT - 6 - 47 SCI - 6 - 45 DDD CAS - 5 - 60 SUPW:C PCA";
	    //  String pattern = "[A-Z]*[ -]*(\\d*)[ -]*(\\d*)[ ]";

	      // Create a Pattern object
	      //Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
//	      Matcher m = r.matcher(line1);
//	      while (m.find( )) {
//	         System.out.println("Found value: " + m.group(0) );
//	         System.out.println("Found value: " + m.group(1) );
//	         System.out.println("Found value: " + m.group(2) );
//	      }
	      
		
//	     
		int count =0 ;
		ArrayList<Result> result = new ArrayList<Result>();
		 Scanner scan = new Scanner(System.in);
		// System.out.println(scan);
		   while(scan.hasNext()){
			   Result rl =  new Result();
			   String check = scan.nextLine();
			   while(!check.contains("SRL"))
				   check = scan.nextLine();
		       String pattern1 = "(\\d*)[ ]*([A-Za-z ]*)";
			   Pattern r1 = Pattern.compile(pattern1);
			   Matcher m1 = r1.matcher(check);
			   m1.find();
			   System.out.println("name = "+m1.group(2));
			   System.out.println("unique Id = "+m1.group(1));
			   rl.setName(m1.group(2));
		       rl.setUniqueId(m1.group(1));
		       String line1 = scan.nextLine();
		       while(!line1.contains("ENG"))
		        line1 = scan.nextLine();
			   String pattern = "[A-Z]*[ -]*(\\d*)[ -]*(\\d*)[ ]";
			   Pattern r = Pattern.compile(pattern);
			   Matcher m = r.matcher(line1);
			   int marks = 0;
			   ArrayList<Integer> al = new ArrayList<Integer>();
			      while (m.find( )) {
		
			    	  if(m.group(0).contains("ENG")){
			    	      if(m.group(2).matches("[0-9]*")){
			    	    if(Integer.parseInt(m.group(2).trim())>35)
			    		  marks = marks + Integer.parseInt(m.group(2).trim());
			    	      }
			    	  }else{
			    		  if(m.group(2) != null && m.group(2).length()!=0){
			    		      if(m.group(2).matches("[0-9]*")){
			    		          if(Integer.parseInt(m.group(2).trim())>35)
			    			  al.add(Integer.parseInt(m.group(2).trim()));
			    		      }
			    		  }
			    	  }
			      }
			      Collections.sort(al,Collections.reverseOrder());
			      for(int i=0;i<al.size();i++){
			      if(i==4)
			         break;
			    	  marks = marks+al.get(i);
			      }
			    	rl.setMarks(marks);
			    	result.add(rl);
			    	count++;
			    	if(count == 2)
			    		break;
			    	
		   }
		   Collections.sort(result,Collections.reverseOrder());
		   for(int i = 0;i<10;i++)
		   {
			   Result rs = result.get(i);
			   System.out.println(rs.getUniqueId()+","+rs.getName()+","+(i+1));
		   }
	}
}
