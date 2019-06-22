package grab;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        System.out.println("Ans : "+solution(999999999, 1000000000));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-time);
    }

    public static int solution(int A, int B) {
        int ans = 0;
        for(int i=2; i*i <= B; i++) {
            int val =  squareOps(i, A, B);
            ans = Math.max(ans, val);
        }
        return ans;
    }

    public static int squareOps(long sqt, int A, int B) {
        int ops = 0;
        while(sqt <= B) {
            sqt = sqt*sqt;
            if(sqt <= B)
                ops++;
        }
        return ops;
    }

}
