package Hakerrank;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
class Position{
	char pos;
	int row = -1;
	int col = -1;
	int data = -1;
	public Position() {
		// TODO Auto-generated constructor stub
	}
	public Position(char pos, int row, int col) {
		super();
		this.pos = pos;
		this.row = row;
		this.col = col;
	}
	public int getData() {
		return this.data;
	}
	@Override
	public boolean equals(Object obj) {
		Position pos = (Position)obj;
		if( pos.col == this.col && pos.row == this.row && pos.pos == this.pos )
			return true;
		return false;
	}
}

public class maxArraySum {
	  static int matrixLand(int[][] A,Position dp[][], char pos,int row, int col) {
	       if( dp[row][col].equals(new Position(pos,row,col)) ){
	    	   System.out.println("find ================= >>>>>>>>>><<<<<<<<<<");
	    	   return dp[row][col].getData();
	       }
	       int item = A[row][col];
	       int sum = 0;
	       if(  col < A[0].length -1 ){
	    	   sum = item + matrixLand(A, dp, 'L', row, col+1);
	       } else{
	    	   sum = item;
	       }
	       if( pos != 'A' && row > 0 )
	    	   sum = Math.max( sum , item + matrixLand(A, dp, 'B', row-1, col));
	       if( pos != 'B' && row < A.length -1 )
	    	   sum = Math.max( sum , item + matrixLand(A, dp, 'A', row+1, col));
	       dp[row][col] = new Position(pos,row,col);
	       dp[row][col].data = sum;
	       return sum;
	    }
	  static int matrixLand2(int[][] A,Position dp[][], char pos,int row, int col) {
		  System.out.println("row = "+row+" col  = "+col+"Pos = "+pos);
	       if( dp[row][col].equals(new Position(pos,row,col)) ){
	    	   return dp[row][col].getData();
	       }
	       int item = A[row][col];
	       int sum = 0;
	       if(  row < A.length -1 ){
	    	   sum = item + matrixLand2(A, dp, 'B', row+1, col);
	       } else{
	    	   sum = item;
	       }
	       if( pos != 'R' && col > 0 ){
	    	   
	    	   sum = Math.max( sum , item + matrixLand2(A, dp, 'L', row, col-1));
	       }
	       if( pos != 'L' && col < A[0].length -1 ){
	    	   sum = Math.max( sum , item + matrixLand2(A, dp, 'R', row, col+1));
	       }
//	       if( pos!='R' && col > 0 ){
//	    	   sum = Math.max(sum, matrixLand2(A, dp, 'L', row, col-1));
//	       }
	       dp[row][col] = new Position(pos,row,col);
	       dp[row][col].data = sum;
	       System.out.println("data = "+dp[row][col].data+" pos = "+dp[row][col].pos+" Row = "+row+" Col = "+col);
	       return sum;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        int[][] A = new int[n][m];
	        Position[][] dp = new Position[n][m];
	        for(int A_i = 0; A_i < n; A_i++){
	            for(int A_j = 0; A_j < m; A_j++){
	                A[A_i][A_j] = in.nextInt();
	                dp[A_i][A_j] = new Position();
	            }
	        }
	        ArrayList<Integer> al = new ArrayList<>();
	        for( int i = 0;i< n ;i++){
	        	
	        	al.add(matrixLand2(A, dp, 'B', i, 0));
	        	//System.out.println(matrixLand(A, dp, 'L', i, 0));
	        }
	        //int result = matrixLand(A);
	        Collections.sort(al,Collections.reverseOrder());
	        System.out.println(al.get(0));
	        in.close();

}
}
