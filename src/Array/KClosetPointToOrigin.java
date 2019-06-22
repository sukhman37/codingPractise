package Array;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class KClosetPointToOrigin {
	public static void main(String[] args) {
		int arr[][] = {{3,3},{5,-1},{-2,4}};
		int ans[][] = kClosest(arr,3);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i][0]+" "+ans[i][1]);
		}
	}
	
	public static int[][] kClosest(int[][] points, int K) {
        Map<Double,ArrayList<Point>> al = new TreeMap<>();
        for(int i =0 ; i < points.length;i++) {
        	Double dis = Math.sqrt(Math.pow(points[i][0], 2)+Math.pow(points[i][1], 2));
        	if(!al.containsKey(dis)) {
        		ArrayList<Point> p = new ArrayList<>();
        		p.add(new Point(points[i][0], points[i][1]));
        		al.put(dis, p);
        	}else {
        		ArrayList<Point> point = al.get(dis);
        		point.add(new Point(points[i][0], points[i][1]));
        	}
        }
        int ans[][] = new int[K][2];
        for(int i =0;i<K;) {
        	for(Entry<Double,ArrayList<Point>> p: al.entrySet()) {
        		for(Point point : p.getValue()) {
        			if(i<K) {
        			ans[i][0] = point.x;
        			ans[i][1] = point.y;
        			i++;
        			}else {
        				break;
        			}
        		}
        	}
        }
        return ans;
    }

}
class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
