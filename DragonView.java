import javax.swing.*;

public class DragonView extends JFrame {
    private JTextField pollutionField;

    public DragonView() {
        setTitle("Dragon Verification");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        pollutionField = new JTextField(5);
        JButton submitButton = new JButton("confirm");

        panel.add(new JLabel("Pollution levels (%):"));
        panel.add(pollutionField);
        panel.add(submitButton);
        add(panel);

        submitButton.addActionListener(e -> checkDragon());

        setVisible(true);
    }

    private void checkDragon() {
        try {
            int pollution = Integer.parseInt(pollutionField.getText());
            if (pollution <= 70) {
                JOptionPane.showMessageDialog(this, " Dragon has been accepted into the school!");
            } else {
                JOptionPane.showMessageDialog(this, "Dragon rejected (pollution level over 70%)");
            }
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid value.");
        }
    }
}
