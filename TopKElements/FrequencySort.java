import java.util.*;

class FrequencySort {

    public static String sortCharacterByFrequency(String str) {
        // TODO: Write your code here
        Map<Character, Integer> map = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        for (char c: str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            queue.add(entry);
        }
        String res = "";
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            int size = entry.getValue();
            while (size > 0) {
                size --;
                res += entry.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
