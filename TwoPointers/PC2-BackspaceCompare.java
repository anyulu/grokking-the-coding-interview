class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
        // TODO: Write your code here
        int i = str1.length()-1;
        int j = str2.length()-1;
        int skip1 = 0;
        int skip2 = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (str1.charAt(i) == '#' || skip1 > 0)) {
                if (str1.charAt(i) == '#') {
                    i--;
                    skip1++;
                } else {
                    i--;
                    skip1--;
                }
            }
            while (j >= 0 && (str2.charAt(j) == '#' || skip2 > 0)) {
                if (str2.charAt(j) == '#') {
                    j--;
                    skip2++;
                } else {
                    j--;
                    skip2--;
                }
            }

            if (i < 0 && j < 0) return true;
            if (i < 0 || j <0) return false;
            if (str1.charAt(i) != str2.charAt(j)) return false;
            i--;
            j--;
        }
        return true;
    }
}

