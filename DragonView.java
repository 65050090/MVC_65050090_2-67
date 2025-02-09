import javax.swing.*;

public class DragonView extends JFrame {
    private JTextField pollutionField;
    private View parentView;

    public DragonView(View parentView) {
        this.parentView = parentView;
        setTitle("Dragon Verification");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        pollutionField = new JTextField(5);
        JButton submitButton = new JButton("Confirm");

        panel.add(new JLabel("Pollution Level (%):"));
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
                parentView.addAcceptedPet("Dragon");
                JOptionPane.showMessageDialog(this, "Dragon has been accepted into the school!");
            } else {
                parentView.addRejectedPet("Dragon");
                JOptionPane.showMessageDialog(this, "Dragon was rejected (Pollution level exceeds 70%).");
            }
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }
}
