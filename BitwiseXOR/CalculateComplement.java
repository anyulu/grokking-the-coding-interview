import java.lang.Math;

class CalculateComplement {
    public static int bitwiseComplement(int n) {
        // TODO: Write your code here
        if (n == 0) return 1;
        int count = 0, copy = n;
        while (copy > 0) {
            count++;
            copy = copy >> 1;
        }
        double res = Math.pow(2, count)-1;
        return (int)res^n;
    }

    public static void main( String args[] ) {
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(8));
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
    }
}