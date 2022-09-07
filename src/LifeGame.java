import java.util.Scanner;

public class LifeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board(450);
        do {
            board.print();
            scanner.next();
        }while (board.nextStep() > 0);
    }
}
