package mspaint;


import java.awt.*;
import java.awt.event.*;


public class ColorButton extends Button {
    
    ColorButton(Color c) {
        setPreferredSize(new Dimension(20, 20));
        setBackground(c);
    }
}
