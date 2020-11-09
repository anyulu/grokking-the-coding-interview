import java.util.*;

class RearrangeString {

    public static String rearrangeString(String str) {
        // TODO: Write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (char c: str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        StringBuilder res = new StringBuilder();
        queue.addAll(map.entrySet());
        Map.Entry<Character, Integer> prev = null;
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> curr = queue.poll();
            if (prev != null && prev.getValue() > 0) queue.add(prev);
            res.append(curr.getKey());
            curr.setValue(curr.getValue()-1);
            prev = curr;
        }
        if (res.length() != str.length()) return "";
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}
