import java.io.IOException;
import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) throws IOException {
        // Field initializing
        Scanner sc = new Scanner(System.in);
        Field fogField1 = new Field();
        Field field1 = new Field();
        System.out.println("Player 1, place your ships on the game field");
        printField(field1.field);

        // Asking for AC coord and setting ship
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.AC.label, Ships.AC.cells);
        String coordAC = sc.nextLine();
        Ship AC = new Ship(coordAC, Ships.AC.label, Ships.AC.cells, field1.field);
        int setAC = setShip(AC, field1.field, AC.getRowStart(), AC.getColumnStart(), AC.getRowEnd(), AC.getColumnEnd());
        while (setAC != 0) {
            coordAC = sc.nextLine();
            AC = new Ship(coordAC, Ships.AC.label, Ships.AC.cells, field1.field);
            setAC = setShip(AC, field1.field, AC.getRowStart(), AC.getColumnStart(), AC.getRowEnd(), AC.getColumnEnd());
        }
        printField(field1.field);

        // Asking for BS coord and setting ship
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.BS.label, Ships.BS.cells);
        String coordBS = sc.nextLine();
        Ship BS = new Ship(coordBS, Ships.BS.label, Ships.BS.cells, field1.field);
        int setBS = setShip(BS, field1.field, BS.getRowStart(), BS.getColumnStart(), BS.getRowEnd(), BS.getColumnEnd());
        while (setBS != 0) {
            coordBS = sc.nextLine();
            BS = new Ship(coordBS, Ships.BS.label, Ships.BS.cells, field1.field);
            setBS = setShip(BS, field1.field, BS.getRowStart(), BS.getColumnStart(), BS.getRowEnd(), BS.getColumnEnd());
        }
        printField(field1.field);

        // Asking for SM coord and setting ship
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.SM.label, Ships.SM.cells);
        String coordSM = sc.nextLine();
        Ship SM = new Ship(coordSM, Ships.SM.label, Ships.SM.cells, field1.field);
        int setSM = setShip(SM, field1.field, SM.getRowStart(), SM.getColumnStart(), SM.getRowEnd(), SM.getColumnEnd());
        while (setSM != 0) {
            coordSM = sc.nextLine();
            SM = new Ship(coordSM, Ships.SM.label, Ships.SM.cells, field1.field);
            setSM = setShip(SM, field1.field, SM.getRowStart(), SM.getColumnStart(), SM.getRowEnd(), SM.getColumnEnd());
        }
        printField(field1.field);

        // Asking for CR coord and setting ship
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.CR.label, Ships.CR.cells);
        String coordCR = sc.nextLine();
        Ship CR = new Ship(coordCR, Ships.CR.label, Ships.CR.cells, field1.field);
        int setCR = setShip(CR, field1.field, CR.getRowStart(), CR.getColumnStart(), CR.getRowEnd(), CR.getColumnEnd());
        while (setCR != 0) {
            coordCR = sc.nextLine();
            CR = new Ship(coordCR, Ships.CR.label, Ships.CR.cells, field1.field);
            setCR = setShip(CR, field1.field, CR.getRowStart(), CR.getColumnStart(), CR.getRowEnd(), CR.getColumnEnd());
        }
        printField(field1.field);

        // Asking for DS coord and setting ship
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.DS.label, Ships.DS.cells);
        String coordDS = sc.nextLine();
        Ship DS = new Ship(coordDS, Ships.DS.label, Ships.DS.cells, field1.field);
        int setDS = setShip(DS, field1.field, DS.getRowStart(), DS.getColumnStart(), DS.getRowEnd(), DS.getColumnEnd());
        while (setDS != 0) {
            coordDS = sc.nextLine();
            DS = new Ship(coordDS, Ships.DS.label, Ships.DS.cells, field1.field);
            setDS = setShip(DS, field1.field, DS.getRowStart(), DS.getColumnStart(), DS.getRowEnd(), DS.getColumnEnd());
        }
        printField(field1.field);

        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Field fogField2 = new Field();
        Field field2 = new Field();
        System.out.println("Player 2, place your ships on the game field");
        printField(field2.field);

        // AC for player 2
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.AC.label, Ships.AC.cells);
        String coordAC2 = sc.nextLine();
        Ship AC2 = new Ship(coordAC2, Ships.AC.label, Ships.AC.cells, field2.field);
        int setAC2 = setShip(AC2, field2.field, AC2.getRowStart(), AC2.getColumnStart(), AC2.getRowEnd(), AC2.getColumnEnd());
        while (setAC2 != 0) {
            coordAC = sc.nextLine();
            AC2 = new Ship(coordAC, Ships.AC.label, Ships.AC.cells, field2.field);
            setAC2 = setShip(AC2, field2.field, AC2.getRowStart(), AC2.getColumnStart(), AC2.getRowEnd(), AC2.getColumnEnd());
        }
        printField(field2.field);

        // BS for player 2
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.BS.label, Ships.BS.cells);
        String coordBS2 = sc.nextLine();
        Ship BS2 = new Ship(coordBS2, Ships.BS.label, Ships.BS.cells, field2.field);
        int setBS2 = setShip(BS2, field2.field, BS2.getRowStart(), BS2.getColumnStart(), BS2.getRowEnd(), BS2.getColumnEnd());
        while (setBS2 != 0) {
            coordBS = sc.nextLine();
            BS2 = new Ship(coordBS, Ships.BS.label, Ships.BS.cells, field2.field);
            setBS2 = setShip(AC2, field2.field, BS2.getRowStart(), BS2.getColumnStart(), BS2.getRowEnd(), BS2.getColumnEnd());
        }
        printField(field2.field);

        // SM for player 2
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.SM.label, Ships.SM.cells);
        String coordSM2 = sc.nextLine();
        Ship SM2 = new Ship(coordSM2, Ships.SM.label, Ships.SM.cells, field2.field);
        int setSM2 = setShip(SM2, field2.field, SM2.getRowStart(), SM2.getColumnStart(), SM2.getRowEnd(), SM2.getColumnEnd());
        while (setSM2 != 0) {
            coordSM2 = sc.nextLine();
            SM2 = new Ship(coordSM2, Ships.SM.label, Ships.SM.cells, field2.field);
            setSM2 = setShip(SM2, field2.field, SM2.getRowStart(), SM2.getColumnStart(), SM2.getRowEnd(), SM2.getColumnEnd());
        }
        printField(field2.field);

        // CR for player 2
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.CR.label, Ships.CR.cells);
        String coordCR2 = sc.nextLine();
        Ship CR2 = new Ship(coordCR2, Ships.CR.label, Ships.CR.cells, field2.field);
        int setCR2 = setShip(CR2, field2.field, CR2.getRowStart(), CR2.getColumnStart(), CR2.getRowEnd(), CR2.getColumnEnd());
        while (setCR2 != 0) {
            coordCR2 = sc.nextLine();
            CR2 = new Ship(coordCR2, Ships.CR.label, Ships.CR.cells, field2.field);
            setCR2 = setShip(CR2, field2.field, CR2.getRowStart(), CR2.getColumnStart(), CR2.getRowEnd(), CR2.getColumnEnd());
        }
        printField(field2.field);

        // DS for player 2
        System.out.printf("Enter the coordinates of the %s (%d cells): ", Ships.DS.label, Ships.DS.cells);
        String coordDS2 = sc.nextLine();
        Ship DS2 = new Ship(coordDS2, Ships.DS.label, Ships.DS.cells, field2.field);
        int setDS2 = setShip(DS2, field2.field, DS2.getRowStart(), DS2.getColumnStart(), DS2.getRowEnd(), DS2.getColumnEnd());
        while (setDS2 != 0) {
            coordDS2 = sc.nextLine();
            DS2 = new Ship(coordDS2, Ships.DS.label, Ships.DS.cells, field2.field);
            setDS2 = setShip(DS2, field2.field, DS2.getRowStart(), DS2.getColumnStart(), DS2.getRowEnd(), DS2.getColumnEnd());
        }
        printField(field2.field);

        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int turn = 1;
        int shot = 0;
        gameLoop:
        while (true) {
            if (turn == 1) {
                if (calcO(field2.field) == 0) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    break gameLoop;
                } else if (shot == 0) {
                    printField(fogField2.field);
                    System.out.println("---------------------");
                    printField(field1.field);
                    System.out.println("Player 1, it's your turn: ");
                    String shotCoord = sc.nextLine();
                    shot = shoot(shotCoord, fogField2.field, field2.field);
                    System.out.println("Press Enter and pass the move to another player");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    turn = 2;
                }
            } else if (turn == 2) {
                if (calcO(field1.field) == 0) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    break gameLoop;
                } else if (shot == 0) {
                    printField(fogField1.field);
                    System.out.println("---------------------");
                    printField(field2.field);
                    System.out.println("Player 2, it's your turn: ");
                    String shotCoord = sc.nextLine();
                    shot = shoot(shotCoord, fogField1.field, field1.field);
                    System.out.println("Press Enter and pass the move to another player");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    turn = 1;
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

class Field {
    String[][] field = new String[11][11];

    public Field() {
        this.field = fillField();
    }

    public static String[][] fillField() {
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
        return field;
    }
}