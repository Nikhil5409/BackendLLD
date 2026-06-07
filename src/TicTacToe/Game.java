package TicTacToe;

import TicTacToe.Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private Player winner;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private List<Move> moves;

    public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex =0;
        this.moves = new ArrayList<>();
        this.winner = null;
    }

    public void display(){
        board.display();
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}
