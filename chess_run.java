import java.util.*;

public class chess_run {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        gameSpace thisGame = new gameSpace();
        int checkMate = -1;
        int bk =-1;
        int wk=-1;


        while(checkMate == -1){
            bk=-1;
            wk=-1;
            for(int i =0; i<thisGame.getBoard().getPieces().size();i++){
                if(thisGame.getBoard().getPieces().get(i).getColor() &&thisGame.getBoard().getPieces().get(i).getType().equals("king")){
                    wk++;
                }
                if(!thisGame.getBoard().getPieces().get(i).getColor()&&thisGame.getBoard().getPieces().get(i).getType().equals("king")){
                    bk++;
                }
            }
            if(bk==-1||wk==-1){
                checkMate++;
                break;
            }

            thisGame.getBoard().printBoard();
            if(thisGame.getTurn()){
                int mm = -1;
                System.out.print("WHITE'S TURN: ");
                while(mm==-1){
                    System.out.println("WHAT PIECE DO YOU WANT TO MOVE?");
                    System.out.println("TURN: "+thisGame.getTurn());
                    String a = scan.nextLine();
                    a = a.toUpperCase();
                    ArrayList<Piece> moveTagList = thisGame.getBoard().getPieces();
                    for(int i =0; i<moveTagList.size();i++){
                        if((moveTagList.get(i).getTag()).equals(a)&&moveTagList.get(i).getColor()) {
                            thisGame.getBoard().getPieces().get(i).move(thisGame.getBoard(),thisGame);
                            mm++;
                        }
                    }
                    if(mm==0&&thisGame.getEscMsg()==1){
                        mm--;
                        thisGame.getBoard().printBoard();
                        thisGame.setMsg0();
                    }
                    else if(mm==-1){
                        System.out.println("No Piece on Space/Invalid Space.");
                    }
                }

                System.out.println("TOGGLING TURN");
                thisGame.toggleTurn();
            }
            else{
                int mm = -1;
                System.out.print("BLACK'S TURN: ");
                while(mm==-1){
                    System.out.println("WHAT PIECE DO YOU WANT TO MOVE?");
                    System.out.println("TURN: "+thisGame.getTurn());
                    String a = scan.nextLine();
                    a = a.toUpperCase();
                    ArrayList<Piece> moveTagList = thisGame.getBoard().getPieces();
                    for(int i =0; i<moveTagList.size();i++){
                        if((moveTagList.get(i).getTag()).equals(a)&&moveTagList.get(i).getColor()==false) {
                            thisGame.getBoard().getPieces().get(i).move(thisGame.getBoard(),thisGame);
                            mm++;
                        }
                    }
                    if(mm==0&&thisGame.getEscMsg()==1){
                        mm--;
                        thisGame.getBoard().printBoard();
                        thisGame.setMsg0();

                    }
                    else if(mm==-1){
                        System.out.println("No Piece on Space/Invalid Space.");
                    }
                }
                System.out.println("TOGGLING TURN");
                thisGame.toggleTurn();
            }

        }

        if(wk!=-1){
            System.out.println("GAME OVER \nWINNER: WHITE");
        }
        else if(bk!=-1){
            System.out.println("GAME OVER \nWINNER: BLACK");
        }

    }


}