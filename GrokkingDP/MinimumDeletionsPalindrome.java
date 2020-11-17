class MDSP {

    public int findMinimumDeletions(String st) {
        int[][] dp = new int[st.length()][st.length()];
        for (int i = 0; i < st.length(); i++) dp[i][i] = 1;
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
                } else {
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
            }
        }
        return st.length() - dp[0][st.length() - 1];
    }

    public static void main(String[] args) {
        MDSP mdsp = new MDSP();
        System.out.println(mdsp.findMinimumDeletions("abdbca"));
        System.out.println(mdsp.findMinimumDeletions("cddpd"));
        System.out.println(mdsp.findMinimumDeletions("pqr"));
    }
}
