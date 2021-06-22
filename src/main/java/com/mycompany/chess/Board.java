
package com.mycompany.chess;

import Pieces.*;

public class Board {
    private Pieces[][] board;

    public Board() {
        board = new Pieces[8][8];
        
        initializeBoard();
    }
    
    public void initializeBoard(){
        for(int i = 2; i < 6; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new Empty();
            }
        }
        
        for(int i = 1; i < 2; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new WhitePawn();
            }
        }
        
        for(int i = 6; i < 7; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new BlackPawn();
            }
        }
        
        board[0][0] = new WhiteRook();
        board[0][7] = new WhiteRook();
        board[0][1] = new WhiteKnight();
        board[0][6] = new WhiteKnight();
        board[0][2] = new WhiteBishop();
        board[0][5] = new WhiteBishop();
        board[0][3] = new WhiteQueen();
        board[0][4] = new WhiteKing();
        
        board[7][0] = new BlackRook();
        board[7][7] = new BlackRook();
        board[7][1] = new BlackKnight();
        board[7][6] = new BlackKnight();
        board[7][2] = new BlackBishop();
        board[7][5] = new BlackBishop();
        board[7][3] = new BlackQueen();
        board[7][4] = new BlackKing();
    }
    
    
    public void printBoard(){
        System.out.print("  ");
        for(char ch = 'A'; ch <= 'H'; ch++ ){
            System.out.print(" " + ch + " ");
        }
        
        System.out.println();
         for(int i = 7; i >= 0; i--){
             System.out.print(i+1 + " ");
            for(int j = 0; j < 8; j++){
                System.out.print("[" + board[i][j] + "]");
            }
             System.out.println();
        }
    }

    public Pieces[][] getBoard() {
        return board;
    }

    public void setBoard(Pieces[][] board) {
        this.board = board;
    }
    
    public void printEmptyBoard(){//for tests
        System.out.print("  ");
        for(char ch = 'A'; ch <= 'H'; ch++ ){
            System.out.print(" " + ch + "  ");
        }
        
        System.out.println();
         for(int i = 7; i >= 0; i--){
             System.out.print(i+1 + " ");
            for(int j = 0; j < 8; j++){
                System.out.print("[" + i + "" + j + "]");
            }
             System.out.println();
        }
    }
    
}
