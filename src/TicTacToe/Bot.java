package TicTacToe;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(Integer id, String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }
    public Move makeMove(){
        return null;
    }
}
