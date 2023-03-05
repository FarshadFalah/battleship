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
        if (bord[x][y] == 3) return false;
        bord[x][y] = 3;
        return true;
    }

    public void shot(int x, int y) throws OutOfBoard {
        if (x < 1 || y < 1 || x > bord.length || y > bord.length) throw new OutOfBoard();
        bord[x][y] = bord[x][y] == 3 ? 5 : 7;
    }

    public void automaticPlaceShips() {
        Random random = new Random();
        int shipCount = (int) Math.ceil(size / 2);
        for (int i = 0; i < shipCount; i++) {
            for (int j = shipCount - i; j > 0; j--) {
                int x = random.nextInt(size);
                int y = random.nextInt(size);
                for (int k = 0; k <= i; k++) {
                    try {
                        if (random.nextInt(2) == 1) {
                            while (!placeShip(x + k, y)) ;
                        } else {
                            while (!placeShip(x, y + k)) ;
                        }
                    } catch (OutOfBoard e) {
                        //THIS CAN NEVER HAPPEN HERE

                    }
                }

            }
        }
    }
}