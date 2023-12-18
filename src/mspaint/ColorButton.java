package mspaint;


import java.awt.*;
import java.awt.event.*;


public class ColorButton extends Button implements ActionListener {
    
    ColorButton(Color c) {
        // setSize(20, 20);
        setLabel(" ");
        setPreferredSize(new Dimension(20, 20));
        // color = c;
        setBackground(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyFrame.cursorColor = Color.ORANGE;
    }
}
