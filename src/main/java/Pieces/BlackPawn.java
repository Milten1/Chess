
package Pieces;

public class BlackPawn extends Black{
    private boolean hasBeenMoved;

    public BlackPawn() {
        this.piece = '♟';
        this.hasBeenMoved = false;
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        
        if(coordinates[0] == coordinates[2] && coordinates[1] == coordinates[3]) return false;
        if(!(board[coordinates[2]][coordinates[3]].getClass().getSuperclass().getSimpleName().equals(enemy) ||
                board[coordinates[2]][coordinates[3]].getClass().getSimpleName().equals("Empty"))) return false;
        
        
//        Pieces[][] tempBoard = board;
//        
//        
//        Pieces piece = tempBoard[coordinates[0]][coordinates[1]];
//        
//        
//        Pieces helper = tempBoard[coordinates[2]][coordinates[3]];
//        tempBoard[coordinates[0]][coordinates[1]] = new Empty();
//        tempBoard[coordinates[2]][coordinates[3]] = piece;
//        
//        for(int i = 0; i < 8; i++){
//                for(int j = 0; j < 8; j++){
//                    if(tempBoard[i][j].getClass().getSuperclass().getSimpleName().equals(player) && tempBoard[i][j].getClass().getSimpleName().equals("BlackKing")){
//                        
//                        int[] coor1 = new int[4];
//                        
//                        coor1[2] = i;
//                        coor1[3] = j;
//                        
//                        for(int x = 0; x < 8; x++){
//                            for(int y = 0; y < 8; y++){
//                                coor1[0] = x;
//                                coor1[1] = y;
//                                
//                                
//                                if(tempBoard[x][y].getClass().getSuperclass().getSimpleName().equals(enemy)){
//                                    if(tempBoard[x][y].isMoveValid(coor1, tempBoard, player, enemy)){
//                                        
//                                        tempBoard[coordinates[0]][coordinates[1]] = piece;
//                                        tempBoard[coordinates[2]][coordinates[3]] = helper;
//                                        
//                                        return false;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
        
        if(!hasBeenMoved){
            if((coordinates[1] == coordinates[3]) && (Math.abs(coordinates[2]-coordinates[0]) == 1) || ((coordinates[1] == coordinates[3]) && 
                    (Math.abs(coordinates[2]-coordinates[0]) == 2)) && board[coordinates[2]][coordinates[3]].getClass().getSimpleName().equals("Empty")) return true;
        }
        
        if((coordinates[1] == coordinates[3]) && (coordinates[2]-coordinates[0] == 1) && board[coordinates[2]][coordinates[3]].getClass().getSimpleName().equals("Empty")) return true;
        
        if((Math.abs(coordinates[0] - coordinates[2]) == 1 && Math.abs(coordinates[1] - coordinates[3]) == 1) &&
                board[coordinates[2]][coordinates[3]].getClass().getSuperclass().getSimpleName().equals(enemy)) return true;
        
        return false;
    }
    
    @Override
    public void beenMoved(){
        this.hasBeenMoved = true;
    }
    
}
