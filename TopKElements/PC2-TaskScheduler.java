import java.util.*;

class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {
        // TODO: Write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (char task: tasks) {
            map.put(task, map.getOrDefault(task, 0)+1);
        }
        int count = 0;
        int res = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> buffer = new LinkedList<>();
        queue.addAll(map.values());
        while (count != map.size()) {
            if (queue.isEmpty()) queue.add(Integer.MAX_VALUE);
            int temp = queue.poll();
            temp--;
            if (temp == 0) count++;
            buffer.add(temp);
            res++;
            if (buffer.size() == k+1) queue.add(buffer.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }
}
