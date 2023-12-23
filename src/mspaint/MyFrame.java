package mspaint;

import java.awt.*;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

    private DrawPanel drawPanel;
    private ToolPanel toolPanel;
    private Footer footer;

    public MyFrame() {
        setTitle("MS Paint | Mera Sasta Paint");
        setVisible(true);
        // setSize(400, 400);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        ToolPanel panel1 = new ToolPanel();
        getContentPane().add(panel1, BorderLayout.NORTH);
        
        DrawPanel drawPanel = new DrawPanel();
        getContentPane().add(drawPanel, BorderLayout.CENTER);
        this.drawPanel = drawPanel;
        
        MyMenuBar menu = new MyMenuBar(this, drawPanel);
        setJMenuBar(menu);

        Footer footer = new Footer();
        getContentPane().add(footer, BorderLayout.SOUTH);

        pack();

    }

    public DrawPanel getDrawPanel() {
        return this.drawPanel;
    }



}
