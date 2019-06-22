package grab;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {

        int [] ranks = {3,4,3,0,2,2,3,0,0};
        System.out.println("Ans : "+solution(ranks));
        int ranks2[] = {3,4,3,0,2,2,3,0,0};
        System.out.println("Ans : "+solution(ranks2));
    }
    public static int solution(int [] ranks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer r : ranks) {
            map.put(r, map.getOrDefault(r, 0)+1);
        }
        int ans = 0;
        for(Integer r : map.keySet()) {
            if(map.containsKey(r+1)) {
                ans += map.get(r);
            }
        }
        return ans;
    }
}
