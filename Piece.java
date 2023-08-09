import java.util.*;

public interface Piece{


    boolean getColor();

    void setBoardSpace(boardSpace a);

    void setBlack();

    boardSpace getBoardSpace();

    int getRow();

    int getCol();

    void setWhite();

    void takePiece(Board a,Piece b,boolean co);

    int getColI();

    int getRowI();

    String getType();

    boolean canMove(Board a, String g);

    void move(Board b, gameSpace g);
    //void move(Board b);

    String toString();

    void setTag(String a);

    String getTag();



}