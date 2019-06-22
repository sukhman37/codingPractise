package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RottonOrange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
		int row = sc.nextInt();
		int col = sc.nextInt();
		int arr[][] = new int[row][col];
		List<Store> list = new ArrayList<>();
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 2)
					list.add(new Store(i,j,0));
			}
		}
		
		boolean visited[][] = new boolean[row][col];
		Queue<Store> queue = new LinkedList<>();
		for(Store s : list) {
			queue.add(s);
			visited[s.x][s.y] = true;
		}
		int max =Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			Store s = queue.poll();
			if(s.count > max)
				max = s.count;
			if(isSafe(row, col, s.x+1, s.y) && arr[s.x+1][s.y]==1 &&  visited[s.x+1][s.y] == false) {
				queue.add(new Store(s.x+1, s.y, s.count+1));
				visited[s.x+1][s.y] = true;
				//System.out.println("visited = "+(s.x+1)+" j = "+s.y);
			}
			 if(isSafe(row, col, s.x-1, s.y) && arr[s.x-1][s.y]==1 && visited[s.x-1][s.y] == false) {
				queue.add(new Store(s.x-1, s.y, s.count+1));
				visited[s.x-1][s.y] = true;
				//System.out.println("visited = "+(s.x-1)+" j = "+s.y);
			}
			 if(isSafe(row, col, s.x, s.y+1) && arr[s.x][s.y+1]==1 && visited[s.x][s.y+1] == false ) {
				queue.add(new Store(s.x, s.y+1, s.count+1));
				visited[s.x][s.y+1] = true;
				//System.out.println("visited = "+s.x+" j = "+(s.y+1));
			}
			 if(isSafe(row, col, s.x, s.y-1) && arr[s.x][s.y-1]==1 && visited[s.x][s.y-1] == false) {
				queue.add(new Store(s.x, s.y-1, s.count+1));
				visited[s.x][s.y-1] = true;
				//System.out.println("visited = "+s.x+" j = "+(s.y-1));
			}
		}
		
		boolean flag = false;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(arr[i][j] == 1 && visited[i][j] == false) {
					System.out.println("i = "+i+" j = "+j);
					System.out.println("-1");
					flag = true;
					break;
				}
			}
		}
		if(flag == false)
			System.out.println(max);
		}
		
	}
	public static boolean isSafe(int row, int col,int i,int j) {
		if(i>=0 && j>=0 && i<row && j<col)
			return true;
		return false;
	}
}
class Store{
	int x;
	int y;
	int count;
	Store(int x,int y,int count) {
		this.x = x;
		this.y = y;
		this.count =count;
	}
}
