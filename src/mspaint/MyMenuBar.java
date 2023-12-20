package mspaint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar implements ActionListener {

    JMenu filemenu, editmenu, helpmenu;
    JMenuItem newfile, saveasfile, savefile;

    MyMenuBar() {
        filemenu = new JMenu("File");

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
            DrawPanel d = new DrawPanel();
            DrawPanel.saveAsPNG(d);
        }
        if(e.getSource() == newfile) {
            
        }
    }
}
