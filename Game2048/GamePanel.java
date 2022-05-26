import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    //Instances
    private int COLUMNS;
    private int ROWS;
    private NumSquare[][] numbers;


    //Constructor
    public GamePanel(int xSize, int ySize){
        init(xSize, ySize);
    }


    //Methods
    public void init(int xSize, int ySize){
        removeAll();
        COLUMNS = xSize;
        ROWS = ySize;
        setLayout(new GridLayout(ROWS, COLUMNS)); numbers = new NumSquare[COLUMNS][ROWS]; 
        for (int row = 0; row < ROWS; row++){
            for(int col = 0; col < COLUMNS; col++) { 
                numbers[row][col] = new NumSquare(0); add(numbers[row][col]);
            }
        }
    }

    public int getValue(int x, int y){
        return numbers[x][y].getValue();
    }

    public void setValue(int x, int y, int set){
        numbers[x][y].setValue(set);
    }


}
