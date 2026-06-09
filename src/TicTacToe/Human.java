package TicTacToe;

import java.util.Scanner;

public class Human extends Player{
    private int level;
    private int points;
    private static Scanner sc = new Scanner(System.in);

    public Human(Integer id, String name, Symbol symbol, PlayerType playerType) {
        super(id, name, symbol, playerType);
        this.level = 1;
        this.points = 50;
    }
    public Move makeMove(){
        System.out.println("Hey! "+ this.getName() +" Its your turn, Make a move : ");
        System.out.println("Enter the row : ");
        int row = sc.nextInt();
        System.out.println("Enter the col : ");
        int col = sc.nextInt();
        return new Move(new Cell(row, col), this);
    }
}
