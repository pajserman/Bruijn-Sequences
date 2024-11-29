
public class LFSR {
    private int L;
    private int[] CD;
    private int modulus;
    private int[] buffer;
    private int[] case1;
    private int[] ZERO = { 0, 0, 0, 0 };

    public LFSR(int L, int[] CD, int modulus, int[] case1) {
        this.L = L;
        this.CD = CD;
        this.modulus = modulus;
        this.buffer = new int[L];
        this.buffer[buffer.length - 1] = 1;
        this.case1 = case1;
    }

    int getNext() {
        // check special cases
        if (areArraysEqual(buffer, case1)) {
            // System.out.print("oops here!");
            // System.exit(0);
            buffer[0] = 0;
            return case1[0];
        }
        if (areArraysEqual(buffer, ZERO)) {
            buffer[buffer.length - 1] = 1;
            return 0;
        }
        // calc new value
        int sum = 0;
        for (int i = 0; i < buffer.length; i++) {
            if (CD[i] != 0) {
                sum += -1 * CD[i] * buffer[i];
            }
        }
        int newValue = (sum + 100) % modulus;
        int oldValue = buffer[0];
        // shift left return leftmost
        for (int i = 0; i < buffer.length - 1; i++) {
            buffer[i] = buffer[i + 1];
        }
        buffer[buffer.length - 1] = newValue;

        return oldValue;
    }

    public void print() {

        // print debug
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(buffer[i]);
        }
        System.out.println();
    }

    public static boolean areArraysEqual(int[] array1, int[] array2) {
        // Check if the lengths are different
        if (array1.length != array2.length) {
            return false;
        }

        // Check if each element is the same
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        // If no differences were found, the arrays are equal
        return true;
    }

}
