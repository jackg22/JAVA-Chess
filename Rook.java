import java.util.*;

public class Rook implements Piece{

    private String tag ="";

    private String type;

    boolean color;

    boolean aliveOrDead;

    boardSpace spaceOn;

    public Rook(){
        color = true;
        aliveOrDead = true;
        spaceOn = new boardSpace();
        type = "rook";
    }

    public String toString(){
        String c = "";
        if(color){
            c="white";
        }

        else{
            c="black";
        }
        c+=" "+type;
        c+="\n Row Index: "+this.getRowI();
        c+="\n Col Index: "+this.getColI();
        return c;
    }

    public String getType(){
        return this.type;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String a) {
        this.tag=a;
    }

    public boolean getColor(){
        return this.color;
    }

    public void setBoardSpace(boardSpace a){
        spaceOn =a;
    }

    public void setBlack(){
        this.color = false;
    }

    public void setWhite(){
        this.color=true;
    }

    public boardSpace getBoardSpace(){
        return spaceOn;
    }

    public int getRowI(){
        return spaceOn.getRowI();
    }
    public int getRow(){
        return -1;
    }
    public String getRowS(){
        return spaceOn.getRowS();
    }

    public int getCol(){
        return -1;
    }



    public int getColI(){
        return spaceOn.getColI();
    }

    public String getColS(){
        return spaceOn.getColS();
    }

    public void takePiece(Board a, Piece b, boolean co){
        a.removePiece(b,co);
    }


    public boolean canMove(Board a, String h){
        h = h.toLowerCase();
        String compLet = h.substring(0,1);
        boardSpace[][] arr = a.get2DArray();
        int rowOn = this.getRowI();
        int colOn = this.getColI();
        String let = "abcdefghq";
        String num = "87654321";
        int moveRow = -1;
        int moveCol = -1;
        for(int i =0; i<=7; i++){
                if (num.substring(i, i + 1).equals(h.substring(1))) {
                    moveRow = i;
                }

        }

        if(compLet.equals("a")){
            moveCol = 0;
        }

        else if(compLet.equals("b")){
            moveCol = 1;
        }

        else if(compLet.equals("d")){
            moveCol=3;
        }
        else if(compLet.equals("c")){
            moveCol = 2;
        }
        else if(compLet.equals("e")){
            moveCol=4;
        }
        else if(compLet.equals("f")){
            moveCol = 5;
        }
        else if(compLet.equals("g")){
            moveCol = 6;
        }
        else if(compLet.equals("h")){
            moveCol=7;
        }

        //line below makes sure space entered was valid
        if(moveRow!=-1&&moveCol!=-1){
            if(moveCol==colOn||moveRow==rowOn){
                if(arr[moveRow][moveCol].isEmpty()){
                    System.out.println("IS EMPTY: "+arr[moveRow][moveCol].isEmpty());
                    boolean checkInBetween = true;
                    if(moveRow==rowOn){
                        //moving horizontally not taking piece
                        if(moveCol<colOn){
                            //moving left
                            for(int i = moveCol+1;i<colOn;i++){
                                if(!(arr[rowOn][i].isEmpty())){
                                    checkInBetween = false;
                                }
                            }
                            return checkInBetween;
                        }



                        else{
                            //moving right
                            for(int i = colOn+1; i<moveCol; i++){
                                if(!(arr[rowOn][i].isEmpty())){
                                    checkInBetween = false;
                                }
                            }
                            return checkInBetween;
                        }
                    }

                    else if(moveCol==colOn){
                        //moving vertically not taking piece
                        if(moveRow<rowOn){
                            for(int i = moveRow+1;i<rowOn;i++){
                                if(!(arr[i][colOn].isEmpty())){
                                    checkInBetween = false;
                                }
                            }
                            return checkInBetween;
                        }

                        else{
                            for(int i =rowOn+1;i<moveRow;i++){
                                if(!(arr[i][colOn].isEmpty())){
                                    checkInBetween = false;
                                }
                            }
                            return checkInBetween;
                        }
                    }
                }

                else{
                    //TAKING PIECE
                    ArrayList<Piece> g = a.getPieceList();
                    boolean compareTo = true;
                    int removeInd = -1;
                    for(int i = 0; i<g.size();i++){
                        if(g.get(i).getColI()==moveCol&&g.get(i).getRowI()==moveRow){
                            compareTo = g.get(i).getColor();
                            removeInd = i;
                        }
                    }
                    if(this.getColor()!=compareTo){
                        boolean checkInBetween = true;
                        if(moveRow==rowOn){
                            //moving horizontally taking piece
                            if(moveCol<colOn){
                                //moving left
                                for(int i = moveCol+1;i<colOn;i++){
                                    if(!(arr[rowOn][i].isEmpty())){
                                        checkInBetween = false;
                                    }
                                }
                                if(checkInBetween){
                                    this.takePiece(a,g.get(removeInd),this.getColor());
                                }
                                return checkInBetween;
                            }
                            else{
                                //moving right
                                for(int i = colOn+1; i<moveCol; i++){
                                    if(!(arr[rowOn][i].isEmpty())){
                                        checkInBetween = false;
                                    }
                                }
                                if(checkInBetween){
                                    this.takePiece(a,g.get(removeInd),this.getColor());
                                }
                                return checkInBetween;
                            }
                        }

                        else if(moveCol==colOn){
                            //moving vertically taking piece
                            if(moveRow<rowOn){
                                for(int i = moveRow+1;i<rowOn;i++){
                                    if(!(arr[i][colOn].isEmpty())){
                                        checkInBetween = false;
                                    }
                                }
                                if(checkInBetween){
                                    this.takePiece(a, g.get(removeInd),this.getColor());
                                }
                                return checkInBetween;
                            }

                            else{
                                for(int i =rowOn+1;i<moveRow;i++){
                                    if(!(arr[i][colOn].isEmpty())){
                                        checkInBetween = false;
                                    }
                                }
                                if(checkInBetween){
                                    this.takePiece(a, g.get(removeInd),this.getColor());
                                }
                                return checkInBetween;
                            }
                        }

                    }

                    else{
                        return false;
                    }


                }
            }

        }
        return false;
    }


