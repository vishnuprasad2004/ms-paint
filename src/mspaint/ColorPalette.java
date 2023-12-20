package mspaint;

import javax.swing.BoxLayout;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPalette extends JPanel {

    public static Color colors[] = {
            Color.BLACK, Color.BLUE, Color.CYAN,
            Color.MAGENTA, Color.ORANGE, Color.YELLOW,
            Color.RED, Color.WHITE, Color.GREEN
    };

    ColorPalette() {
        setVisible(true);
        // setLayout(new FlowLayout());
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        // setBounds(0, 0, WIDTH, HEIGHT);
        setBackground(Color.LIGHT_GRAY);
        for (int i = 0; i < colors.length; i++) {
            ColorButton btn = new ColorButton(colors[i]);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DrawPanel.setCursorColor(btn.getBackground());
                    DrawPanel.setCursorRadius(DrawPanel.cursorRadiusBrushRadius);
                }
            });
            add(btn);
        }

        Button addColorBtn = new Button("+");
        addColorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JColorChooser chooser = new JColorChooser();
                Color c = JColorChooser.showDialog(null, "Add a new Color", Color.BLACK);
                addNewColorBtn(c);
            }

        });

        add(addColorBtn);

        Button eraser = new Button("Eraser");
        eraser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DrawPanel.setCursorColor(Color.WHITE);
                DrawPanel.setCursorRadius(DrawPanel.cursorRadiusEraserRadius);
            }
        });
        add(eraser);

    }

    public void addNewColorBtn(Color c) {
        ColorButton btn = new ColorButton(c);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrawPanel.setCursorColor(btn.getBackground());
                DrawPanel.setCursorRadius(DrawPanel.cursorRadiusBrushRadius);
            }

        });
        add(btn);
    }
}
