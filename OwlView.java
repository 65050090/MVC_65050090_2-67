import javax.swing.*;

public class OwlView extends JFrame {
    private JTextField flightRangeField;
    private View parentView;

    public OwlView(View parentView) {
        this.parentView = parentView;
        setTitle("Owl Verification");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        flightRangeField = new JTextField(5);
        JButton submitButton = new JButton("Confirm");

        panel.add(new JLabel("Flight Range (km):"));
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
                parentView.addAcceptedPet("Owl");
                JOptionPane.showMessageDialog(this, "✅ Owl has been accepted into the school!");
            } else {
                parentView.addRejectedPet("Owl");
                JOptionPane.showMessageDialog(this, "❌ Owl was rejected (Must fly at least 100 km).");
            }
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }
}