    public void move(Board a, gameSpace g){
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int breakOut =-1;
        int c1;
        int r1;
        int setRowE = this.getRowI();
        int setColE = this.getColI();
        while(i==0){
            System.out.println("What space do you want to move this piece to? (\"esc\" to go back)");
            System.out.println(this);
            int rep=0;
            String moveTo="";
            while(rep == 0) {
                moveTo = scan.nextLine();
                moveTo=moveTo.toLowerCase();
                String f = moveTo.substring(0,1);
                String s = moveTo.substring(1);
                if((f.equals("a")||f.equals("b")||f.equals("c")||f.equals("d")||f.equals("e")||f.equals("f")||f.equals("g")||f.equals("h"))&&(s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4")||s.equals("5")||s.equals("6")||s.equals("7")||s.equals("8"))) {
                    rep++;
                }
                else if(moveTo.equals("esc")){//
                    g.setMsg1();//
                    rep++; //
                    breakOut++;//
                }
                else {
                    System.out.println("Invalid Space Entered.\nPlease enter another space.");
                }
            }
            String let = "abcdefghq";
            String num = "87654321";
            r1 = -1;
            c1 = -1;

            if(breakOut==-1&&this.canMove(a, moveTo)){
                for(int l =0; l<=7; l++){

                    if(let.substring(l,l+1).equals(moveTo.substring(0,1))){
                        c1 = l;
                    }

                    if(num.substring(l,l+1).equals(moveTo.substring(1))){
                        r1= l;
                    }

                }
                for(int d = 0; d<a.getPieceList().size();d++){
                    if(a.getPieceList().get(d).equals(this)){
                        a.getPieceList().get(d).setBoardSpace(a.get2DArray()[r1][c1]);
                    }
                }
                this.setTag(moveTo.toUpperCase());
                a.get2DArray()[setRowE][setColE].toggleEmpty();
                if(a.get2DArray()[r1][c1].isEmpty()){
                    a.get2DArray()[r1][c1].toggleEmpty();
                }



                i++;
            }

            else{
                if(breakOut==-1){//
                    System.out.println("This piece cannot move there or invalid space entered.");
                    System.out.println("Enter another space.");
                }
                else{
                    i++;//
                }
            }


        }
    }

}