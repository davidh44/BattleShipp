package academy.learnprogramming;

import java.util.Scanner;

public class ShipFactory {

    public void createShip(Ship ship, Scanner scanner, Field field) {

        System.out.println("Enter the coordinates of the " + ship);

        while(true) {
            String uno = scanner.next();
            String dos = scanner.next();
            int[] coord = convertCoord(uno, dos);

            if(checkInput(coord, field.getGrid(), ship.getSize())){
                field = placeShip(coord, field);
                giveShipCoord(coord, ship);
                break;
            }
            System.out.println("Error! Try again, fool!");
        }
        field.printMatrix();
    }

    static Field placeShip(int[] coord, Field field) {

        int ay = coord[0];
        int ax = coord[1];
        int by = coord[2];
        int bx = coord[3];

        if (ay==by) {
            for(int x=ax; x<=bx; x++) {
                field.getGrid()[ay][x] = "O";
            }
        }
        else if (ax==bx) {
            for(int y=ay; y<=by; y++) {
                field.getGrid()[y][ax] = "O";
            }
        }

        return field;
    }

    public void giveShipCoord(int[] coord, Ship ship){
        ship.setCoord(coord);
    }

    public int[] convertCoord(String a, String b) {
        int ax =10;
        int ay =10;
        int bx =10;
        int by =10;

        if (a.length()==2) {
            ax = Integer.valueOf(Character.toString(a.charAt(1)));
        }
        Character ac = a.charAt(0);
        if (!ac.equals('J')) {
            ay = (char) (ac-16) - '0';
        }

        if (b.length()==2) {
            bx = Integer.valueOf(Character.toString(b.charAt(1)));
        }
        Character bc = b.charAt(0);
        if (!bc.equals('J')) {
            by = (char) (bc-16) - '0';
        }

        if (ay>by) {
            int c = ay;
            ay = by;
            by = c;
        }
        if (ax>bx) {
            int c = ax;
            ax = bx;
            bx = c;
        }
        return new int[]{ay, ax, by, bx};
    }

    public boolean checkInput(int[] coord, String[][] field, int size) {
        int ay = coord[0];
        int ax = coord[1];
        int by = coord[2];
        int bx = coord[3];
        int xDiff = bx-ax;
        int yDiff = by-ay;

        if ((xDiff!=0) && (yDiff!=0)) {
            return false;
        } else if ((xDiff==0) && (yDiff!=size-1)) {
            return false;
        } else if ((yDiff==0) && (xDiff!=size-1)) {
            return false;
        }

        if (ay==by) {
            for(int x=ax; x<=bx; x++) {
                //check if ships overlap
                if (field[ay][x].equals("O")) {
                    return false;
                }
            }
            if (ay!=1) {
                //check row above
                for (int x=ax; x<=bx; x++) {
                    if(field[ay-1][x].equals("O")) {
                        return false;
                    }
                }
            }
            if (by!=10){
                //check row below
                for (int x=ax; x<=bx; x++) {
                    if(field[by+1][x].equals("O")) {
                        return false;
                    }
                }
            }
            if (ax!=1) {
                //check row to left (only 1 square)
                if (field[ay][ax-1].equals("O")) {
                    return false;
                }
            }
            if (bx!=10) {
                //check row to right (only 1 square)
                if (field[ay][bx+1].equals("O")) {
                    return false;
                }
            }
        }
        else if (ax==bx) {
            for(int y=ay; y<=by; y++) {
                //check if ships overlap
                if(field[y][ax].equals("O")) {
                    return false;
                }
            }
            if (ay!=1) {
                //check row above (only 1 square)
                if (field[ay-1][ax].equals("O")) {
                    return false;
                }
            }
            if (by!=10){
                //check row below (only 1 square)
                if (field[by+1][ax].equals("O")) {
                    return false;
                }
            }
            if (ax!=1) {
                //check row to left
                for(int y=ay; y<=by;y++) {
                    if (field[y][ax-1].equals("O")) {
                        return false;
                    }
                }
            }
            if (bx!=10) {
                //check row to right
                for(int y=ay; y<=by;y++) {
                    if (field[y][bx+1].equals("O")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
