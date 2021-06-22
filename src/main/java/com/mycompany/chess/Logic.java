
package com.mycompany.chess;

import Pieces.*;


public class Logic {
    private Pieces[][] logicBoard;
    private Board board;
    private String player;
    private String enemy;
    private boolean changePlayer;
    
    public Logic() {
        this.board = new Board();
        this.logicBoard = board.getBoard();
        this.changePlayer = false;
        this.player = "White";
        this.enemy = "Black";
    }
    
    public Pieces[][] move(String command){
        changePlayer = false;
        
        int[] coordinates = convertCommandToCoordinates(command);
        logicBoard = board.getBoard();
        Pieces piece = logicBoard[coordinates[0]][coordinates[1]];

     System.out.println(piece.getClass().getSuperclass().getSimpleName()); //test
        
        
        if(piece.isMoveValid(coordinates, this.logicBoard, this.enemy, this.player) && (piece.getClass().getSuperclass().getSimpleName().equals(player))){
            if(piece.getClass().getSimpleName().equals("WhitePawn") || piece.getClass().getSimpleName().equals("BlackPawn")) piece.beenMoved();
            
            logicBoard[coordinates[0]][coordinates[1]] = new Empty();
            logicBoard[coordinates[2]][coordinates[3]] = piece;
            board.printBoard();
            changePlayer = true;
        }else System.out.println("Move invalid");
        
        
        return logicBoard;
    }
    
    public boolean isEndOfTheGame(){
        return false;
    }
    
    public boolean getChangePlayer(){
        return this.changePlayer;
    }
    
    public void changePlayer(){
        if(player.equals("White")) player = "Black";
        else player = "White";
        
        if(enemy.equals("Black")) enemy = "White";
        else enemy = "Black";
    }
    
    public int[] convertCommandToCoordinates(String command){
        
        
        //coordinates format example; a3-d4
        
        String[] commands = command.split("-");
        
        String[] cmd1 = commands[0].split("");
        String[] cmd2 = commands[1].split("");


        int[] coordinates = new int[4];
        
        coordinates[1] = letterToNumber(cmd1[0])-1;
        coordinates[0] = Integer.valueOf(cmd1[1])-1;
        coordinates[3] = letterToNumber(cmd2[0])-1;
        coordinates[2] = Integer.valueOf(cmd2[1])-1;
        
        
        return coordinates;
    }
    
    public int letterToNumber(String letter){
        switch(letter){
            case "a": return 1;
            case "b": return 2;
            case "c": return 3;
            case "d": return 4;
            case "e": return 5;
            case "f": return 6;
            case "g": return 7;
            case "h": return 8;
        }
        return 0;
    }
    

    public void saveGame(String name) {
        
    }

    public void loadGame(String name) {
        
    }

    public String getPlayer() {
        return player;
    }
    
    public String getEnemy(){
        return enemy;
    }
    
    public Pieces[][] getLogicBoard(){
        return this.logicBoard;
    }
}
