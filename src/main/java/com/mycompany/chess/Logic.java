
package com.mycompany.chess;

import AI.*;
import Pieces.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;


public class Logic {
    private Pieces[][] logicBoard;
    private Board board;
    private String player;
    private String enemy;
    private boolean changePlayer;
    private boolean isEnd;
    private RandomMoves random;
    private int aiLevel;
    
    public Logic(int aiLevel) {
        this.board = new Board();
        this.logicBoard = board.getBoard();
        this.changePlayer = false;
        this.player = "White";
        this.enemy = "Black";
        this.isEnd = false;
        this.aiLevel = aiLevel;
        
        if(aiLevel >= 0){
            this.random = new RandomMoves();
        }
    }
    
    public Pieces[][] move(String command){
        changePlayer = false;
        
        logicBoard = board.getBoard();
        
        int[] coordinates = convertCommandToCoordinates(command);
        
        if(this.player.equals("Black") && this.aiLevel == 1) coordinates = random.nextRandomMove(logicBoard, enemy, player);
        
        Pieces piece = logicBoard[coordinates[0]][coordinates[1]];
        
        if((piece.getClass().getSimpleName().equals("WhiteKing") && piece.hasBeenMoved() == false && coordinates[2] == 0 && coordinates[3] == 6 && logicBoard[0][7].hasBeenMoved() == false) || 
              (piece.getClass().getSimpleName().equals("WhiteKing") && piece.hasBeenMoved() == false && coordinates[2] == 0 && coordinates[3] == 2 && logicBoard[0][0].hasBeenMoved() == false) || 
              (piece.getClass().getSimpleName().equals("BlackKing") && piece.hasBeenMoved() == false && coordinates[2] == 7 && coordinates[3] == 6 && logicBoard[7][7].hasBeenMoved() == false  ||
              (piece.getClass().getSimpleName().equals("BlackKing") && piece.hasBeenMoved() == false && coordinates[2] == 7 && coordinates[3] == 2 && logicBoard[7][0].hasBeenMoved() == false))){
            
            if(isCastlingValid(logicBoard, coordinates) && (piece.getClass().getSuperclass().getSimpleName().equals(player))){
                
                if(piece.getClass().getSimpleName().equals("WhitePawn") || piece.getClass().getSimpleName().equals("BlackPawn")) piece.beenMoved();
                if(piece.getClass().getSimpleName().equals("WhiteKing") || piece.getClass().getSimpleName().equals("BlackKing")) piece.beenMoved();
                if(piece.getClass().getSimpleName().equals("WhiteRook") || piece.getClass().getSimpleName().equals("BlackRook")) piece.beenMoved();
                
                logicBoard[coordinates[0]][coordinates[1]] = new Empty();
                logicBoard[coordinates[2]][coordinates[3]] = piece;
                
                if(coordinates[2] == 0 && coordinates[3] == 6){
                    logicBoard[0][7] = new Empty();
                    logicBoard[0][5] = new WhiteRook();
                    logicBoard[0][5].beenMoved();
                }else if(coordinates[2] == 0 && coordinates[3] == 2){
                    logicBoard[0][0] = new Empty();
                    logicBoard[0][3] = new WhiteRook();
                    logicBoard[0][5].beenMoved();
                }else if(coordinates[2] == 7 && coordinates[3] == 6){
                    logicBoard[7][7] = new Empty();
                    logicBoard[7][5] = new BlackRook();
                    logicBoard[7][5].beenMoved();
                }else if(coordinates[2] == 7 && coordinates[3] == 2){
                    logicBoard[7][0] = new Empty();
                    logicBoard[7][3] = new BlackRook();
                    logicBoard[7][3].beenMoved();
                }
                
                board.printBoard();
                
                changePlayer = true;
            }else System.out.println("Move invalid");
            
            return logicBoard;
        }
        
        
        
        if(piece.isMoveValid(coordinates, this.logicBoard, this.enemy, this.player) && (piece.getClass().getSuperclass().getSimpleName().equals(player)) 
                 && notInCheckAfterMove(coordinates, this.logicBoard, this.enemy, this.player)
                )
        {
            if(piece.getClass().getSimpleName().equals("WhitePawn") || piece.getClass().getSimpleName().equals("BlackPawn")) piece.beenMoved();
            if(piece.getClass().getSimpleName().equals("WhiteKing") || piece.getClass().getSimpleName().equals("BlackKing")) piece.beenMoved();
            if(piece.getClass().getSimpleName().equals("WhiteRook") || piece.getClass().getSimpleName().equals("BlackRook")) piece.beenMoved();
            
            logicBoard[coordinates[0]][coordinates[1]] = new Empty();
            logicBoard[coordinates[2]][coordinates[3]] = piece;
            
            if((coordinates[2] == 7 && piece.getClass().getSimpleName().equals("WhitePawn")) || 
                    (coordinates[2] == 0 && piece.getClass().getSimpleName().equals("BlackPawn"))) logicBoard = pawnPromotiom(logicBoard, coordinates);
            
            
            board.printBoard();
            
            
            
            changePlayer = true;
        }else System.out.println("Move invalid");
        
        if(this.changePlayer) changePlayer();
        
      if(isInCheck(logicBoard, enemy, player)) System.out.println(this.player + " player is in check!");
        
        isCheckMate(this.logicBoard, this.enemy, this.player);
        isStaleMate(this.logicBoard, this.enemy, this.player);
        
        return logicBoard;
    }
    
