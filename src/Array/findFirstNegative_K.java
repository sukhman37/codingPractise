package Array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class findFirstNegative_K {
    public static void main(String[] args) {
        int arr[] = {-8, 2, 3, -6, 10};
        printFirstKNegative(arr,2);
    }

    public static void printFirstKNegative(int arr[], int k){

        Deque<Integer> queue = new LinkedList<>();
        int i=0;
        for(i=0;i<k;i++){
            if (arr[i]<0)
            queue.addLast(i);
        }
        for (;i<arr.length;i++){
                if (!queue.isEmpty())
                    System.out.print(arr[queue.peekFirst()] + " ");
                else
                    System.out.print("0 ");
                while (!queue.isEmpty() && queue.peekFirst() < (i - k + 1))
                    queue.removeFirst();
                if (arr[i] < 0)
                    queue.addFirst(i);


        }
        if (!queue.isEmpty())
            System.out.print(arr[queue.peekFirst()]);
        else
            System.out.println("0");
    }
}
