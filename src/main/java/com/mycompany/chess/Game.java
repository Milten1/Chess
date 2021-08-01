
package com.mycompany.chess;
import java.util.Scanner;


public class Game {
    private Board board;
    private Logic logic;
    private Scanner scanner;
    private int aiLevel;

    public Game() {
        this.board = new Board();
        this.scanner = new Scanner(System.in);
    }
             
    public void start(){
        
        System.out.println("Do you want to play with AI? (y/n)");
        String command = scanner.next();
        
        if(command.equals("y")){
            System.out.println("Choose AI level \n"
                    + "1. random moves \n"
                    + "2. very easy \n"
                    + "3. easy \n"
                    + "4. medium \n"
                    + "5. hard \n"
                    + "6. very hard \n");
            
            aiLevel = scanner.nextInt();
            
            this.logic = new Logic(aiLevel);
        } else if(command.equals("n")) this.logic = new Logic(-1);
        
        board.printBoard();
        
        while(true){
            
            if(logic.getPlayer().equals("Black") && aiLevel > 0) {
                commands("a1-a2");
                continue;
            }
            
            if(logic.getIsEnd()) break;
            
            System.out.print("> ");
            command = scanner.next();
            command = command.toLowerCase();
            if(command.equals("exit")) break;
            
            commands(command);
            
        }
        
        System.out.println("Game is over");
        
        System.out.println("Do you want to play again? (y/n)");
        command = scanner.next();
        if(command.equals("y")) newGame();
        
    }
    
    public void newGame(){
        board.initializeBoard();
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
                if(command.toLowerCase().matches("[a-z][1-9]-[a-z][1-9]")){
                    board.setBoard(logic.move(command));
                    
                    System.out.println("Move of player: " + logic.getPlayer());
                } else System.out.println("Invalid command");
            }
        }
        
        
    }
}
