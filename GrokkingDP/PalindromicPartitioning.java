class MPP {

    public int findMPPCuts(String st) {
        boolean[][] isPalindrome = new boolean[st.length()][st.length()];
        for (int i = 0; i < st.length(); i++) isPalindrome[i][i] = true;
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    if (endIndex - startIndex == 1 || isPalindrome[startIndex + 1][endIndex - 1]) {
                        isPalindrome[startIndex][endIndex] = true;
                    }
                }
            }
        }

        int[] cuts = new int[st.length()];
        for (int endIndex = 0; endIndex < st.length(); endIndex++) {
            int minCuts = st.length();
            for (int startIndex = endIndex; startIndex >= 0; startIndex--) {
                if (isPalindrome[startIndex][endIndex]) {
                    minCuts = (startIndex == 0) ? 0 : Math.min(minCuts, 1 + cuts[startIndex-1]);
                }
            }
            cuts[endIndex] = minCuts;
        }

        return cuts[st.length()-1];
    }

    public static void main(String[] args) {
        MPP mpp = new MPP();
        System.out.println(mpp.findMPPCuts("abdbca"));
        System.out.println(mpp.findMPPCuts("cdpdd"));
        System.out.println(mpp.findMPPCuts("pqr"));
        System.out.println(mpp.findMPPCuts("pp"));
        System.out.println(mpp.findMPPCuts("madam"));
    }
}
