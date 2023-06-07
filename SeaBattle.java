import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) {
        // Field initializing
        Scanner sc = new Scanner(System.in);
        String[][] fogField = new String[11][11];
        fogField[0][0] = " ";
        fogField[0][1] = "1";
        fogField[0][2] = "2";
        fogField[0][3] = "3";
        fogField[0][4] = "4";
        fogField[0][5] = "5";
        fogField[0][6] = "6";
        fogField[0][7] = "7";
        fogField[0][8] = "8";
        fogField[0][9] = "9";
        fogField[0][10] = "10";
        fogField[1][0] = "A";
        fogField[2][0] = "B";
        fogField[3][0] = "C";
        fogField[4][0] = "D";
        fogField[5][0] = "E";
        fogField[6][0] = "F";
        fogField[7][0] = "G";
        fogField[8][0] = "H";
        fogField[9][0] = "I";
        fogField[10][0] = "J";
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                fogField[i][j] = "~";
            }
        }
        String[][] field = new String[11][11];
        field[0][0] = " ";
        field[0][1] = "1";
        field[0][2] = "2";
        field[0][3] = "3";
        field[0][4] = "4";
        field[0][5] = "5";
        field[0][6] = "6";
        field[0][7] = "7";
        field[0][8] = "8";
        field[0][9] = "9";
        field[0][10] = "10";
        field[1][0] = "A";
        field[2][0] = "B";
        field[3][0] = "C";
        field[4][0] = "D";
        field[5][0] = "E";
        field[6][0] = "F";
        field[7][0] = "G";
        field[8][0] = "H";
        field[9][0] = "I";
        field[10][0] = "J";
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                field[i][j] = "~";
            }
        }
        printField(field);
        // Asking for AC coord and setting ship
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.AC.label, Ships.AC.cells);
        String coordAC = sc.nextLine();
        Ship AC = new Ship(coordAC, Ships.AC.label, Ships.AC.cells, field);
        int setAC = setShip(AC, field, AC.getRowStart(), AC.getColumnStart(), AC.getRowEnd(), AC.getColumnEnd());
        while (setAC != 0) {
            coordAC = sc.nextLine();
            AC = new Ship(coordAC, "Aircraft Carrier", 5, field);
            setAC = setShip(AC, field, AC.getRowStart(), AC.getColumnStart(), AC.getRowEnd(), AC.getColumnEnd());
        }
        printField(field);
        // Asking for BS coord and setting ship
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.BS.label, Ships.BS.cells);
        String coordBS = sc.nextLine();
        Ship BS = new Ship(coordBS, Ships.BS.label, Ships.BS.cells, field);
        int setBS = setShip(BS, field, BS.getRowStart(), BS.getColumnStart(), BS.getRowEnd(), BS.getColumnEnd());
        while (setBS != 0) {
            coordBS = sc.nextLine();
            BS = new Ship(coordBS, Ships.BS.label, Ships.BS.cells, field);
            setBS = setShip(BS, field, BS.getRowStart(), BS.getColumnStart(), BS.getRowEnd(), BS.getColumnEnd());
        }
        printField(field);
        // Asking for SM coord and setting ship
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.SM.label, Ships.SM.cells);
        String coordSM = sc.nextLine();
        Ship SM = new Ship(coordSM, Ships.SM.label, Ships.SM.cells, field);
        int setSM = setShip(SM, field, SM.getRowStart(), SM.getColumnStart(), SM.getRowEnd(), SM.getColumnEnd());
        while (setSM != 0) {
            coordSM = sc.nextLine();
            SM = new Ship(coordSM, Ships.SM.label, Ships.SM.cells, field);
            setSM = setShip(SM, field, SM.getRowStart(), SM.getColumnStart(), SM.getRowEnd(), SM.getColumnEnd());
        }
        printField(field);
        // Asking for CR coord and setting ship
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.CR.label, Ships.CR.cells);
        String coordCR = sc.nextLine();
        Ship CR = new Ship(coordCR, Ships.CR.label, Ships.CR.cells, field);
        int setCR = setShip(CR, field, CR.getRowStart(), CR.getColumnStart(), CR.getRowEnd(), CR.getColumnEnd());
        while (setCR != 0) {
            coordCR = sc.nextLine();
            CR = new Ship(coordCR, Ships.CR.label, Ships.CR.cells, field);
            setCR = setShip(CR, field, CR.getRowStart(), CR.getColumnStart(), CR.getRowEnd(), CR.getColumnEnd());
        }
        printField(field);
        // Asking for DS coord and setting ship
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.DS.label, Ships.DS.cells);
        String coordDS = sc.nextLine();
        Ship DS = new Ship(coordDS, Ships.DS.label, Ships.DS.cells, field);
        int setDS = setShip(DS, field, DS.getRowStart(), DS.getColumnStart(), DS.getRowEnd(), DS.getColumnEnd());
        while (setDS != 0) {
            coordDS = sc.nextLine();
            DS = new Ship(coordDS, Ships.DS.label, Ships.DS.cells, field);
            setDS = setShip(DS, field, DS.getRowStart(), DS.getColumnStart(), DS.getRowEnd(), DS.getColumnEnd());
        }
        printField(field);
        // First shot
        System.out.println("The game starts!");
        printField(fogField);
        System.out.println("Take a shot!");
        String shotCoord = sc.nextLine();
        int shot = shoot(shotCoord, fogField, field);
        infLoop:
        while (calcO(field) > 0) {
            shotCoord = sc.nextLine();
            shot = shoot(shotCoord, fogField, field);
            if (shot != 0) {
                while (shot != 0) {
                    shotCoord = sc.nextLine();
                    shot = shoot(shotCoord, fogField, field);
                }
            }
        }
    }

    public static int setShip(Ship ship, String[][] field, int rowStart, int columnStart, int rowEnd, int columnEnd) {
        int isHorizontal = 0;
        int ret = 0;
        // Checking for error 1: is ship diagonal, and checking for horizontal/vertical
        if (rowStart != rowEnd && columnStart != columnEnd) {
            ret = 1;
            isHorizontal = 2;
            System.out.println("Error! Wrong ship location! Try again: ");
        } else if (rowStart == rowEnd && columnStart != columnEnd) {
            isHorizontal = 1;
        } else if (columnStart == columnEnd && rowStart != rowEnd) {
            isHorizontal = 0;
        }
        // Checking for error 2: wrong length
        if (isHorizontal == 0 && ret != 1) {
            if (rowStart > rowEnd) {
                if (ship.size != rowStart - rowEnd + 1) {
                    ret = 1;
                    System.out.printf("Error! Wrong length of the %s! Try again: ", ship.name);
                }
            } else if (rowEnd > rowStart) {
                if (ship.size != rowEnd - rowStart + 1) {
                    ret = 1;
                    System.out.printf("Error! Wrong length of the %s! Try again: ", ship.name);
                }
            } else {
                System.out.printf("Error! Wrong length of the %s! Try again: ", ship.name);
                ret = 1;
            }
        } else if (isHorizontal == 1 && ret != 1) {
            if (columnStart > columnEnd) {
                if (ship.size != columnStart - columnEnd + 1) {
                    ret = 1;
                    System.out.printf("Error! Wrong length of the %s! Try again: ", ship.name);
                }
            } else if (columnEnd > columnStart) {
                if (ship.size != columnEnd - columnStart + 1) {
                    ret = 1;
                    System.out.printf("Error! Wrong length of the %s! Try again: ", ship.name);
                }
            } else {
                System.out.printf("Error! Wrong length of the %s! Try again: ", ship.name);
                ret = 1;
            }
        }
        // Checking for error 3: too close to another ship
        if (isHorizontal == 2 && ret == 0) {
            System.out.println("Error! Wrong ship location! Try again: ");
        } else if (isHorizontal == 1 && ret != 1) {
            for (int i = columnStart; i <= columnEnd; i++) {
                if (field[rowStart][i].equals("A") || field[rowStart][i].equals("B") || field[rowStart][i].equals("C") || field[rowStart][i].equals("D") || field[rowStart][i].equals("E") || field[rowStart][i].equals("F") || field[rowStart][i].equals("G") || field[rowStart][i].equals("H") || field[rowStart][i].equals("I") || field[rowStart][i].equals("J")) {
                    ret = 1;
                    System.out.println("Error! You placed it too close to another one. Try again: ");
                }
            }
            for (int i = Math.max(0, rowStart) - 1; i <= Math.min(rowStart + 1, 10) && ret != 1; i++) {
                for (int j = Math.max(0, columnStart) - 1; j <= Math.min(10, columnEnd + 1) && ret != 1; j++) {
                    if (field[i][j] == "O") {
                        ret = 1;
                        System.out.println("Error! You placed it too close to another one. Try again: ");
                    }
                }
            }
        } else if (isHorizontal == 0 && ret != 1) {
            for (int i = rowStart; i <= rowEnd; i++) {
                if (field[i][columnStart].equals("A") || field[i][columnStart].equals("B") || field[i][columnStart].equals("C") || field[i][columnStart].equals("D") || field[i][columnStart].equals("E") || field[i][columnStart].equals("F") || field[i][columnStart].equals("G") || field[i][columnStart].equals("H") || field[i][columnStart].equals("I") || field[i][columnStart].equals("J")) {
                    ret = 1;
                    System.out.println("Error! You placed it too close to another one. Try again: ");
                }
            }
            for (int i = Math.max(0, rowStart) - 1; i <= Math.min(rowStart + 1, 10) && ret != 1; i++) {
                for (int j = Math.max(0, columnStart) - 1; j <= Math.min(10, columnEnd + 1) && ret != 1; j++) {
                    if (field[i][j] == "O") {
                        ret = 1;
                        System.out.println("Error! You placed it too close to another one. Try again: ");
                    }
                }
            }
        }
        // Setting ship
        if (isHorizontal == 1 && ret == 0) {
            for (int i = Math.min(columnStart, columnEnd); i <= Math.max(columnEnd, columnStart); i++) {
                field[rowStart][i] = "O";
            }
        } else if (isHorizontal == 0 && ret == 0) {
            for (int i = Math.min(rowStart, rowEnd); i <= Math.max(rowStart, rowEnd); i++) {
                field[i][columnStart] = "O";
            }
        }
        return ret;
    }

    public static void printField(String[][] field) {
        for (int k = 0; k <= 10; k++) {
            for (int x = 0; x <= 10; x++) {
                System.out.print(field[k][x]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static int calcO(String[][] field) {
        int O = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("O")) {
                    O++;
                }
            }
        }
        return O;
    }

    public static int shoot(String coord, String[][] fogField, String[][] field) {
        int ret = 0;
        int row = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[i][0].equals(String.valueOf(coord.charAt(0)))) {
                row = i;
            }
        }
        if (row == 0) {
            System.out.println("Error! You entered the wrong coordinates! Try again: ");
            ret = 1;
        }

        int column = 0;
        for (int i = 0; i < field[0].length; i++) {
            if (coord.length() == 3) {
                if (Integer.parseInt(String.valueOf(coord.charAt(2))) == 0) {
                    column = 10;
                    break;
                } else {
                    System.out.println("Error! You entered the wrong coordinates! Try again: ");
                    ret = 1;
                    break;
                }
            } else if (field[0][i].equals(String.valueOf(coord.charAt(1)))) {
                column = i;
            }
        }
        if (column == 0 && row != 0) {
            System.out.println("Error! You entered the wrong coordinates! Try again: ");
            ret = 1;
        }

        int O = 0;
        if (field[row][column].equals("O") && ret != 1) {
            fogField[row][column] = "X";
            field[row][column] = "X";
            outerLoop:
            for (int i = Math.max(0, row - 1); i <= Math.min(10, row + 1); i++) {
                for (int j = Math.max(0, column - 1); j <= Math.min(10, column + 1); j++) {
                    if (field[i][j].equals("O")) {
                        O++;
                    }
                }
            }
            if (calcO(field) == 0) {
                printField(fogField);
                System.out.println("You sank the last ship. You won. Congratulations!");
            } else if (O > 0) {
                printField(fogField);
                System.out.println("You hit a ship! Try again:");
            } else if (O == 0) {
                printField(fogField);
                System.out.println("You sank a ship! Specify a new target:");
            }
        } else if (field[row][column].equals("~") && ret != 1) {
            fogField[row][column] = "M";
            field[row][column] = "M";
            printField(fogField);
            System.out.println("You missed! Try again:");
        } else if (field[row][column].equals("X") && ret != 1) {
            printField(fogField);
            System.out.println("You hit a ship! Try again:");
        } else if (field[row][column].equals("M") && ret != 1) {
            printField(fogField);
            System.out.println("You missed! Try again:");
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
        if (coordStart.length() > 2) {
            this.columnStart = 10;
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
        if (coordEnd.length() > 2) {
            this.columnEnd = 10;
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