import java.util.Scanner;

public class DiamondMatrix {

    public void getDiamondMatrix(){
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("Unesite zeljeni broj redaka dijamantske matrice (neparan broj):");

        while (true) {
            n = scanner.nextInt();

            if (n % 2 != 0) {
                break;
            } else {
                System.out.println("Unesite neparan broj za pravilni dijamant.");
            }
        }

        printDiamond(n);

        scanner.close();
    }

    private void printDiamond(int n) {
        int midPoint = n / 2;

        for (int i = 0; i <= midPoint; i++) {
            printDiamondLine(i, midPoint);
        }

        for (int i = midPoint - 1; i >= 0; i--) {
            printDiamondLine(i, midPoint);
        }
    }

    private void printDiamondLine(int row, int midPoint) {
        int numStars = 1 + 2 * row;
        int spaces = midPoint - row;

        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < numStars; i++) {
            System.out.print("*");
        }

        System.out.println();
    }
}
