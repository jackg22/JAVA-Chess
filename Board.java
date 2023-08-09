import java.util.*;

public class Board{
    private boardSpace[][] space;
    private ArrayList<Piece> pieceList;
    private boolean gameOver;
    public Board(){

        ArrayList<Piece> pieceList1 = new ArrayList<Piece>();
        String q = "ABCDEFGH";
        boardSpace[][] boardSpots = new boardSpace[8][8];
        for(int r = 0; r<8; r++){
            for(int c = 0; c<8; c++){
                String k = q.substring(c,c+1);
                boardSpots[r][c] = new boardSpace(k,8-r,true,c,r);
            }
        }

        for(int r = 0; r<8; r++){
            for(int c = 0; c<8; c++){
                if(r==0||r==1||r==6||r==7){
                    boardSpots[r][c].toggleEmpty();
                }
            }
        }

        for(int c = 0; c<8; c++){
            for(int r = 7; r>=0; r--){
                int count = 0;
                if(c%2==0){
                    for(int i = 0; i<8; i++){
                        if(i%2==1){
                            //sets black spots color
                            boardSpots[i][c].setColor(false);
                        }
                    }
                }

                if(c%2==1){
                    for(int i = 0; i<8; i++){
                        if(i%2==0){
                            boardSpots[i][c].setColor(false);
                        }
                    }
                }


            }
        }

        for(int c = 0; c<2;c++){
            if(c==1){
                for(int i = 0; i<2; i++){
                    //creates white pieces
                    for(int k = 0; k<8;k++){
                        String w = "abcdefgh";
                        String tagSet = w.substring(k,k+1);
                        tagSet=tagSet.toUpperCase();
                        if(i==0){
                            Piece a = new Pawn();
                            a.setBoardSpace(boardSpots[6][k]);
                            tagSet+="2";
                            a.setTag(tagSet);
                            //System.out.println(a);
                            pieceList1.add(a);
                        }

                        if(i==1){
                            if(k==0||k==7){
                                Piece a = new Rook();
                                a.setBoardSpace(boardSpots[7][k]);
                                tagSet+="1";
                                a.setTag(tagSet);
                                //System.out.println(a);
                                pieceList1.add(a);
                            }

                            if(k==1||k==6){
                                Piece a = new Knight();
                                a.setBoardSpace(boardSpots[7][k]);
                                tagSet+="1";
                                a.setTag(tagSet);
                                //System.out.println(a);
                                pieceList1.add(a);
                            }

                            if(k==2||k==5){
                                Piece a = new Bishop();
                                a.setBoardSpace(boardSpots[7][k]);
                                tagSet+="1";
                                a.setTag(tagSet);
                                //System.out.println(a);
                                pieceList1.add(a);
                            }
                            if(k==3){
                                Piece a = new Queen();
                                a.setBoardSpace(boardSpots[7][k]);
                                tagSet+="1";
                                a.setTag(tagSet);
                                //System.out.println(a);
                                pieceList1.add(a);
                            }

                            if(k==4){
                                Piece a = new King();
                                a.setBoardSpace(boardSpots[7][k]);
                                tagSet+="1";
                                a.setTag(tagSet);
                                //System.out.println(a);
                                pieceList1.add(a);
                            }
                        }
                    }
                }
            }

            if(c==0){

                for(int i = 0; i<2; i++){
                    /*******************
                     Sets all black pieces
                     ********************/
                    for(int k = 0; k<8; k++){

                        String w = "abcdefgh";
                        String tagSet = w.substring(k,k+1);
                        tagSet=tagSet.toUpperCase();
                        if(i==0){
                            Piece a = new Pawn();
                            a.setBlack();
                            a.setBoardSpace(boardSpots[1][k]);
                            tagSet+="7";
                            a.setTag(tagSet);
                            //System.out.println(a);
                            pieceList1.add(a);
                        }

                        if(i==1){
                            if(k==0||k==7){
                                Piece a = new Rook();
                                a.setBlack();
                                a.setBoardSpace(boardSpots[0][k]);
                                tagSet+="8";
                                a.setTag(tagSet);
                                //System.out.println(a);
                                pieceList1.add(a);
                            }

                            else if(k==1||k==6){
                                Piece a = new Knight();
                                a.setBlack();
                                a.setBoardSpace(boardSpots[0][k]);
                                tagSet+="8";
                                a.setTag(tagSet);
                                //System.out.println(a);
                                pieceList1.add(a);
                            }

                            else if(k==2||k==5){
                                Piece a = new Bishop();
                                a.setBlack();
                                a.setBoardSpace(boardSpots[0][k]);
                                tagSet+="8";
                                a.setTag(tagSet);
                                //System.out.println(a);
                                pieceList1.add(a);
                            }
                            else if(k==3){
                                Piece a = new Queen();
                                a.setBlack();
                                a.setBoardSpace(boardSpots[0][k]);
                                tagSet+="8";
                                a.setTag(tagSet);
                                //System.out.println(a);
                                pieceList1.add(a);
                            }

                            else if(k==4){
                                Piece a = new King();
                                a.setBlack();
                                a.setBoardSpace(boardSpots[0][k]);
                                tagSet+="8";
                                a.setTag(tagSet);
                                //System.out.println(a);
                                pieceList1.add(a);
                            }


                        }

                    }
                }
            }
        }

        pieceList = pieceList1;
        space = boardSpots;
        gameOver = false;

    }//end of constuctor

