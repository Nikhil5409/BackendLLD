package TicTacToe;

public class Human extends Player{
    private int level;
    private int points;

    public Human(Integer id, String name, Symbol symbol, PlayerType playerType) {
        super(id, name, symbol, playerType);
        this.level = 1;
        this.points = 50;
    }
}
