package ir.farshad;

public class Main {
    public static void main(String[] args) {

        int[][] a = new int[10][10];

        int[] b = a[5];
        for (int i = 0; i < 10; i++) {
            b[i]=i;
        }

        a[5] =b;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(a[i][j]);

            }
            System.out.println();
        }


    }
}
