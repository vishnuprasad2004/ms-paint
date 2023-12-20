package mspaint;

import java.awt.*;
import javax.swing.JPanel;

public class Footer extends JPanel {

    protected static Label cursorCoordinates;

    Footer() {
        setVisible(true);
        setLayout(new FlowLayout());
        cursorCoordinates = new Label("[ " + DrawPanel.x + " , " + DrawPanel.y + " ]");
        cursorCoordinates.setPreferredSize(new Dimension(100, 20));
        add(cursorCoordinates);
    }
}
