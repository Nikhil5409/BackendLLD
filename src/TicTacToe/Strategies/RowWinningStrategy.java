package TicTacToe.Strategies;

import TicTacToe.Board;
import TicTacToe.Move;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{
    private HashMap<Integer, HashMap<String, Integer>> rowCount = new HashMap<>();
    public boolean checkWinner(Board board, Move move){
        int row = move.getCell().getRow();
        String symbol = move.getCell().getPlayer().getSymbol().getSymbol();

        if(!rowCount.containsKey(row)){
            rowCount.put(row, new HashMap<>());
        }
        if(!rowCount.get(row).containsKey(symbol)){
            rowCount.get(row).put(symbol, 0);
        }
        rowCount.get(row).put(symbol, rowCount.get(row).get(symbol)+1);
        return  rowCount.get(row).get(symbol) == board.getSize();
    }
}
