import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] field = new String[11][11];
        field[0][0] = "   ";
        field[0][1] = "1  ";
        field[0][2] = "2  ";
        field[0][3] = "3  ";
        field[0][4] = "4  ";
        field[0][5] = "5  ";
        field[0][6] = "6  ";
        field[0][7] = "7  ";
        field[0][8] = "8  ";
        field[0][9] = "9  ";
        field[0][10] = "10  ";
        field[1][0] = "A  ";
        field[2][0] = "B  ";
        field[3][0] = "C  ";
        field[4][0] = "D  ";
        field[5][0] = "E  ";
        field[6][0] = "F  ";
        field[7][0] = "G  ";
        field[8][0] = "H  ";
        field[9][0] = "I  ";
        field[10][0] = "J  ";
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                field[i][j] = "~  ";
            }
        }
        for (int k = 0; k <= 10; k++) {
            for (int x = 0; x <= 10; x++) {
                System.out.print(field[k][x]);
            }
            System.out.println("");
        }
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.AC.label, Ships.AC.cells);
        String coord = sc.nextLine();
        Ship AC = new Ship(coord, "Aircraft Carrier", 5, field);
        int setAC = setShip(AC, field, AC.getRowStart(), AC.getColumnStart(), AC.getRowEnd(), AC.getColumnEnd());
    }

    public static int setShip(Ship ship, String[][] field, int rowStart, int columnStart, int rowEnd, int columnEnd) {
        int isHorizontal = 0;
        int ret = 0;
        if (rowStart == rowEnd) {
            isHorizontal = 1;
        } else if (columnStart == columnEnd) {
            isHorizontal = 0;
        } else {
            isHorizontal = 2;
        }
        if (isHorizontal == 0) {
            if (rowStart > rowEnd) {
                if (ship.size != rowStart - rowEnd + 1) {
                    ret = 1;
                    System.out.println("Error! Wrong length of the Submarine!");
                }
            } else if (rowEnd > rowStart) {
                if (ship.size != rowEnd - rowStart + 1) {
                    ret = 1;
                    System.out.println("Error! Wrong length of the Submarine!");
                }
            }
        } else if (isHorizontal == 1) {
            if (columnStart > columnEnd) {
                if (ship.size != columnStart - columnEnd + 1) {
                    ret = 1;
                    System.out.println("Error! Wrong length of the Submarine!");
                }
            } else if (columnEnd > columnStart) {
                if (ship.size != columnEnd - columnStart + 1) {
                    ret = 1;
                    System.out.println("Error! Wrong length of the Submarine!");
                }
            }
        }
        if (isHorizontal == 2 && ret == 0) {
            System.out.println("Error! Wrong ship location! Try again: ");
        } else if (isHorizontal == 1 && ret == 0) {

        }
        return ret;
    }
}

enum Ships {
    AC("Aircraft Carrier", 5), BS("Battleship", 4), SM("Submarine", 3), CR("Cruiser", 3), DS("Destroyer", 2);

    public final String label;
    public final int cells;

    Ships(String label, int cells) {
        this.label = label;
        this.cells = cells;
    }
}

class Ship {
    int rowStart;
    int columnStart;
    int rowEnd;
    int columnEnd;
    String name;
    int size;
    public Ship(String coord, String name, int size, String[][] arr) {
        this.size = size;
        this.name = name;
        String[] coordArr = coord.split(" ");
        String coordStart = coordArr[0].toString();
        String coordEnd = coordArr[1].toString();

        String row1 = String.valueOf(coordStart.charAt(0));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0].equals(row1)) {
                this.rowStart = i;
            }
        }
        if (coordStart.charAt(2) == '0') {
            for (int i = 0; i < arr[0].length; i++) {
                this.columnStart = 10;
            }
        } else {
            for (int i = 0; i < arr[0].length; i++) {
                if (arr[0][i].equals(String.valueOf(coordStart.charAt(1)))) {
                    this.columnStart = i;
                }
            }
        }

        String row2 = String.valueOf(coordEnd.charAt(0));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0].equals(row2)) {
                this.rowEnd = i;
            }
        }
        if (coordEnd.charAt(2) == '0') {
            for (int i = 0; i < arr[0].length; i++) {
                this.columnEnd = 10;
            }
        } else {
            for (int i = 0; i < arr[0].length; i++) {
                if (arr[0][i].equals(String.valueOf(coordEnd.charAt(1)))) {
                    this.columnEnd = i;
                }
            }
        }
    }

    public int getRowStart() {
        return rowStart;
    }

    public int getColumnStart() {
        return columnStart;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public int getColumnEnd() {
        return columnEnd;
    }
}