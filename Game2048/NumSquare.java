import java.awt.*;

import javax.swing.JComponent;

public class NumSquare extends JComponent{
    static final int scale = 100;
    static final int border = scale / 20;
    static final int fontSize = (int)(scale * 0.4);
    static final Font font = new Font("Consolas", Font.PLAIN, fontSize);
    private int value;

    public NumSquare(int num){
        this.setValue(num);
        setFont(font);
        Dimension d = new Dimension(scale, scale);
        setPreferredSize(d);

    }


    public int getValue(){
        return value;
    }

    public void setValue(int set){
        value = set;
    }

    public void paintComponent(Graphics g){
        //Background
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        //Rounded Rectangle
        Color color;
        if (value == 0) {
            color = Color.CYAN; 
        } else {
            int len = Integer.numberOfTrailingZeros(value);
            color = Color.getHSBColor(len / 11.0f, 0.8f, 0.5f); 
        }
        g.setColor(color);
        g.fillRoundRect(border / 2, border / 2, getWidth() - border, getHeight() - border, scale / 3, scale / 3);

        //Number
        g.setColor(Color.lightGray);
        FontMetrics metrics = getFontMetrics(font);
        String txt = Integer.toString(value); g.drawString(txt, (getWidth() - metrics.stringWidth(txt)) / 2, getHeight() / 2 + metrics.getAscent() / 3);
        ((Graphics2D)g).setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
