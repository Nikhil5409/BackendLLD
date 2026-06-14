package TicTacToe.Strategies;

import TicTacToe.Board;
import TicTacToe.Move;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{
    private HashMap<String, HashMap<String, Integer>> diagCount = new HashMap<>();
    public boolean checkWinner(Board board, Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        String symbol = move.getPlayer().getSymbol().getSymbol();

        if(!diagCount.containsKey("left")){
            diagCount.put("left", new HashMap<>());
        }
        if(!diagCount.containsKey("right")){
            diagCount.put("right", new HashMap<>());
        }
        if(!diagCount.get("left").containsKey(symbol)){
            diagCount.get("left").put(symbol, 0);
        }
        if(!diagCount.get("right").containsKey(symbol)){
            diagCount.get("right").put(symbol, 0);
        }

        if(row==col){
            diagCount.get("left").put(symbol, diagCount.get("left").get(symbol)+1);
        }
        // want to implement right diagonal
        if(row + col == board.getSize() - 1){
            diagCount.get("right").put(
                    symbol,
                    diagCount.get("right").get(symbol) + 1
            );
        }

        return diagCount.get("left").get(symbol) == board.getSize() || diagCount.get("right").get(symbol) == board.getSize();
    }
}

