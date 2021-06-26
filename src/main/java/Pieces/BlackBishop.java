
package Pieces;


public class BlackBishop extends Black{

    public BlackBishop() {
        this.piece = '♝';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        
        if(coordinates[0] == coordinates[2] && coordinates[1] == coordinates[3]) return false;
        
        if(!(Math.abs(coordinates[0] - coordinates[2]) == Math.abs(coordinates[1] - coordinates[3]))) return false;
        
        if(coordinates[0] < coordinates[2]){
            if(coordinates[1] < coordinates[3]){//right-up
                for(int i = coordinates[0]+1; i <= coordinates[2]; i++){
                    for(int j = coordinates[1]+1; j <= coordinates[3]; j++){
                        if(!((board[i][j].getClass().getSimpleName().equals("Empty")) || (board[i][j].getClass().getSuperclass().getSimpleName().equals(enemy)))) return false;
                    }
                }
                return true;
                
            }else if(coordinates[1] > coordinates[3]){//left-up
                for(int i = coordinates[0]+1; i <= coordinates[2]; i++){
                    for(int j = coordinates[1]-1; j >= coordinates[3]; j--){
                        if(!((board[i][j].getClass().getSimpleName().equals("Empty")) || (board[i][j].getClass().getSuperclass().getSimpleName().equals(enemy)))) return false;
                    }
                }
                return true;
            }
        }
        
        if(coordinates[0] > coordinates[2]){
         if(coordinates[1] < coordinates[3]){//right-down
                for(int i = coordinates[0]-1; i >= coordinates[2]; i--){
                    for(int j = coordinates[1]+1; j <= coordinates[3]; j++){
                        if(!((board[i][j].getClass().getSimpleName().equals("Empty")) || (board[i][j].getClass().getSuperclass().getSimpleName().equals(enemy)))) return false;
                    }
                }
                return true;
                
            }else if (coordinates[1] > coordinates[3]){//left-down
                for(int i = coordinates[0]-1; i >= coordinates[2]; i--){
                    for(int j = coordinates[1]-1; j >= coordinates[3]; j--){
                        if(!((board[i][j].getClass().getSimpleName().equals("Empty")) || (board[i][j].getClass().getSuperclass().getSimpleName().equals(enemy)))) return false;
                    }
                }
                return true;
            }
        }
        
        return false;
    }

    @Override
    public void beenMoved() {
    }
    
}
