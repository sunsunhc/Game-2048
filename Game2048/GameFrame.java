import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame{

    JPanel panelMain;
    BoxLayout b;
    GamePanel panelGame;
    JButton btnLeft;
    JButton btnRight;
    JButton btnUp;
    JButton btnDown;
    JPanel panelButtons;
    GridBagConstraints constraints;
    Game2048 game;

    
    public GameFrame(){
        super("2048");

    
        panelMain = new JPanel();
        b = new BoxLayout(panelMain, 1);
        panelMain.setLayout(b);

        this.add(panelMain);

        panelMain.setBackground(Color.white);

        panelGame = new GamePanel(4, 4);
        btnLeft = new JButton("Slide Left");
        btnRight = new JButton("Slide Right");
        btnUp = new JButton("Slide Up");
        btnDown = new JButton("Slide Down");



        panelMain.add(panelGame);

        panelButtons = new JPanel();
        panelButtons.setBackground(Color.gray);
        panelButtons.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        btnLeft = new JButton("Slide Left");
        constraints.gridx = 0; 
        constraints.gridy = 1; 
        panelButtons.add(btnLeft, constraints);
        btnLeft.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.SetDirection("a");
                game.push();
                updateNumSquares();
            }
        });

        btnRight = new JButton("Slide Right"); 
        constraints.gridx = 2; 
        constraints.gridy = 1; 
        panelButtons.add(btnRight, constraints);
        btnRight.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.SetDirection("d");
                game.push();
                updateNumSquares();
            }
        });

        btnUp = new JButton("Slide Up"); 
        constraints.gridx = 1; 
        constraints.gridy = 0; 
        panelButtons.add(btnUp, constraints);
        btnUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.SetDirection("w");
                game.push();
                updateNumSquares();
            }
        });

        btnDown = new JButton("Slide Down"); 
        constraints.gridx = 1; 
        constraints.gridy = 2; 
        panelButtons.add(btnDown, constraints);
        btnDown.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.SetDirection("s");
                game.push();
                updateNumSquares();
            }
        });

        panelMain.add(panelButtons);

        game = new Game2048();
        updateNumSquares();

        this.addKeyListener(new KeyListener(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    game.SetDirection("w");
                    game.push();
                    updateNumSquares();
                }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    game.SetDirection("s");
                    game.push();
                    updateNumSquares();
                }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    game.SetDirection("a");
                    game.push();
                    updateNumSquares();
                }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    game.SetDirection("d");
                    game.push();
                    updateNumSquares();
                }
            }

            public void keyReleased(KeyEvent e){}

            public void keyTyped(KeyEvent e){}
        });

        btnDown.setFocusable(false);
        btnUp.setFocusable(false);
        btnLeft.setFocusable(false);
        btnRight.setFocusable(false);
    }

    public void updateNumSquares(){
        for(int r = 0; r < 4; r++){
            for(int c = 0; c < 4; c++){
                panelGame.setValue(r, c, game.getV(r, c));
            }
        }
        panelGame.repaint();
    }
}
