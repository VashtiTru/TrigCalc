import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrigCalculatorPanel extends JPanel {
    private JTextField degreeInput;

    public TrigCalculatorPanel() {
        setLayout(new BorderLayout());
        degreeInput = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel();

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Degree: "));
        inputPanel.add(degreeInput);
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double degree = Double.parseDouble(degreeInput.getText());
                // Perform trigonometric calculations based on degree input
                // Update resultLabel with calculated values
            }
        });
    }
}
