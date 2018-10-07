package LinkedList;

import java.util.Scanner;

class ListIntersection extends List {
	
}

public class IntersectionList {
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i;
		ListIntersection list = new ListIntersection();
		
		while(true) {
			i = input.nextInt();
			
			switch(i) {
				case 1 :  {
					list.insertFirst(input.nextInt());
					break;
				}
				case 2 : {
					list.display();
					break;
				}
			}
		}
	}
}
