package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //create fields for Player 1
        //field = ships showing, field 2 = ships hidden
        Field fieldA = new Field(11);
        Field field2A = new Field(11);

        //create fields for Player 2
        Field fieldB = new Field(11);
        Field field2B = new Field(11);

        //create ship factory, shooter, scanner
        ShipFactory factory = new ShipFactory();
        Shooter shooter = new Shooter();
        Scanner scanner = new Scanner(System.in);

        //create ships for player1
        AircraftCarrier aircraftCarrier = new AircraftCarrier();
        Battleship battleship = new Battleship();
        Submarine submarine = new Submarine();
        Cruiser cruiser = new Cruiser();
        Destroyer destroyer = new Destroyer();

        ArrayList<Ship> ships = new ArrayList<>();
        ships.add(aircraftCarrier);
        ships.add(battleship);
        ships.add(submarine);
        ships.add(cruiser);
        ships.add(destroyer);

        //create ships for player2
        AircraftCarrier aircraftCarrierB = new AircraftCarrier();
        Battleship battleshipB = new Battleship();
        Submarine submarineB = new Submarine();
        Cruiser cruiserB = new Cruiser();
        Destroyer destroyerB = new Destroyer();

        ArrayList<Ship> shipsB = new ArrayList<>();
        shipsB.add(aircraftCarrierB);
        shipsB.add(battleshipB);
        shipsB.add(submarineB);
        shipsB.add(cruiserB);
        shipsB.add(destroyerB);

        //Player 1 places ships
        System.out.println("Player 1, place your ships on the game field");
        fieldA.printMatrix();

        factory.createShip(aircraftCarrier, scanner, fieldA);
        factory.createShip(battleship, scanner, fieldA);
        factory.createShip(submarine, scanner, fieldA);
        factory.createShip(cruiser, scanner, fieldA);
        factory.createShip(destroyer, scanner, fieldA);

        shooter.passMove();

        //Player 2 places ships
        System.out.println("Player 2, place your ships on the game field");
        fieldB.printMatrix();

        factory.createShip(aircraftCarrierB, scanner, fieldB);
        factory.createShip(battleshipB, scanner, fieldB);
        factory.createShip(submarineB, scanner, fieldB);
        factory.createShip(cruiserB, scanner, fieldB);
        factory.createShip(destroyerB, scanner, fieldB);

        shooter.passMove();

        //start game

        while(true) {
            //player 1 turn
            field2B.printMatrix();
            System.out.println("---------------------");
            fieldA.printMatrix();
            System.out.println("Player 1, it's your turn:");

            shooter.fireShot(scanner, fieldB, field2B, shipsB);

            if(shooter.isOver()) {
                break;
            }

            //player 2 turn
            field2A.printMatrix();
            System.out.println("---------------------");
            fieldB.printMatrix();
            System.out.println("Player 2, it's your turn:");
            shooter.fireShot(scanner, fieldA, field2A, ships);

            if(shooter.isOver()) {
                break;
            }

        }

    }

}