import java.util.*;


public class Pawn implements Piece{
    private String tag = "";

    private String type;

    private boolean color;

    private boardSpace spaceOn;

    public Pawn(){
        color = true;
        spaceOn = new boardSpace();
        type = "pawn";
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

    public boolean getColor(){
        return this.color;
    }

    public void setBoardSpace(boardSpace a){
        spaceOn =a;
    }

    public void setWhite(){
        this.color=true;
    }

    public void setBlack(){
        this.color = false;
    }

    public String getTag() {
        return this.tag;
    }

    public boardSpace getBoardSpace(){
        return spaceOn;
    }

    public int getRowI(){
        return spaceOn.getRowI();
    }

    public int getCol(){
        return 1;//delete this method
    }
    public int getRow(){
        return -1;//delete
    }
    public String getRowS(){
        return spaceOn.getRowS();
    }


    public String getColS(){
        return spaceOn.getColS();
    }

    public int getColI(){
        return spaceOn.getColI();
    }

    public void setTag(String a) {
        this.tag=a;
    }

    public void takePiece(Board a, Piece b,boolean co){
        a.removePiece(b,co);
    }

    public void move(Board a, gameSpace g){
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int breakOut=-1;//
        int c1;
        int r1;
        int setRowE = this.getRowI();
        int setColE = this.getColI();
        while(i==0){
            System.out.println("What space do you want to move this piece to? (\"esc\" to go back)");//
            System.out.println(this);
            int rep=0;
            String moveTo ="";

            while(moveTo.length()== 0||rep==0){
                moveTo = scan.nextLine();
                moveTo=moveTo.toLowerCase();
                String f = moveTo.substring(0,1);
                String s = moveTo.substring(1);
                if((f.equals("a")||f.equals("b")||f.equals("A")||f.equals("B")||f.equals("C")||f.equals("D")||f.equals("E")||f.equals("F")||f.equals("G")||f.equals("H")||f.equals("c")||f.equals("d")||f.equals("e")||f.equals("f")||f.equals("g")||f.equals("h"))&&(s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4")||s.equals("5")||s.equals("6")||s.equals("7")||s.equals("8"))) {
                    rep++;
                }
                else if(moveTo.equals("esc")){//
                    g.setMsg1();//
                    rep++; //
                    breakOut++;//
                }

                else {
                    System.out.println("Invalid Space Entered.\nPlease enter another piece.");
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
        System.out.println(this);

    }




    public boolean canMove(Board a, String g){
        g=g.toLowerCase();
        String compLet = g.substring(0,1);
        boardSpace[][] arr = a.get2DArray();
        int rowOn = this.getRowI();
        int colOn = this.getColI();
        String let = "abcdefgh";
        String num = "87654321";
        int moveRow = -1;
        int moveCol = -1;
        for(int i =0; i<=7; i++){
            if(i!=rowOn||i!=colOn){
                if(num.substring(i,i+1).equals(g.substring(1))){
                    moveRow = i;
                }
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
            if(this.getColor()){
                //white pawns
                if(rowOn==6){
                    //if white pawn hasnt been moved
                    if(colOn==moveCol&&(moveRow==5||moveRow==4)){
                        if(moveRow==4){
                            //if it IS moving 2 spaces
                            if(arr[moveRow][colOn].isEmpty()&&arr[moveRow+1][colOn].isEmpty()){
                                System.out.println("PIECE ABLE TO MOVE");
                                return true;
                            }

                        }

                        else{
                            if(arr[moveRow][colOn].isEmpty()){
                                System.out.println("PIECE ABLE TO MOVE");
                                return true;
                            }

                        }
                    }
                }

                else{
                    if(colOn==moveCol){
                        if(moveRow==rowOn-1&&arr[moveRow][colOn].isEmpty()){
                            System.out.println("PIECE ABLE TO MOVE");
                            return true;
                        }
                    }

                    if(Math.abs(colOn-moveCol)==1&&moveRow==rowOn-1){
                        if(!(arr[moveRow][moveCol].isEmpty())){
                            String setTag = "";
                            for(int i =0; i<a.getPieceList().size();i++){
                                if(a.getPieceList().get(i).getColI()==moveCol&&a.getPieceList().get(i).getRowI()==moveRow){
                                    setTag = a.getPieceList().get(i).getTag();
                                    this.takePiece(a,a.getPieceList().get(i),this.getColor());
                                }
                            }

                            System.out.println("PIECE ABLE TO MOVE/TAKE");

                            return true;
                        }
                    }
                }
            }

            else{
                //black pawns
                if(rowOn==1){
                    //if black pawn hasnt been moved
                    if(colOn==moveCol&&(moveRow==2||moveRow==3)){
                        if(moveRow==3){
                            //if it IS moving 2 spaces
                            if(arr[moveRow][colOn].isEmpty()&&arr[moveRow-1][colOn].isEmpty()){
                                System.out.println("PIECE ABLE TO MOVE");
                                return true;
                            }

                        }

                        else{
                            if(arr[moveRow][colOn].isEmpty()){
                                System.out.println("PIECE ABLE TO MOVE");
                                return true;
                            }

                        }
                    }
                }

                else{
                    if(colOn==moveCol){
                        if(moveRow==rowOn+1&&arr[moveRow][colOn].isEmpty()){
                            System.out.println("PIECE ABLE TO MOVE");
                            return true;
                        }
                    }

                    if(Math.abs(colOn-moveCol)==1&&moveRow==rowOn+1){
                        if(!(arr[moveRow][moveCol].isEmpty())){
                            String setTag="";
                            for(int i =0; i<a.getPieceList().size();i++){
                                if(a.getPieceList().get(i).getColI()==moveCol&&a.getPieceList().get(i).getRowI()==moveRow){
                                    setTag = a.getPieceList().get(i).getTag();
                                    this.takePiece(a,a.getPieceList().get(i),this.getColor());
                                }
                            }

                            System.out.println("PIECE ABLE TO MOVE/TAKE");

                            return true;
                        }
                    }
                }
            }


        }

        System.out.println(a.get2DArray()[rowOn][colOn].isEmpty());
        return false;

    }

}





