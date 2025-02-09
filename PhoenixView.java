import javax.swing.*;

public class PhoenixView extends JFrame {
    private JCheckBox fireProofCheckBox;
    private View parentView;

    public PhoenixView(View parentView) {
        this.parentView = parentView;

        setTitle("Phoenix Verification");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        fireProofCheckBox = new JCheckBox("Has Fireproof Certificate");
        JButton submitButton = new JButton("Confirm");

        submitButton.addActionListener(e -> checkPhoenix());

        panel.add(fireProofCheckBox);
        panel.add(submitButton);
        add(panel);

        setVisible(true);
    }

    private void checkPhoenix() {
        if (fireProofCheckBox.isSelected()) {
            JOptionPane.showMessageDialog(this, "Phoenix has been accepted into the school!");
            parentView.addAcceptedPet("Phoenix");
        } else {
            JOptionPane.showMessageDialog(this, "Phoenix was rejected (Fireproof certificate is required).");
            parentView.addRejectedPet("Phoenix");
        }
        dispose();
    }
}
