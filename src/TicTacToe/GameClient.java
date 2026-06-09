package TicTacToe;

public class GameClient {
    public static void main(String[] args) {
        //This is where game flow starts

        // 1) we need a board, list<players>, list<winningstrategies>
        // 2) once we get above details, we can create Game object : Start the game
        // 3) keep on playing the game untill the game is IN_PROGRESS
        //      3.1) Display the board
        //      3.2) makeMove() :  we will also check the winner after each move and update game state
        // 4) check the winner/draw and announce the ressult

        // now for all of the above flow, we need to create the objects of our class
        // but, we dont want this client to direct access and create all objescts, will create intermediate way called  game controller

        GameController gameController = new GameController();
        // Here, since one object of game controller is enough for all games, we can implement singleton D.P
        //2)
        Game game = gameController.startGame();
        //3)
        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            //3.1)
            gameController.display(game);
            //3.2)
            gameController.makeMove(game);
        }
        //4)
        if(gameController.getGameState(game).equals(GameState.SUCCESS)){
            System.out.println("Winner is : "+ gameController.getWinner(game));
        }
        else if(gameController.getGameState(game).equals(GameState.DRAW)){
            System.out.println("Game is Draw !!");
        }

    }
}

//Game flow is set up, we need to focus on main thing which is makeMove() method
//Implementing make Move

//Human:
    //input from user
    //validate user input
    //update the board : mark the cell with symbol+state
    //update the turn
    //add moves into the list of moves
    //check winner/draw using selected strategies
        //assign the winner
        //change the state of game

//Bot:
    //some algorithm will suggest a move
    //rest all steps same as Human
    //update the board : mark the cell with symbol+state
    //update the turn
    //add moves into the list of moves
    //check winner/draw using selected strategies
    //assign the winner
    //change the state of game



