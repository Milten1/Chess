
package Pieces;

public class WhiteRook extends White{
    
    public WhiteRook() {
        this.piece = '♖';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        
        if(coordinates[0] == coordinates[2] && coordinates[1] == coordinates[3]) return false;
        
        
        if(coordinates[0] == coordinates[2]){
            if(coordinates[1] < coordinates[3]){//ruch w prawo
                System.out.println("right");
                for(int j = coordinates[1]+1; j <= coordinates[3];j++){
                    System.out.println(board[coordinates[0]][j].getClass().getSimpleName());
                    if(!((board[coordinates[0]][j].getClass().getSimpleName().equals("Empty")) || (board[coordinates[0]][j].getClass().getSuperclass().getSimpleName().equals(enemy)))) return false;
                }
                return true;
                
            }else{//ruch w lewo
                System.out.println("left");
                for(int j = coordinates[1]-1; j >= coordinates[3];j--){
                    System.out.println(board[coordinates[0]][j].getClass().getSimpleName());
                    if(!((board[coordinates[0]][j].getClass().getSimpleName().equals("Empty")) || (board[coordinates[0]][j].getClass().getSuperclass().getSimpleName().equals(enemy)))) return false;
                }
                return true;
            }
        }
        
        if(coordinates[1] == coordinates[3]){
            if(coordinates[0] < coordinates[2]){//ruch w górę
                System.out.println("up");
                for(int i = coordinates[0]+1; i <= coordinates[2];i++){
                    System.out.println(board[i][coordinates[1]].getClass().getSimpleName());
                    System.out.println(board[i][coordinates[1]].getClass().getSuperclass().getSimpleName());
                    if(!((board[i][coordinates[1]].getClass().getSimpleName().equals("Empty")) || (board[i][coordinates[1]].getClass().getSuperclass().getSimpleName().equals(enemy)))) return false;
                }
                return true;
            }else{//ruch w dół
                System.out.println("down");
                for(int i = coordinates[0]-1; i >= coordinates[2];i--){
                    System.out.println(board[i][coordinates[1]].getClass().getSimpleName());
                    if(!((board[i][coordinates[1]].getClass().getSimpleName().equals("Empty")) || (board[i][coordinates[1]].getClass().getSuperclass().getSimpleName().equals(enemy)))) return false;
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
