public class App {
    public static void main(String[] args) throws Exception {
        int[] cd2 = { 1, 0, 0, 1, 1 };
        int[] case21 = { 1, 0, 0, 0 };
        LFSR lfsr2 = new LFSR(4, cd2, 2, case21);

        // for (int i = 0; i < 16; i++) {
        // System.out.print(i + ": ");
        // lfsr2.print();
        // lfsr2.getNext();
        // }

        int[] cd5 = { 2, 2, 2, 2, 1 };
        int[] case51 = { 2, 0, 0, 0 };
        LFSR lfsr5 = new LFSR(4, cd5, 5, case51);

        // for (int i = 0; i < 625; i++) {
        // System.out.print(i + ": ");
        // lfsr5.print();
        // lfsr5.getNext();
        // }

        for (int i = 0; i < 10003; i++) {
            NumberStorage.store(mapFunction(lfsr2.getNext(), lfsr5.getNext()));
        }
    }

    private static int mapFunction(int i, int j) {
        int[][] arr = {
                { 0, 1, 2, 3, 4 },
                { 5, 6, 7, 8, 9 }
        };
        return arr[i][j];
        // return 5 * i + j;
    }
}
