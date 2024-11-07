public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playTicTacToe();

        Permutation permutation = new Permutation();
        permutation.generatePermutation();

        TextFormatter textFormatter = new TextFormatter();
        textFormatter.alignText();

        DiamondMatrix dMatrix = new DiamondMatrix();
        dMatrix.getDiamondMatrix();
    }
}
