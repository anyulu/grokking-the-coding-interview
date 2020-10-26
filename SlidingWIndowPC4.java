import java.util.*;

class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        List<Integer> finalRes = new ArrayList<Integer>();
        // TODO: Write your code here
        if (str.length() < words.length*words[0].length()) return resultIndices;
        int start = 0;
        int n = words.length;
        int len = words[0].length();
        int count1 = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                char c = words[i].charAt(j);
                map1.put(c, map1.getOrDefault(c, 0)+1);
            }
        }

        for (int end = 0; end < str.length(); end++) {
            char currChar = str.charAt(end);
            if (map1.containsKey(currChar)) {
                map1.put(currChar, map1.get(currChar)-1);
                if (map1.get(currChar) == 0) count1++;
            }
            if (end >= n*len-1) {
                if (count1 == map1.size()) resultIndices.add(start);
                char prevChar = str.charAt(start);
                if (map1.containsKey(prevChar)) {
                    if (map1.get(prevChar) == 0) count1--;
                    map1.put(prevChar, map1.get(prevChar)+1);
                }
                start++;
            }
        }

        for (Integer i: resultIndices) {
            boolean exist = true;
            int index = i;
            int count2 = 0;
            List<String> list = new ArrayList<>(Arrays.asList(words));
            while (count2 < n) {
                count2++;
                String temp = str.substring(index,index+len);
                if (list.contains(temp)) {
                    list.remove(list.indexOf(temp));
                    index += len;
                }
                else {
                    exist = false;
                    break;
                }
            }
            if (exist) finalRes.add(i);
        }

        return finalRes;
    }
}
