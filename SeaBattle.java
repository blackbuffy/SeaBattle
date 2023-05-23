import java.util.Arrays;
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
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells): ");
        String coord = sc.nextLine();
        char let1 = coord.charAt(0);
        System.out.println(indexOf(field, let1));
    }

    private static int indexOf(String[][] arr, String str) {
        int index = 0;
        if (!str.equals("1") && !str.equals("2") && !str.equals("3") && !str.equals("4") && !str.equals("5") && !str.equals("6") && !str.equals("7") && !str.equals("8") && !str.equals("9")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0].equals(str)) {
                    index = i;
                }
            }
        } else {
            for (int i = 0; i < arr[0].length; i++) {
                if (arr[0][i].equals(str)) {
                    index = i;
                }
            }
        }
        return index;
    }

    public static void setShip(String coord, String[][] field) {

    }
}
