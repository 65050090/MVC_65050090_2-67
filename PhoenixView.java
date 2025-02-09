import javax.swing.*;

public class PhoenixView extends JFrame {
    private JCheckBox fireProofCheckBox;

    public PhoenixView() {
        setTitle("Phoenix Verification");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        fireProofCheckBox = new JCheckBox("Has a fire retardant certificate");
        JButton submitButton = new JButton("confirm");

        submitButton.addActionListener(e -> checkPhoenix());

        panel.add(fireProofCheckBox);
        panel.add(submitButton);
        add(panel);

        setVisible(true);
    }

    private void checkPhoenix() {
        if (fireProofCheckBox.isSelected()) {
            JOptionPane.showMessageDialog(this, "Phoenix has been accepted into the school!");
        } else {
            JOptionPane.showMessageDialog(this, "Phoenix rejected (Must have a fire retardant certificate)");
        }
        dispose();
    }
}
