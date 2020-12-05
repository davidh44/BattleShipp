package academy.learnprogramming;

public class AircraftCarrier extends Ship {

    int size = 5;

    @Override
    public int getSize() {
        return size;
    }

    public String toString(){
        return "Aircraft Carrier (5 cells):";
    }

}
