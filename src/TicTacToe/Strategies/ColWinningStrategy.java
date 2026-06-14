package TicTacToe.Strategies;

import TicTacToe.Board;
import TicTacToe.Move;

import java.util.HashMap;

public class ColWinningStrategy implements WinningStrategy{
    private static HashMap<Integer, HashMap<String, Integer>> colCount = new HashMap<>();
    public boolean checkWinner(Board board, Move move){
        int col = move.getCell().getCol();
        String symbol = move.getPlayer().getSymbol().getSymbol();

        if(!colCount.containsKey(col)){
            colCount.put(col, new HashMap<>());
        }
        if(!colCount.get(col).containsKey(symbol)){
            colCount.get(col).put(symbol, 0);
        }

        colCount.get(col).put(symbol, colCount.get(col).get(symbol)+1);
        return colCount.get(col).get(symbol)==board.getSize();
    }
}
