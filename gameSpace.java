public class gameSpace{

    private Board board;
    private boolean turn;
    private int escMsg;

    public gameSpace(){
        this.board = new Board();
        this.turn = true;
        this.escMsg = 0;
    }

    public void toggleTurn(){
        if(this.turn){
            this.turn = false;
        }
        else{
            this.turn = true;
        }
    }

    public Board getBoard(){
        return this.board;
    }

    public void setMsg0(){
        this.escMsg=0;
    }

    public void setMsg1(){
        this.escMsg=1;
    }

    public boolean getTurn(){
        return this.turn;
    }

    public int getEscMsg(){
        return this.escMsg;
    }

}