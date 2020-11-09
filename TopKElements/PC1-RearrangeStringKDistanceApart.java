import java.util.*;

class RearrangeStringKDistanceApart {

    public static String reorganizeString(String str, int k) {
        // TODO: Write your code here
        if (k == 0) return str;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        queue.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> kQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> curr = queue.poll();
            res.append(curr.getKey());
            curr.setValue(curr.getValue()-1);
            kQueue.add(curr);
            if (kQueue.size() == k) {
                Map.Entry<Character, Integer> temp = kQueue.poll();
                if (temp.getValue() > 0) queue.add(temp);
            }
        }
        if (res.length() != str.length()) return "";
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}
