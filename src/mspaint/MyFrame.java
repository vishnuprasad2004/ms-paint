package mspaint;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyFrame extends JFrame implements MouseMotionListener {
    
    final static int cursorRadiusEraserRadius = 10;
    final static int cursorRadiusBrushRadius = 5;
    

    Graphics g;
    int cursorRadius = 5;
    static Color cursorColor = Color.BLACK;

    public MyFrame() {
        setVisible(true);
        setSize(400, 400);
        // setResizable(false);
        setLayout(new FlowLayout());
        addMouseMotionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setForeground(Color.BLACK);

        
        ColorButton blueBtn = new ColorButton(Color.BLUE);
        blueBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cursorColor = blueBtn.getBackground();
            }
        });
       
        ColorButton redBtn = new ColorButton(Color.RED);
        redBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cursorColor = redBtn.getBackground();
            }
        });
        
        ColorButton greenBtn = new ColorButton(Color.GREEN);
        greenBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cursorColor = greenBtn.getBackground();
            }
        });
        
        ColorButton yellowBtn = new ColorButton(Color.YELLOW);
        yellowBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cursorColor = yellowBtn.getBackground();     
            }
        });
        
        ColorButton blackBtn = new ColorButton(Color.BLACK);
        blackBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cursorColor = blackBtn.getBackground();        
            }
        });
        
        Button eraser = new Button("Eraser");
        eraser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cursorColor = Color.WHITE;
                
            }
        });
        
        JPanel palette = new JPanel(new FlowLayout());
        palette.setBackground(Color.LIGHT_GRAY);
        palette.add(redBtn);
        palette.add(eraser);
        palette.add(yellowBtn);
        for (int i = 1; i <= 5; i++) {
            Button button = new Button("Button " + i);
            palette.add(button);
        }
        getContentPane().add(palette);
        add(blueBtn);
        add(redBtn);
        add(greenBtn);
        add(yellowBtn);
        add(blackBtn);
        add(eraser);


        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        g = getGraphics();
        g.setColor(cursorColor);
        g.fillOval(e.getX() - cursorRadius, e.getY() - cursorRadius, cursorRadius * 5, cursorRadius * 5);
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {}

}

