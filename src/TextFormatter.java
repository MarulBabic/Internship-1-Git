import java.util.Scanner;

public class TextFormatter {


    public void alignText() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Unesite maksimalan broj znakova po liniji (m): ");
        int m = scanner.nextInt();
        System.out.print("Unesite dužinu linije (n): ");
        int n = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Unesite tekst (praznim redom završite unos):");
        StringBuilder text = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            text.append(line).append("\n");
        }

        centralAlignment(text.toString().trim(), m, n);

        scanner.close();
    }

    private void centralAlignment(String text, int m, int n) {
        String[] lines = text.split("\n");

        StringBuilder resultText = new StringBuilder();

        for (String line : lines) {
            resultText.append(centerLine(line, n));
        }

        System.out.println(resultText.toString());
    }

    private String centerLine(String line, int n) {
        int lineLength = line.length();

        if (lineLength >= n) {
            return line + "\n";
        }

        int spacesNeeded = n - lineLength;
        int leftPadding = spacesNeeded / 2;
        int rightPadding = spacesNeeded - leftPadding;

        StringBuilder centeredLine = new StringBuilder();

        for (int i = 0; i < leftPadding; i++) {
            centeredLine.append(" ");
        }

        centeredLine.append(line);

        for (int i = 0; i < rightPadding; i++) {
            centeredLine.append(" ");
        }

        return centeredLine.toString() + "\n";
    }

}
