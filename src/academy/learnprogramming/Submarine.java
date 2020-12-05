package academy.learnprogramming;

public class Submarine extends Ship {
    int size = 3;

    @Override
    public int getSize() {
        return size;
    }

    public String toString(){
        return "Submarine (3 cells):";
    }

}
