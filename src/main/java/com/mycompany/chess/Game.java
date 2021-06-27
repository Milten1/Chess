
package com.mycompany.chess;
import java.util.Scanner;


public class Game {
    private Board board;
    private Logic logic;
    private Scanner scanner;

    public Game() {
        this.board = new Board();
        this.logic = new Logic();
        this.scanner = new Scanner(System.in);
    }
             
    public void start(){
        
        board.printBoard();
        
        while(true){
            
            if(logic.getIsEnd()) break;
            
            System.out.print("> ");
            String command = scanner.next();
            command = command.toLowerCase();
            if(command.equals("exit")) break;
            
            commands(command);
            
        }
        
        System.out.println("Game is over");
        
        System.out.println("Do you want to play again? (y/n)");
        String command = scanner.next();
        if(command.equals("y")) newGame();
        
    }
    
    public void newGame(){
        board.initializeBoard();
        this.logic = new Logic();
        start();
    }
    
    public void commands(String command){
        
        switch(command){
            case "help":{
                System.out.println("Commands: \n"
                                 + "help - shows all commands \n"
                                 + "print - prints the board \n"
                                 + "rules - shows rules of the game \n"
                                 + "exit - ends the game \n"
                                 + "save - saves the game \n"
                                 + "load - loads the game \n");
                break;
            }
            case "rules":{
                System.out.println("rules");
                break;
            }
            case "print":{
                board.printBoard();
                break;
            }
            case "empty":{
                board.printEmptyBoard(); //for tests
                break;
            }
            case "save":{
                System.out.print("Enter name for save: ");
                String name = scanner.next();
                logic.saveGame(name);
                break;
            }
            case "load":{
                System.out.print("Enter name of the saved game: ");
                String name = scanner.next();
                logic.loadGame(name);
                break;
            }
            default: {
                board.setBoard(logic.move(command));
                
//                if(logic.getChangePlayer() == true) logic.changePlayer();
                
                System.out.println("Move of player: " + logic.getPlayer());
            }
        }
        
        
    }
}
