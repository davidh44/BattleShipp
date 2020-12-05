package academy.learnprogramming;

public class Destroyer extends Ship {
    int size = 2;

    @Override
    public int getSize() {
        return size;
    }

    public String toString(){
        return "Destroyer (2 cells):";
    }

}
