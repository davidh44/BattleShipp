package academy.learnprogramming;

public class Field {

    String[][] field;

    public Field(int size) {
        field = new String[size][size];

        char rowLetter = 'A';
        int colNum = 1;
        field[0][0] = " ";

        for (int x = 1; x < size; x++) {
            field[0][x] = Integer.toString(colNum);
            colNum++;
        }

        for (int y = 1; y < size; y++) {
            field[y][0] = Character.toString(rowLetter);
            rowLetter++;
        }

        for (int y = 1; y < size; y++) {
            for (int x = 1; x < 11; x++) {
                field[y][x] = "~";
            }
        }
    }

    public String[][] getGrid() {
        return field;
    }

    public void printMatrix() {
        for(int r=0; r<this.getGrid().length; r++) {
            for(int c=0; c<this.getGrid()[r].length; c++) {
                System.out.print(this.getGrid()[r][c] + " ");
            }
            System.out.println();
        }
    }

}
