package mspaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar implements ActionListener {

    JMenu filemenu, editmenu, helpmenu;
    JMenuItem newfile, saveasfile, savefile;
    MyFrame myFrame; 
    DrawPanel drawPanel;

    MyMenuBar(MyFrame frame, DrawPanel drawPanel) {
        filemenu = new JMenu("File");

        this.myFrame = frame;
        this.drawPanel = drawPanel;

        newfile = new JMenuItem("New File");
        saveasfile = new JMenuItem("Save As");
        saveasfile.addActionListener(this);
        savefile = new JMenuItem("Save");

        filemenu.add(newfile);
        filemenu.add(saveasfile);
        filemenu.add(savefile);

        editmenu = new JMenu("Edit");

        helpmenu = new JMenu("Help");

        add(filemenu);
        add(editmenu);
        add(helpmenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveasfile) {
            saveFile();
        }
        else if(e.getSource() == newfile) {
            newFile();
            System.out.println("Clicked");
        }
    }

    private void saveFile() {
        // BufferedImage image = new BufferedImage(500,500, BufferedImage.TYPE_INT_ARGB);
        // Graphics g = image.getGraphics();
        // // panel.paint(g);
        try {
            // ImageIO.write(image, "png", new File("output.png"));
            BufferedImage im = makePanel(myFrame.getDrawPanel());
            ImageIO.write(im, "png", new File("output.png"));
            System.out.println("Image saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void newFile() {
        Graphics g = myFrame.getDrawPanel().getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, drawPanel.getWidth(), drawPanel.getHeight());
        g.dispose();
    }

    private BufferedImage makePanel(DrawPanel panel) {
	    int w = panel.getWidth();
	    int h = panel.getHeight();
	    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    Graphics g = bi.getGraphics();
	    panel.printAll(g);
	    return bi;
	}
}
