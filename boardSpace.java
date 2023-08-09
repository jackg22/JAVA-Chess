import java.util.*;

public class boardSpace{
    private String col;
    private int colI;
    private int row;
    private int rowI;
    private boolean color;
    private String label;
    boolean IsEmpty;


    public boardSpace(){
        col = "";
        row = 0;
        //LETTER UP
        //INDEX DOWN
        colI=0;
        rowI =0;
        color = false;
        label = "";
        IsEmpty = true;

    }

    public String toString(){
        return this.col+this.row;

    }

    public boardSpace(String c, int r, boolean co, int colI,int rowI){
        this.colI = colI;
        this.rowI = rowI;
        col=c;
        row = r;
        color = co;
        label = col+row;
        IsEmpty = true;
    }
    public void setColor(boolean a){
        color = a;
    }

    public String getRowS(){
        return ""+this.row;
    }

    public int getRowI(){
        return this.rowI;
    }

    public String getColS(){
        int returnCol = -1;
        String a = "abcdefgh";
        String b = col.toLowerCase();
        for(int i=0;i<a.length()-1;i++){
            if(a.substring(i,i+1).equals(b)){
                returnCol = i;
            }
        }
        return ""+returnCol;
    }
    public int getColI(){
        return this.colI;
    }

    public int getCol(){
        int returnCol = -1;
        String a = "abcdefgh";
        String b = col.toLowerCase();
        for(int i=0;i<a.length()-1;i++){
            if(a.substring(i,i+1).equals(b)){
                returnCol = i;
            }
        }
        return returnCol;
    }

    public String getLabel(){
        return label;
    }



    public boolean isEmpty(){
        return this.IsEmpty;
    }


    public void getColor(){
        System.out.println(color);
    }

    public void toggleEmpty(){
        if(this.IsEmpty){
            this.IsEmpty = false;
        }
        else{
            this.IsEmpty = true;
        }
    }

}



