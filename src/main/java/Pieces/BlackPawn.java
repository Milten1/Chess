
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
        
        
        if(!hasBeenMoved){
            if((coordinates[1] == coordinates[3]) && (Math.abs(coordinates[2]-coordinates[0]) == 1) || ((coordinates[1] == coordinates[3]) && 
                    (Math.abs(coordinates[2]-coordinates[0]) == 2)) && board[coordinates[2]][coordinates[3]].getClass().getSimpleName().equals("Empty")) return true;
        }
        
        if((coordinates[1] == coordinates[3]) && (coordinates[2]-coordinates[0] == 1) && (coordinates[0]>coordinates[2])  && board[coordinates[2]][coordinates[3]].getClass().getSimpleName().equals("Empty")) return true;
        
        if((Math.abs(coordinates[0] - coordinates[2]) == 1 && Math.abs(coordinates[1] - coordinates[3]) == 1) &&
                board[coordinates[2]][coordinates[3]].getClass().getSuperclass().getSimpleName().equals(enemy)) return true;
        
        return false;
    }
    
    @Override
    public void beenMoved(){
        this.hasBeenMoved = true;
    }
    
}
