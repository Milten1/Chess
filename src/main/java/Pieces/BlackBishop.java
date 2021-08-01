
package Pieces;


public class BlackBishop extends Black{

    public BlackBishop() {
        this.piece = '♝';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        
        if(coordinates[0] == coordinates[2] && coordinates[1] == coordinates[3]) return false;
        if(!(board[coordinates[2]][coordinates[3]].getClass().getSuperclass().getSimpleName().equals(enemy) ||
                board[coordinates[2]][coordinates[3]].getClass().getSimpleName().equals("Empty"))) return false;
        
        
        if(!(Math.abs(coordinates[0] - coordinates[2]) == Math.abs(coordinates[1] - coordinates[3]))) return false;
        
        if(coordinates[0] < coordinates[2]){
            if(coordinates[1] < coordinates[3]){//right-up
                for(int i = coordinates[0]+1, j = coordinates[1]+1; i < coordinates[2] && j < coordinates[3]; i++, j++){
                        if(!((board[i][j].getClass().getSimpleName().equals("Empty")))) return false;
                    }
                return true;
                
            }else if(coordinates[1] > coordinates[3]){//left-up
                for(int i = coordinates[0]+1, j = coordinates[1]-1; i < coordinates[2] && j > coordinates[3]; i++, j--){
                        if(!((board[i][j].getClass().getSimpleName().equals("Empty")))) return false;
                    }
                
                return true;
            }
        }
        
        if(coordinates[0] > coordinates[2]){
         if(coordinates[1] < coordinates[3]){//right-down
             for(int i = coordinates[0]-1, j = coordinates[1]+1; i > coordinates[2] && j < coordinates[3]; i--, j++){
                        if(!((board[i][j].getClass().getSimpleName().equals("Empty")))) return false;
                    }
                
                return true;
                
            }else if (coordinates[1] > coordinates[3]){//left-down
                for(int i = coordinates[0]-1, j = coordinates[1]-1; i > coordinates[2] && j > coordinates[3]; i--, j--){
                        if(!((board[i][j].getClass().getSimpleName().equals("Empty")))) return false;
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
