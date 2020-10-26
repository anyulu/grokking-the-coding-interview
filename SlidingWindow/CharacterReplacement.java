class CharacterReplacement {
    public static int findLength(String str, int k) {
        // TODO: Write your code here
        if (str.length() <= k) return str.length();
        int start = 0;
        int max = Integer.MIN_VALUE;
        int repeat = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char currChar = str.charAt(end);
            map.put(currChar, map.getOrDefault(currChar, 0)+1);
            repeat = Math.max(repeat, map.get(currChar));
            while (end-start+1 > repeat+k) {
                map.put(str.charAt(start), map.get(str.charAt(start))-1);
                start++;
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}
