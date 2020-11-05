import java.util.*;

class GenerateParentheses {

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();
        // TODO: Write your code here
        dfs(result, new String(), 0, 0, num);
        return result;
    }

    private static void dfs(List<String> result, String s, int left, int right, int num) {
        if (left == num) {
            while (right++ < num) s += ")";
            result.add(s);
            return;
        }
        String s1 = s+"(";
        String s2 = s+")";
        if (left == right) dfs(result, s1, left+1, right, num);
        else {
            dfs(result, s1, left+1, right, num);
            dfs(result, s2, left, right+1, num);
        }
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
