package TicTacToe;

import TicTacToe.Strategies.WinningStrategy;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gamestate;
    private Player winner;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private List<Move> moves;
}
