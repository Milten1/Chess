
package Pieces;

public class BlackKing extends Black{
    private boolean hasBeenMoved;

    
    public BlackKing() {
        this.piece = '♚';
        this.hasBeenMoved = false;
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        
        if(coordinates[0] == coordinates[2] && coordinates[1] == coordinates[3]) return false;
        if(!(board[coordinates[2]][coordinates[3]].getClass().getSuperclass().getSimpleName().equals(enemy) ||
                board[coordinates[2]][coordinates[3]].getClass().getSimpleName().equals("Empty"))) return false;
        
        
        return (Math.abs(coordinates[0] - coordinates[2]) < 2 && Math.abs(coordinates[1] - coordinates[3]) < 2) &&
                !(board[coordinates[2]][coordinates[3]].getClass().getSuperclass().getSimpleName().equals(player));
    }
    
    @Override
    public void beenMoved() {
        this.hasBeenMoved = true;
    }
    
}
