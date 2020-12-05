package academy.learnprogramming;

public class Battleship extends Ship {
    int size = 4;

    @Override
    public int getSize() {
        return size;
    }

    public String toString(){
        return "Battleship (4 cells):";
    }

}
