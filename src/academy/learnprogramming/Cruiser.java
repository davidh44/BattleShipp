package academy.learnprogramming;

public class Cruiser extends Ship {

    int size = 3;

    @Override
    public int getSize() {
        return size;
    }

    public String toString(){
        return "Cruiser (3 cells):";
    }

}
