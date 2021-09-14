import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the row number: ");
        int row = scan.nextInt();
        System.out.println("Enter the column number: ");
        int col = scan.nextInt();
        

        MineSweeper mineCreate = new MineSweeper(row, col);
        mineCreate.createMatrice();
        System.out.println("Location of mines");
        mineCreate.printMatrice();
        mineCreate.run();

        scan.close();
    }
}
