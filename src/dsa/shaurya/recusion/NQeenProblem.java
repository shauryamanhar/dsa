package dsa.shaurya.recusion;

public class NQeenProblem {
    public static void main(String[] args) {
        int n = 4;
        boolean board[][] = new boolean[n][n];
        boolean colVis[] = new boolean[n];
        boolean diagonalVis[] = new boolean[2 * n - 1];
        boolean reverseDiagonalVis[] = new boolean[2 * n - 1];
        nqeen(board, 0, colVis, diagonalVis, reverseDiagonalVis);
    }

    static void nqeen(boolean b[][], int row, boolean colVis[], boolean dia[], boolean rdia[]) {
        if (row == b.length) {
            System.out.println("solutions");
            print(b);
            System.out.println("============");
            return;
        }
        for (int col = 0; col < b[0].length; col++) {
            if (colVis[col] == false && dia[row + col] == false && rdia[row - col + b.length - 1] == false) {
                b[row][col] = true;
                colVis[col] = true;
                dia[row + col] = true;
                rdia[row - col + b.length - 1] = true;

                nqeen(b, row + 1, colVis, dia, rdia);

                colVis[col] = false;
                dia[row + col] = false;
                rdia[row - col + b.length - 1] = false;
                b[row][col] = false;
            }
        }
    }

    static void print(boolean b[][]) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
