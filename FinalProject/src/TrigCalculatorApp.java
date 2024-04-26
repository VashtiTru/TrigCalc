import javax.swing.*;
import java.awt.*;

public class TrigCalculatorApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Trigonometry Calculator App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create instances
        TrigCalculatorPanel calctriganglePanel = new TrigCalculatorPanel();
        ConversionCalculatorPanel conversionPanel = new ConversionCalculatorPanel();
        TriangleDrawingPanel drawtrianglePanel = new TriangleDrawingPanel();

        // Create title labels for each panel
        JLabel trigTitleLabel = new JLabel("Trigonometry Calculator");
        JLabel conversionTitleLabel = new JLabel("Conversion Calculator");
        JLabel triangleTitleLabel = new JLabel("Triangle Drawing");

        // Create panels to hold each calculator panel with title labels
        JPanel trigPanel = createTitledPanel(trigTitleLabel, calctriganglePanel);
        JPanel conversionPanelHolder = createTitledPanel(conversionTitleLabel, conversionPanel);
        JPanel trianglePanel = createTitledPanel(triangleTitleLabel, drawtrianglePanel);

        // Create main panel to hold all calculator panels
        JPanel mainPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // 1 row, 3 columns, with gaps of 10 pixels
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        mainPanel.add(trigPanel);
        mainPanel.add(conversionPanelHolder);
        mainPanel.add(trianglePanel);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    // Helper method to create titled panel
    private static JPanel createTitledPanel(JLabel titleLabel, Component contentComponent) {
        JPanel titledPanel = new JPanel(new BorderLayout());
        titledPanel.setBorder(BorderFactory.createEtchedBorder()); // Add border
        titledPanel.add(titleLabel, BorderLayout.NORTH);
        titledPanel.add(contentComponent, BorderLayout.CENTER);
        return titledPanel;
    }
}
