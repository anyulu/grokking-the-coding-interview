import java.util.*;

class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        // TODO: Write your code here
        dfs(permutations, str, new String(), 0);
        return permutations;
    }

    private static void dfs(List<String> permutations, String str, String s, int index) {
        if (s.length() == str.length()) {
            permutations.add(s);
            return;
        }
        char c = str.charAt(index);
        if (!Character.isLetter(c)) {
            s += c;
            dfs(permutations, str, s, index+1);
        } else {
            String s1 = s + Character.toUpperCase(c);
            String s2 = s + Character.toLowerCase(c);
            dfs(permutations, str, s1, index+1);
            dfs(permutations, str, s2, index+1);
        }
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
