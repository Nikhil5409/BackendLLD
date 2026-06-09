package TicTacToe;

import TicTacToe.Strategies.ColWinningStrategy;
import TicTacToe.Strategies.DiagonalWinningStrategy;
import TicTacToe.Strategies.WinningStrategy;
import TicTacToe.Strategies.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private static Scanner sc = new Scanner(System.in);
    public Game startGame(){
        //ask for dimension
        int dimension = getDimension();
        //ask for player details
        List<Player> players = getPlayers(dimension);
        //ask for winning strategies
        List<WinningStrategy> winningStrategies = getWinningStrategies();
        winningStrategies.add(new RowWinningStrategy());
        // create game object
        return new Game(dimension, players, winningStrategies);
    }
    public GameState getGameState(Game game){
        return game.getGameState();
        // one bad thing in this design is in out startGame() method we are returning back the actual game object, which is bad
        // we should not give away o expose our actual object, better is create a layer between it, or else gameClient can direct do all the things since it has actual object
    }
    public void display(Game game){
        //TODO:
        // gameController -> game.display() -> board.display() -> cell.display();
        game.display();
    }
    public void makeMove(Game game){
        //TODO:
        game.makeMove();

    }
    public String getWinner(Game game){
        //TODO
        return game.getWinner().getName();
    }
    private int getDimension(){
        System.out.println("Enter the size of board : ");
        int dimension = sc.nextInt();
        return dimension;
    }

    private List<Player> getPlayers(int dimension){
        System.out.println("Enter all the players : ");
        // we can modify this function to take bot as well
        List<Player> players = new ArrayList<>();
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        for(int i=0;i<dimension-1;i++){
            System.out.println("Add Player details : Name Symbol");
            String details = sc.nextLine();
            String[] detailsArray = details.split(" ");
            Player temp =  new Human(i, detailsArray[0], new Symbol(detailsArray[ 1]), PlayerType.HUMAN);
            players.add(temp);
        }
        return players;
    }
    private List<WinningStrategy> getWinningStrategies(){
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        System.out.println("Do you want Row winning Strategy ? Yes/No : ");
        String rowStrategy = sc.nextLine();
        System.out.println("Do you want Column winning Strategy ? Yes/No : ");
        String colStrategy = sc.nextLine();
        System.out.println("Do you want Diagonal winning Strategy ? Yes/No : ");
        String diagonalStrategy = sc.nextLine();
        if(rowStrategy.equals("Yes")){
            winningStrategies.add(new RowWinningStrategy());
        }
        if(colStrategy.equals("Yes")){
            winningStrategies.add(new ColWinningStrategy());
        }
        if(diagonalStrategy.equals("Yes")){
            winningStrategies.add(new DiagonalWinningStrategy());
        }
        return winningStrategies;
    }

}
