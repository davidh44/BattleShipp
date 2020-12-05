package academy.learnprogramming;

import java.util.ArrayList;

public class Ship {

    public int[] coord;

    public void setCoord(int[] coord){
        this.coord = coord;
    }

    public boolean isSunk(Field field) {

        String[][] grid = field.getGrid();

        int ay = coord[0];
        int ax = coord[1];
        int by = coord[2];
        int bx = coord[3];

        for (int y = ay; y<=by; y++) {
            for (int x = ax; x<=bx; x++) {
                if (!grid[y][x].equals("X")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean allSunk(ArrayList<Ship> ships, Field field) {

        for (Ship ship: ships) {
            if (!ship.isSunk(field)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsCoord(int y, int x){

        int ay = coord[0];
        int ax = coord[1];
        int by = coord[2];
        int bx = coord[3];

        if ((y>=ay && y<=by) && (x>=ax && x<=bx)) {
            return true;
        }
        return false;
    }

    public int getSize() {
        return 0;
    }
}
