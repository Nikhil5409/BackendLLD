package TicTacToe;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    public Cell(int row, int col, Player player, CellState cellState) {
        this.row = row;
        this.col = col;
        this.player = player;
        this.cellState = cellState;
    }
    public void display(){
        if(cellState == CellState.EMPTY){
            System.out.print("|-|");
        }else{
            System.out.print("|"+player.getSymbol().getSymbol()+"|");
        }

    }
}
