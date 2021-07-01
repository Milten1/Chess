
package Pieces;

public class WhiteRook extends White{
    private boolean hasBeenMoved;

    
    public WhiteRook() {
        this.piece = '♖';
        this.hasBeenMoved = false;
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        
        if(coordinates[0] == coordinates[2] && coordinates[1] == coordinates[3]) return false;
        if(!(board[coordinates[2]][coordinates[3]].getClass().getSuperclass().getSimpleName().equals(enemy) ||
                board[coordinates[2]][coordinates[3]].getClass().getSimpleName().equals("Empty"))) return false;
        
        
      Pieces piece = board[coordinates[0]][coordinates[1]];
        
        
        Pieces helper = board[coordinates[2]][coordinates[3]];
        board[coordinates[0]][coordinates[1]] = new Empty();
        board[coordinates[2]][coordinates[3]] = piece;
        
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
                                        
                                        board[coordinates[0]][coordinates[1]] = piece;
                                        board[coordinates[2]][coordinates[3]] = helper;
                                        
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        
        
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
            if(coordinates[0] < coordinates[2]){//UP
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
