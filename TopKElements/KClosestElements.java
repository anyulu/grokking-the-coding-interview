import java.util.*;
import java.util.stream.Collectors;

class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        List<Integer> result = new ArrayList<>();
        // TODO: Write your code here
        if (arr.length <= K) return Arrays.stream(arr).boxed().collect(Collectors.toList());
        Queue<Integer> queue = new PriorityQueue<>((a,b)-> Math.abs(b-X)-Math.abs(a-X));
        for (int i = 0; i < K; i++) {
            queue.add(arr[i]);
        }
        for (int i = K; i < arr.length; i++) {
            if (Math.abs(arr[i]-X) < Math.abs(queue.peek()-X)) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        Queue<Integer> order = new PriorityQueue<>();
        while (!queue.isEmpty()) order.add(queue.poll());
        while (!order.isEmpty()) result.add(order.poll());
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}
