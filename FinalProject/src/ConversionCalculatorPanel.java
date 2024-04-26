import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ConversionCalculatorPanel extends JFrame {
    private JTextField degreeInput;
    private JLabel coordinateLabel, radianLabel;

    public ConversionCalculatorPanel() {
        super("Conversion Calculator");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        degreeInput = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        coordinateLabel = new JLabel("Coordinate:");
        radianLabel = new JLabel("Radian:");

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateConversion();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter Degree:"));
        panel.add(degreeInput);
        panel.add(calculateButton);
        panel.add(radianLabel);

        getContentPane().add(panel);
        setVisible(true);
    }

    private void calculateConversion() {
        double degree = Double.parseDouble(degreeInput.getText());
        Connection conn = null;
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn = DriverManager.getConnection("jdbc:ucanaccess://TrigInfo.accdb");

            String sql = "SELECT Coordinates, Radian FROM TrigInfo WHERE Degree = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, degree);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String coordinates = rs.getString("Coordinates");
                double radian = rs.getDouble("Radian");

                coordinateLabel.setText("Coordinates: " + coordinates);
                radianLabel.setText("Radian: " + radian);
            } else {
                coordinateLabel.setText("Coordinates: Not found");
                radianLabel.setText("Radian: Not found");
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ConversionCalculatorPanel();
            }
        });
    }
}
