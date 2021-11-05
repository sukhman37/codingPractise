package Array;

import java.util.Deque;
import java.util.LinkedList;

public class findMaxFirstk {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        printFirstMaxK(arr,3);
    }

    public static void printFirstMaxK(int arr[], int k){
        Deque<Integer> queue = new LinkedList<>();

        int i=0;
        for (;i<k;i++){
            while (!queue.isEmpty() && arr[i] > arr[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
        }
        for (;i<arr.length;i++){
            System.out.print (arr[queue.peekFirst()]+" ");
            while (!queue.isEmpty() && queue.peekFirst() < i-k+1)
                queue.removeFirst();
            while (!queue.isEmpty() && arr[i] > arr[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
        }
        if (!queue.isEmpty())
            System.out.print(arr[queue.peekFirst()]+" ");
    }
}
