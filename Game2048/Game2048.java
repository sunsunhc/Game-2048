public class Game2048 {

    //INSTANCES

    private  int[][] board;
    private  boolean hori; 
    private  int dir;


    //CONSTRUCTOR

    public Game2048(){
        board = new int[4][4];
        for(int r = 0; r < 4; r++){
            for(int c = 0; c < 4; c++){
                board[r][c] = 0;
            }
        }
        putNumber();
        putNumber();    
    }


    //METHODS

    //Return true when at least one grid adds up, add up all valid grids to direction
    public boolean addUp(){

        boolean canAdd = false;
        //Left
        if(hori && dir == -1){
            //loop through row by row
            for(int r = 0; r < 4; r++){
                for(int c = 0; c < 4; c++){


                    int curr = board[r][c];
                    if(curr != 0){
                        for(int check = c + 1; check < 4; check++){
                            int sum = curr + board[r][check];
                            //check if this one is not 0 and not curr
                            if(sum != curr && sum != curr * 2){
                                break;
                            }
                            //when valid for combine
                            if(sum == curr * 2){
                    
                                board[r][c] = sum;
                                board[r][check] = 0;
                                canAdd = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        //Right
        if(hori && dir == 1){
            //loop through row by row
            for(int r = 3; r >= 0; r--){
                for(int c = 3; c >= 0; c--){


                    int curr = board[r][c];
                    if(curr != 0){
                        for(int check = c - 1; check >= 0; check--){
                            int sum = curr + board[r][check];
    
                            //check if this one is not 0 and not curr
                            if(sum != curr && sum != curr * 2){
                                break;
                            }
                            //when valid for combine
                            if(sum == curr * 2){
                    
                                board[r][c] = sum;
                                board[r][check] = 0;
                                canAdd = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        //Up
        if(!hori && dir == -1){
            //loop through row by row
            for(int c = 0; c < 4; c++){
                for(int r = 0; r < 4; r++){


                    int curr = board[r][c];
                    if(curr != 0){
                        for(int check = r + 1; check < 4; check++){
                            int sum = curr + board[check][c];
    
                            //check if this one is not 0 and not curr
                            if(sum != curr && sum != curr * 2){
                                break;
                            }
                            //when valid for combine
                            if(sum == curr * 2){
                    
                                board[r][c] = sum;
                                board[check][c] = 0;
                                canAdd = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        //Down
        if(!hori && dir == 1){
            //loop through col by col
            for(int c = 3; c >= 0; c--){
                for(int r = 3; r >= 0; r--){


                    int curr = board[r][c];
                    if(curr != 0){
                        for(int check = r - 1; check >= 0; check--){
                            int sum = curr + board[check][c];
    
                            //check if this one is not 0 and not curr
                            if(sum != curr && sum != curr * 2){
                                break;
                            }
                            //when valid for combine
                            if(sum == curr * 2){
                    
                                board[r][c] = sum;
                                board[check][c] = 0;
                                canAdd = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return canAdd;
    }

    //Returns true when addUp(), or at least one grid pushed, pushes the numbers to direction, and generates a new number at an empty space
    public void push(){
        
        boolean canAdd = addUp();
        boolean canPush = false;
        //Left
        if(hori && dir == -1){
            for(int r = 0; r < 4; r++){
                for(int c = 1; c < 4; c++){

                    if(board[r][c] != 0){
                        for(int i = 0; i < c; i++){
                            if(board[r][i] == 0){
                                board[r][i] = board[r][c];
                                board[r][c] = 0;
                                if(i != c){
                                    canPush = true;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }

        //Right
        if(hori && dir == 1){
            for(int r = 3; r >= 0; r--){
                for(int c = 2; c >= 0; c--){

                    if(board[r][c] != 0){
                        for(int i = 3; i > c; i--){
                            if(board[r][i] == 0){
                                board[r][i] = board[r][c];
                                board[r][c] = 0;
                                if(i != c){
                                    canPush = true;
                                }
                                break;
                            }
                        }
                    }
                    
                }
            }
        }

        //Up
        if(!hori && dir == -1){
            for(int c = 0; c < 4; c++){
                for(int r = 1; r < 4; r++){

                    if(board[r][c] != 0){
                        for(int i = 0; i < r; i++){
                            if(board[i][c] == 0){
                                board[i][c] = board[r][c];
                                board[r][c] = 0;
                                if(i != r){
                                    canPush = true;
                                }
                                break;
                            }
                        }
                    }
                    
                }

            }
        }

        //Down
        if(!hori && dir == 1){
            for(int c = 3; c >= 0; c--){
                for(int r = 2; r >= 0; r--){

                    if (board[r][c] != 0){
                        for(int i = 3; i > r; i--){
                            if(board[i][c] == 0){
                                board[i][c] = board[r][c];
                                board[r][c] = 0;
                                if(i != r){
                                    canPush = true;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        //When something add up, or grid moved, genarate a new number and return true
        if(canAdd || canPush){
            putNumber();
        }
    }

    //Returns true when input is WASD, set the direction from input
    public void SetDirection(String input){
        if(input.equals("d") ||input.equals("D")){
            hori = true;
            dir = 1;
        }else if(input.equals("a") ||input.equals("A")){
            hori = true;
            dir = -1;
        }else if(input.equals("s") ||input.equals("S")){
            hori = false;
            dir = 1;
        }else if(input.equals("w") ||input.equals("W")){
            hori = false;
            dir = -1;
        }
    }
    
    //Generate a number at an empty space on the borad, chance of generating a 2 is 90%, 4 is 10%
    public void putNumber(){

        //Generate empty coordinates
        int row; 
        int col; 
        do{
            row = (int)(Math.random() * 4);
            col = (int)(Math.random() * 4); 
        }while(board[row][col] != 0);

        //Generate 2 or 4
        if((int)(Math.random() * 10) == 0){
            board[row][col] = 4;
        }else{
            board[row][col] = 2;
        }
    }

    //Print the Board
    public void printBoard(){
        for(int r = 0; r < 4; r++){
            for(int c = 0; c < 4; c++){
                System.out.print(board[r][c] + ", ");
            }
            System.out.print("\n");
        }
    }

    //Returns true there is a 2048 grid
    public boolean win(){
        for(int[] row : board){
            for(int curr : row){
                if(curr == 2048){
                    return true;
                }
            }
        }
        return false;
    }

    //Returns true when every grid is filled, and no grid has same number surrounding
    public boolean loose(){

        //loops all grids
        for(int r = 0; r < 4; r++){
            for(int c = 0; c < 4; c++){
                
                if(board[r][c] == 0){
                    return false;
                }
                if(r - 1 >= 0 && board[r - 1][c] == board[r][c]){
                    return false;
                }
                if(r + 1 < 4 && board[r + 1][c] == board[r][c]){
                    return false;
                }
                if(c - 1 >= 0 && board[r][c - 1] == board[r][c]){
                    return false;
                }
                if(c + 1 < 4 && board[r][c + 1] == board[r][c]){
                    return false;
                }

            }
        }
        return true;
    }

    //Returns an integer in board ar position r, c
    public int getV(int r, int c){
        return board[r][c];
    }

    //Set the integer at r, c in the board to set
    public void setV(int r, int c, int set){
        board[r][c] = set;
    }
}
