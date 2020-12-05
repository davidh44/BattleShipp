package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Shooter {

    public boolean over = false;

    public void fireShot(Scanner scanner, Field field, Field field2, ArrayList<Ship> ships) {

        while(true) {
            String s= scanner.next();
            int x = 10;
            int y = 10;

            if ((s.length()==3) && Character.getNumericValue(s.charAt(2))>0) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                continue;
            }

            Character yy = s.charAt(0);
            if ((!yy.equals('J'))) {
                y = (char) (yy-16) - '0';
            }
            if (s.length()==2) {
                x = Integer.valueOf(Character.toString(s.charAt(1)));
            }

            if (x<1 || x>10 || y<1 || y>10) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
            else if (field.getGrid()[y][x].equals("O") || field.getGrid()[y][x].equals("X")) {
                field.getGrid()[y][x] = "X";
                field2.getGrid()[y][x] = "X";

                //
                if (ships.get(0).allSunk(ships, field)) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    over = true;
                    break;
                }

                boolean sunk = false;

                for (Ship ship: ships) {
                    if (ship.containsCoord(y, x)) {
                        if (ship.isSunk(field)) {
                            System.out.println("You sank a ship!");
                            sunk = true;
                            break;
                        }
                    }
                }
                if (!sunk) {
                    System.out.println("You hit a ship!");
                }

                passMove();
                break;
            }
            else {
                field.getGrid()[y][x] = "M";
                field2.getGrid()[y][x] = "M";
                System.out.println("You missed!");

                passMove();
                break;
            }

        }

    }

    public boolean isOver(){
        return over;
    }

    public void passMove(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Press Enter and pass the move to another player");

        scanner.nextLine();

        System.out.println("...");
    }

}
