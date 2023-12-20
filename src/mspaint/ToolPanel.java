package mspaint;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ToolPanel extends JPanel {

    public static Checkbox pencil, brush,eraser;

    ToolPanel() {
        setVisible(true);
        setLayout(new FlowLayout());
        ColorPalette palette = new ColorPalette();
        add(palette);
        setBorder(new EmptyBorder(10, 10, 10, 10));

        CheckboxGroup tools = new CheckboxGroup();
        brush = new Checkbox("Brush", tools, true);
        pencil = new Checkbox("Pencil", tools, false);
        eraser = new Checkbox("Eraser",tools,false);

        add(brush);
        add(pencil);
    }
}
