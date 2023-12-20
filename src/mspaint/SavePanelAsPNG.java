package mspaint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SavePanelAsPNG extends JFrame {

    private JPanel drawingPanel;

    public SavePanelAsPNG() {
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Save Panel as PNG");

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Your drawing logic here
                g.setColor(Color.RED);
                g.fillRect(50, 50, 100, 100);
            }
        };

        add(drawingPanel);

        JButton saveButton = new JButton("Save as PNG");
        saveButton.addActionListener(e -> saveAsPNG());

        add(saveButton, BorderLayout.SOUTH);

        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    protected void saveAsPNG() {
        BufferedImage image = new BufferedImage(drawingPanel.getWidth(), drawingPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        drawingPanel.paint(g);
        try {
            ImageIO.write(image, "png", new File("output.png"));
            System.out.println("Image saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            g.dispose();
        }
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> new SavePanelAsPNG());
    // }
}