    public boardSpace[][] get2DArray(){
        return this.space;
    }

    public void setSpace(){

    }

    public void removePiece(int r, int c){
        for(int i=0;i<this.pieceList.size();i++){
            if(pieceList.get(i).getRowI()==r&&pieceList.get(i).getColI()==c){
                System.out.println("REMOVE PIECE METHOD: "+pieceList.get(i));
                this.pieceList.remove(i);
            }
        }
    }

    public void removePiece(Piece a, boolean co){
        for(int i =0;i<this.pieceList.size();i++){
            if(this.pieceList.get(i).equals(a)){
                this.pieceList.remove(i);
            }
        }
    }

    public ArrayList<Piece> getPieceList(){
        return this.pieceList;
    }


    public ArrayList<Piece> getPieces(){
        return this.pieceList;
    }

    public void printBoard(){
        System.out.println("   A  B  C  D  E  F  G  H");
        for(int r = 0; r<this.space.length; r++){
            String printStr = ""+(8-r);
            for(int i = 0; i<this.space[0].length;i++){
                if(this.space[r][i].isEmpty()){
                    printStr+=" x ";
                }
                else{
                    String addTo = "";
                    for(int m = 0; m<this.pieceList.size();m++){
                        if(space[r][i].equals(this.pieceList.get(m).getBoardSpace())){
                            if(this.pieceList.get(m).getColor()){
                                //prints white pieces on board
                                addTo += " W";

                                if(this.pieceList.get(m).getType().equals("knight")){
                                    addTo+="N";
                                }
                                if(this.pieceList.get(m).getType().equals("queen")){
                                    addTo+="Q";
                                }
                                if(this.pieceList.get(m).getType().equals("king")){
                                    addTo+="K";
                                }
                                if(this.pieceList.get(m).getType().equals("rook")){
                                    addTo+="R";
                                }
                                if(this.pieceList.get(m).getType().equals("bishop")){
                                    addTo+="B";
                                }
                                if(this.pieceList.get(m).getType().equals("pawn")){
                                    addTo+="P";
                                }

                                printStr+=addTo;
                            }

                            else{
                                addTo +=" B";
                                //prints black pieces on board
                                if(this.pieceList.get(m).getType().equals("pawn")){
                                    addTo+="P";
                                }
                                else if(this.pieceList.get(m).getType().equals("knight")){
                                    addTo+="N";
                                }
                                else if(this.pieceList.get(m).getType().equals("queen")){
                                    addTo+="Q";
                                }
                                else if(this.pieceList.get(m).getType().equals("king")){
                                    addTo+="K";
                                }
                                else if(this.pieceList.get(m).getType().equals("rook")){
                                    addTo+="R";
                                }
                                else if(this.pieceList.get(m).getType().equals("bishop")){
                                    addTo+="B";
                                }

                                printStr+=addTo;
                            }
                            m = pieceList.size();
                        }
                    }
                }

            }
            System.out.println(printStr);
        }
    }
}