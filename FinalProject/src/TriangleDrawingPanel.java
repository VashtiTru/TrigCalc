import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TriangleDrawingPanel extends JFrame {
    private JTextField[] vertexInputs;
    private JButton drawButton;
    private JPanel drawingPanel;

    public TriangleDrawingPanel() {
        super("Triangle Drawing");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        JPanel inputPanel = new JPanel(new GridLayout(4, 3)); // 4 rows, 3 columns for x, y, and z values
        vertexInputs = new JTextField[9]; // Three vertices with x, y, and z coordinates
        for (int i = 0; i < 9; i++) {
            vertexInputs[i] = new JTextField(5);
            inputPanel.add(new JLabel((i % 3 == 0 ? "X: " : (i % 3 == 1 ? "Y: " : "Z: "))));
            inputPanel.add(vertexInputs[i]);
        }

        drawButton = new JButton("Draw");
        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateVertices();
            }
        });

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Draw the triangle using the stored vertices
                int[] xPoints = new int[3];
                int[] yPoints = new int[3];
                for (int i = 0; i < 3; i++) {
                    xPoints[i] = Integer.parseInt(vertexInputs[i * 3].getText());
                    yPoints[i] = Integer.parseInt(vertexInputs[i * 3 + 1].getText());
                }
                g.drawPolygon(xPoints, yPoints, 3);
            }
        };

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(drawingPanel, BorderLayout.CENTER);
        getContentPane().add(drawButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateVertices() {
        drawingPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TriangleDrawingPanel();
            }
        });
    }
}
