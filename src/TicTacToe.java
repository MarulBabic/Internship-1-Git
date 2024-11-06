import java.util.Scanner;

public class TicTacToe {

    public void playTicTacToe() {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[3][3];
        initializeMatrix(matrix);
        print(matrix);

        int choice = 0;
        boolean playerX = true;
        int moves = 0;
        while (true) {
            System.out.println("Igrač " + (playerX ? "X" : "O") + ", unesite broj od 1 do 9");
            choice = scanner.nextInt();

            if (choice < 1 || choice > 9) {
                System.out.println("Neispravan unos, unesite broj od 1 do 9");
                continue;
            }

            int row = (choice - 1) / 3;
            int col = (choice - 1) % 3;

            if (!isEmpty(matrix, row, col)) {
                System.out.println("Polje je zauzeto, pokušajte ponovno");
                continue;
            }

            matrix[row][col] = playerX ? 'X' : 'O';
            moves++;

            print(matrix);

            if (checkWin(matrix)) {
                System.out.println("Igrač " + (playerX ? "X" : "O") + " je pobijedio!");
                break;
            }

            if (moves == 9) {
                System.out.println("Igra je neriješena");
                break;
            }

            playerX = !playerX;
        }
        scanner.close();
    }


    private void initializeMatrix(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = '_';
            }
        }
    }


    private void print(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isEmpty(char[][] matrix, int i, int j) {
        return matrix[i][j] != 'X' && matrix[i][j] != 'O';
    }


    private boolean checkWin(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] != '_' && matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]) {
                return true;
            }
            if (matrix[0][i] != '_' && matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i]) {
                return true;
            }
        }

        if (matrix[0][0] != '_' && matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) {
            return true;
        }
        if (matrix[0][2] != '_' && matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]) {
            return true;
        }
        return false;
    }
}
