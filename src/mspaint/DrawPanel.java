package mspaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseMotionListener, MouseListener {

    public final static int cursorRadiusEraserRadius = 15;
    public final static int cursorRadiusBrushRadius = 5;

    private static Graphics g;
    private static int cursorRadius = 5;
    private static Color cursorColor = Color.BLACK;

    public static int x = 0, y = 0;
    public static int prevx, prevy;

    DrawPanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(500, 500));
        addMouseMotionListener(this);
        setBackground(Color.WHITE);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (ToolPanel.brush.getState()) {
            g = getGraphics();
            g.setColor(cursorColor);
            g.fillOval(e.getX() - cursorRadius, e.getY() - cursorRadius, cursorRadius * 5, cursorRadius * 5);
        }

        if (ToolPanel.pencil.getState()) {
            g = getGraphics();
            g.setColor(cursorColor);
            g.drawLine(x, y, prevx, prevy);
            prevx = x;
            prevy = y;

        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        Footer.cursorCoordinates.setText(String.format("[ %3d, %3d ]", x, y));
    }

    protected static void saveAsPNG(JPanel panel) {
        BufferedImage image = new BufferedImage(500,500, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        panel.paint(g);
        try {
            ImageIO.write(image, "png", new File("output.png"));
            System.out.println("Image saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            g.dispose();
        }
    }


    public void clear() {
        // g = getGraphics();
        setBackground(Color.WHITE);    
    }

    public static void setCursorRadius(int r) {
        cursorRadius = r;
    }

    public static int getCursorRadius() {
        return cursorRadius;
    }

    public static void setCursorColor(Color c) {
        cursorColor = c;
    }

    public static Color getCursorColor() {
        return cursorColor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
