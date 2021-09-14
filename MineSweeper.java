import java.util.Scanner;

public class MineSweeper {
    int mineRow;
    int mineCol;
    int mineNumber;
    int counter;
    int nonMineNumber;
    String[][] mineMatrice;
    

    MineSweeper(int row, int col){
        this.mineRow = row;
        this.mineCol = col;
        this.mineNumber = row*col/4;
        this.nonMineNumber = row*col - this.mineNumber;
        this.mineMatrice = new String[row][col];
        this.counter = 0;
    }

    public void checkMine(int row, int col){
        int sum = 0;     

        if (row > 0 && this.mineMatrice[row - 1][col] == "*")
            sum++;
        if (col > 0 && this.mineMatrice[row][col - 1] == "*")
            sum++;
        if (row > 0 && col > 0   && this.mineMatrice[row - 1][col - 1] == "*")
            sum++;
        if (row < this.mineRow - 1 && this.mineMatrice[row + 1][col] == "*")
            sum++;
        if (col < this.mineCol - 1 && this.mineMatrice[row][col + 1] == "*")
            sum++;
        if (row < this.mineRow - 1 && col < this.mineCol - 1  && this.mineMatrice[row + 1][col + 1] == "*")
            sum++;
        if (row < this.mineRow - 1 && col > 0 && this.mineMatrice[row + 1][col - 1] == "*")
            sum++;
        if (row > 0 && col < this.mineCol - 1 && this.mineMatrice[row - 1][col + 1] == "*")
            sum++;
        
        this.mineMatrice[row][col] = String.valueOf(sum);

    }
    public void run(){
        Scanner scan2 = new Scanner(System.in);
    
        for(int i=0;i<this.nonMineNumber;i++){
            System.out.println("Enter row number:");
            int row = scan2.nextInt();
            while (row<0 || row>this.mineRow){
                row = scan2.nextInt();
            }
            System.out.println("Enter col number:");
            int col = scan2.nextInt();
            while (col<0 || col>this.mineCol){
                col = scan2.nextInt();
            }
            

            this.counter++;
            if (this.mineMatrice[row][col]=="*"){
                System.out.println("You lost. Game over!");
                break;
            }
            if (this.counter==this.nonMineNumber){
                System.out.println("You won. Game over!");
            }
            checkMine(row,col);
            printMatrice();

        }
        scan2.close();
        
    }

    public void createMatrice(){

        for(int i=0;i<this.mineRow;i++){
            for(int j=0;j<this.mineCol;j++){
                this.mineMatrice[i][j] = "-";
            }
        }
        int i = 0;
        
        while(i<this.mineNumber){
            int r = (int) (Math.random()*this.mineRow);
            int c = (int) (Math.random()*this.mineCol);
            if (this.mineMatrice[r][c] != "*")
                this.mineMatrice[r][c] = "*";
            else
                continue;
            i++;
        }

    }
    public void printMatrice(){
        for(int i=0;i<this.mineRow;i++){
            for(int j=0;j<this.mineCol;j++){
                System.out.print(this.mineMatrice[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    
}
