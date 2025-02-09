import javax.swing.*;

public class OwlView extends JFrame {
    private JTextField flightRangeField;

    public OwlView() {
        setTitle("Owl Verification");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        flightRangeField = new JTextField(5);
        JButton submitButton = new JButton("confirm");

        panel.add(new JLabel("Flight distance (km):"));
        panel.add(flightRangeField);
        panel.add(submitButton);
        add(panel);

        submitButton.addActionListener(e -> checkOwl());

        setVisible(true);
    }

    private void checkOwl() {
        try {
            int flightRange = Integer.parseInt(flightRangeField.getText());
            if (flightRange >= 100) {
                JOptionPane.showMessageDialog(this, "Owl Dragon has been accepted into the school!");
            } else {
                JOptionPane.showMessageDialog(this, " Owl  rejected (Must be able to fly at least 100 km.)");
            }
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid value.");
        }
    }
}
