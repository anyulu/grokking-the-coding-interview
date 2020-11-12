import java.util.*;

class AlienDictionary {
    public static String findOrder(String[] words) {
        // TODO: Write your code here
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, List<Character>> orderMap = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        for (String s: words) {
            for (char c: s.toCharArray()) {
                map.put(c, 0);
                orderMap.put(c, new ArrayList<Character>());
            }
        }
        for (int i = 0; i < words.length-1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    map.put(s2.charAt(j), map.get(s2.charAt(j))+1);
                    orderMap.get(s1.charAt(j)).add(s2.charAt(j));
                    break;
                }
                if (j == s2.length()-1 && s1.length() > s2.length()) return "";
            }
        }
        for (char c: map.keySet()) {
            if (map.get(c) == 0) queue.add(c);
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            res.append(c);
            for (char leaf: orderMap.get(c)) {
                map.put(leaf, map.get(leaf)-1);
                if (map.get(leaf) == 0) queue.add(leaf);
            }
        }
        if (map.size() != res.length()) return "";
        return res.toString();
    }

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }
}