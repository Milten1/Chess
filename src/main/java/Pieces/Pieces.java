
package Pieces;

public abstract class Pieces {
    protected char piece;
    protected boolean hasBeenMoved;
    
    public abstract boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player);
    
    @Override
    public String toString() {
        return piece + "";
    }

    public abstract void beenMoved();

    public boolean hasBeenMoved() {
        return this.hasBeenMoved;
    }
    
}
