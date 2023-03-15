package ir.farshad.model;


import ir.farshad.utility.customexceptions.OutOfBoard;
import ir.farshad.utility.customexceptions.ShiponShip;

import java.util.Random;

public class Bord {
    /*
    0 = Ocean
    3 = Ship
    5 = Hit
    7 = Miss
     */

    private final int[][] bord;
    int size;

    public Bord(int size) {
        this.size = size;
        bord = new int[size][size];
    }

    public boolean placeShip(int x, int y) throws OutOfBoard {
        if (x < 1 || y < 1 || x > bord.length || y > bord.length) throw new OutOfBoard();
        if (bord[x][y] == 3) try {
            throw new ShiponShip();
        } catch (ShiponShip e) {
            throw new RuntimeException(e);
        }
        bord[x][y] = 3;
        return true;
    }

    public void shot(int x, int y) throws OutOfBoard {
        if (x < 1 || y < 1 || x > bord.length || y > bord.length) throw new OutOfBoard();
        bord[x][y] = bord[x][y] == 3 ? 5 : 7;
    }

    public void automaticPlaceShips() {
        Random random = new Random();
        int shipCount = (int) Math.ceil((double) size / 2);
        for (int i = 0; i < shipCount; i++) {
            int x = random.nextInt(size - 1 - (shipCount - i));
            int y = random.nextInt(size);
            int[] temp = new int[size];
            if (random.nextInt(10) % 2 == 0) {
                temp = bord[y];
                for (int j = shipCount - i; j > 0; j--) {
                    temp[x+j] = 3;
                }
            } else {
                temp = getColumn(y);
                for (int j = shipCount - i; j > 0; j--) {
                    temp[x+j] = 3;
                }
            }
        }
    }

    public int[] getColumn(int index) {
        int[] column = new int[size]; // Here I assume a rectangular 2D array!
        for (int i = 0; i < column.length; i++) {
            column[i] = bord[i][index];
        }
        return column;
    }
}