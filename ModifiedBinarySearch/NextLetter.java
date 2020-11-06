class NextLetter {

    public static char searchNextLetter(char[] letters, char key) {
        // TODO: Write your code here
        if (letters[0] > key || letters[letters.length-1] < key || letters[letters.length-1] == key)
            return letters[0];
        int start = 0, end = letters.length, mid = 0;
        while (start <= end) {
            mid = (start+end)/2;
            if (letters[mid] > key) end = mid-1;
            else start = mid+1;
        }
        return letters[start];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}