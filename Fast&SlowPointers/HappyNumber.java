class HappyNumber {

    public static boolean find(int num) {
        // // TODO: Write your code here
        int fast = num, slow = num;
        do {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        } while (fast != slow);
        return fast == 1;
    }

    private static int getNext(int num) {
        int sum = 0;
        int i;
        while (num > 0) {
            i = num % 10;
            sum += i*i;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}