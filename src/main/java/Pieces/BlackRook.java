
package Pieces;

public class BlackRook extends Black{
    private boolean hasBeenMoved;

    
    public BlackRook() {
        this.piece = '♜';
        this.hasBeenMoved = false;
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        
        if(coordinates[0] == coordinates[2] && coordinates[1] == coordinates[3]) return false;
        
        
        if(coordinates[0] == coordinates[2]){
            if(coordinates[1] < coordinates[3]){//right
                for(int j = coordinates[1]+1; j <= coordinates[3];j++){
                    if(!((board[coordinates[0]][j].getClass().getSimpleName().equals("Empty")) || (board[coordinates[0]][j].getClass().getSuperclass().getSimpleName().equals(enemy)))) return false;
                }
                return true;
                
            }else{//left
                for(int j = coordinates[1]-1; j >= coordinates[3];j--){
                    if(!((board[coordinates[0]][j].getClass().getSimpleName().equals("Empty")) || (board[coordinates[0]][j].getClass().getSuperclass().getSimpleName().equals(enemy)))) return false;
                }
                return true;
            }
        }
        
        if(coordinates[1] == coordinates[3]){
            if(coordinates[0] < coordinates[2]){//up
                for(int i = coordinates[0]+1; i <= coordinates[2];i++){
                    if(!((board[i][coordinates[1]].getClass().getSimpleName().equals("Empty")) || (board[i][coordinates[1]].getClass().getSuperclass().getSimpleName().equals(enemy)))) return false;
                }
                return true;
            }else{//down
                for(int i = coordinates[0]-1; i >= coordinates[2];i--){
                    if(!((board[i][coordinates[1]].getClass().getSimpleName().equals("Empty")) || (board[i][coordinates[1]].getClass().getSuperclass().getSimpleName().equals(enemy)))) return false;
                }
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public void beenMoved() {
        this.hasBeenMoved = true;
    }
    
}