    public void isCheckMate(Pieces[][] board, String enemy, String player){
        
        Pieces[][] tempBoard = board;
        
        if(isInCheck(tempBoard, enemy, player)) {
            
           //sprawdza wszystkie mozliwe ruchy i czy po wykonaniu ruchu nadal b??dzie szach, je??li tak  to jest szachmat i gra jest zako??czona
           
           this.isEnd = true;


           for(int i = 0; i < 8; i++){
               for(int j = 0; j < 8; j++){
                   if(tempBoard[i][j].getClass().getSuperclass().getSimpleName().equals(player)){
                       int[] coor1 = new int[4];
                        
                        coor1[2] = i;
                        coor1[3] = j;
                        
                        for(int x = 0; x < 8; x++){
                            for(int y = 0; y < 8; y++){
                                coor1[0] = x;
                                coor1[1] = y;
                                
                                if(notInCheckAfterMove(coor1, tempBoard, enemy, player))  {
                                    this.isEnd = false;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    
    public void isStaleMate(Pieces[][] board, String enemy, String player){
        
        Pieces[][] tempBoard = board;
        
        if(!isInCheck(tempBoard, enemy, player)) {
            
            this.isEnd = true;
            
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(tempBoard[i][j].getClass().getSuperclass().getSimpleName().equals(player)){
                        int[] coor1 = new int[4];
                        
                        coor1[2] = i;
                        coor1[3] = j;
                        
                        for(int x = 0; x < 8; x++){
                            for(int y = 0; y < 8; y++){
                                coor1[0] = x;
                                coor1[1] = y;
                                
                                if(tempBoard[x][y].isMoveValid(coor1, tempBoard, player, enemy)){
                                    this.isEnd = false;
                                }
                            }
                        }
                    }
                }
            }
        }
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
        name = name + ".txt";
        try{
            File save = new File(name);
            if (save.createNewFile()) {
                try {
                    FileWriter saver = new FileWriter(name);
                    
                    logicBoard = board.getBoard();
                    
                    for(int i = 0; i < 8; i++){
                        for(int j = 0; j < 8; j++){
                            saver.write(logicBoard[i][j].toString() + "\n");
                        }
                    }
                    
                    saver.close();
                } catch (IOException e) {
                    System.out.println("An error occurred");
                    e.printStackTrace();
                }
                
                System.out.println("Game saved in: " + save.getName());
            } else System.out.println("Save already exists");
            
        }catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void loadGame(String name) {
        name = name + ".txt";
        try(Scanner scan  = new Scanner(Paths.get(name))){
            logicBoard = board.getBoard();
            
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(scan.hasNextLine()){
                        String row = scan.nextLine();
                        
                        switch(row.charAt(0)){
                            case ' ':{
                                   logicBoard[i][j] = new Empty();
                                   break;
                            }
                            case '???':{
                                   logicBoard[i][j] = new WhitePawn();
                                   break;
                            }
                            case '???':{
                                   logicBoard[i][j] = new WhiteRook();
                                   break;
                            }
                            case '???':{
                                   logicBoard[i][j] = new WhiteKnight();
                                   break;
                            }
                            case '???':{
                                   logicBoard[i][j] = new WhiteBishop();
                                   break;
                            }
                            case '???':{
                                   logicBoard[i][j] = new WhiteQueen();
                                   break;
                            }
                            case '???':{
                                   logicBoard[i][j] = new WhiteKing();
                                   break;
                            }
                            case '???':{
                                   logicBoard[i][j] = new BlackPawn();
                                   break;
                            }
                            case '???':{
                                   logicBoard[i][j] = new BlackRook();
                                   break;
                            }
                            case '???':{
                                   logicBoard[i][j] = new BlackKnight();
                                   break;
                            }
                            case '???':{
                                   logicBoard[i][j] = new BlackBishop();
                                   break;
                            }
                            case '???':{
                                   logicBoard[i][j] = new BlackQueen();
                                   break;
                            }
                            case '???':{
                                   logicBoard[i][j] = new BlackKing();
                                   break;
                            }
                        }
                    }
                }
            }
            
            System.out.println("Game loaded");
            board.printBoard();
            
        }catch(Exception e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
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

    public Pieces[][] pawnPromotiom(Pieces[][] board, int[] coordinates) {
        System.out.println("Choose piece you want to promote pawn to: \n"
                + "1. Queen  \n"
                + "2. Rook   \n"
                + "3. Bishop \n"
                + "4. Knight");
        
        Scanner s = new Scanner(System.in);
        int choose = s.nextInt();
        
        switch(choose){
            case 1: {
                if(coordinates[2] == 7) board[coordinates[2]][coordinates[3]] = new WhiteQueen();
                else board[coordinates[2]][coordinates[3]] = new BlackQueen();
                break;
            }
            case 2: {
                if(coordinates[2] == 7) board[coordinates[2]][coordinates[3]] = new WhiteRook();
                else board[coordinates[2]][coordinates[3]] = new BlackRook();
                break;
            }
            case 3: {
                if(coordinates[2] == 7) board[coordinates[2]][coordinates[3]] = new WhiteBishop();
                else board[coordinates[2]][coordinates[3]] = new BlackBishop();
                break;
            }
            case 4: {
                if(coordinates[2] == 7) board[coordinates[2]][coordinates[3]] = new WhiteKnight();
                else board[coordinates[2]][coordinates[3]] = new BlackKnight();
                break;
            }
            
        }
        return board;
    }
    
    public boolean isCastlingValid(Pieces[][] board, int[] coordinates){
        
        Pieces piece = board[coordinates[0]][coordinates[1]];
       
        if((piece.getClass().getSimpleName().equals("WhiteKing")) && coordinates[2] == 0 && coordinates[3] == 6){//kr??tka roszada
            for(int i = coordinates[1]+1; i <= coordinates[3]; i++){
                if(!(board[0][i].getClass().getSimpleName().equals("Empty"))) return false;
            }
            
            int[] coor1 = new int[4];
            coor1[2] = 0;
            coor1[3] = 5;
            
            int[] coor2 = new int[4];
            coor2[2] = 0;
            coor2[3] = 6;
            
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    coor1[0] = i;
                    coor1[1] = j;
                    coor2[0] = i;
                    coor2[1] = j;
                    
                    if(board[i][j].getClass().getSuperclass().getSimpleName().equals(enemy)){
                        if(board[i][j].isMoveValid(coor1, board, enemy, player) || board[i][j].isMoveValid(coor2, board, enemy, player)) return false;
                    }
                }
            }
            
            return true;
            
        } else if(coordinates[2] == 0 && coordinates[3] == 2){ //d??uga
            for(int i = coordinates[1]-1; i >= coordinates[3]-1; i--){
                if(!(board[0][i].getClass().getSimpleName().equals("Empty"))) return false;
            }
            
            int[] coor1 = new int[4];
            coor1[2] = 0;
            coor1[3] = 2;
            
            int[] coor2 = new int[4];
            coor2[2] = 0;
            coor2[3] = 3;
            
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    coor1[0] = i;
                    coor1[1] = j;
                    coor2[0] = i;
                    coor2[1] = j;
                    
                    if(board[i][j].getClass().getSuperclass().getSimpleName().equals(enemy)){
                        if(board[i][j].isMoveValid(coor1, board, enemy, player) || board[i][j].isMoveValid(coor2, board, enemy, player)) return false;
                    }
                }
            }
            
            return true;
            
        }
        
        
        if((piece.getClass().getSimpleName().equals("BlackKing")) && coordinates[2] == 7 && coordinates[3] == 6){//kr??tka roszada
            for(int i = coordinates[1]+1; i <= coordinates[3]; i++){
                if(!(board[0][i].getClass().getSimpleName().equals("Empty"))) return false;
            }
            
            int[] coor1 = new int[4];
            coor1[2] = 7;
            coor1[3] = 5;
            
            int[] coor2 = new int[4];
            coor2[2] = 7;
            coor2[3] = 6;
            
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    coor1[0] = i;
                    coor1[1] = j;
                    coor2[0] = i;
                    coor2[1] = j;
                    
                    if(board[i][j].getClass().getSuperclass().getSimpleName().equals(enemy)){
                        if(board[i][j].isMoveValid(coor1, board, enemy, player) || board[i][j].isMoveValid(coor2, board, enemy, player)) return false;
                    }
                }
            }
            
            return true;
            
        } else if(coordinates[2] == 7 && coordinates[3] == 2){ //d??uga
            for(int i = coordinates[1]-1; i >= coordinates[3]-1; i--){
                if(!(board[0][i].getClass().getSimpleName().equals("Empty"))) return false;
            }
            
            int[] coor1 = new int[4];
            coor1[2] = 7;
            coor1[3] = 2;
            
            int[] coor2 = new int[4];
            coor2[2] = 7;
            coor2[3] = 3;
            
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    coor1[0] = i;
                    coor1[1] = j;
                    coor2[0] = i;
                    coor2[1] = j;
                    
                    if(board[i][j].getClass().getSuperclass().getSimpleName().equals(enemy)){
                        if(board[i][j].isMoveValid(coor1, board, enemy, player) || board[i][j].isMoveValid(coor2, board, enemy, player)) return false;
                    }
                }
            }
            
            return true;
            
        }
        return false;
        
    }
    
    public boolean isInCheck(Pieces[][] board, String enemy, String player){
        
        if(player.equals("White")){
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(board[i][j].getClass().getSuperclass().getSimpleName().equals(player) && board[i][j].getClass().getSimpleName().equals("WhiteKing")){
                        
                        int[] coor1 = new int[4];
                        
                        coor1[2] = i;
                        coor1[3] = j;
                        
                        for(int x = 0; x < 8; x++){
                            for(int y = 0; y < 8; y++){
                                coor1[0] = x;
                                coor1[1] = y;
                                
                                
                                if(board[x][y].getClass().getSuperclass().getSimpleName().equals(enemy)){
                                    if(board[x][y].isMoveValid(coor1, board, player, enemy)){
                                        System.out.println("[TEST] Checking move: " + i + "" + j + ", " + x + "" + y);
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        else if(player.equals("Black")){
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(board[i][j].getClass().getSuperclass().getSimpleName().equals(player) && board[i][j].getClass().getSimpleName().equals("BlackKing")){
                        
                        int[] coor1 = new int[4];
                        
                        coor1[2] = i;
                        coor1[3] = j;
                        
                        for(int x = 0; x < 8; x++){
                            for(int y = 0; y < 8; y++){
                                coor1[0] = x;
                                coor1[1] = y;
                                
                                
                                if(board[x][y].getClass().getSuperclass().getSimpleName().equals(enemy)){
                                    if(board[x][y].isMoveValid(coor1, board, player, enemy)){
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    
    public boolean notInCheckAfterMove(int[] coor, Pieces[][] board, String enemy, String player){
        
        Pieces[][] tempBoard = board;
        
        Pieces helper = tempBoard[coor[2]][coor[3]];
        Pieces piece = tempBoard[coor[0]][coor[1]];
        
        tempBoard[coor[0]][coor[1]] = new Empty();
        tempBoard[coor[2]][coor[3]] = piece;
        
        
        if(isInCheck(tempBoard, enemy, player)){
            
            tempBoard[coor[0]][coor[1]] = piece;
            tempBoard[coor[2]][coor[3]] = helper;
            
            return false;
        }
        
        return true;
    }
    
    public boolean getIsEnd(){
        return this.isEnd;
    }
}
