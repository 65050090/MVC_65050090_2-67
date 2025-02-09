import javax.swing.*;
import java.util.List;

public class PhoenixView extends JFrame {
    private JCheckBox fireProofCheckBox;
    private View parentView;
    private List<String[]> petRecords;

    public PhoenixView(View parentView, List<String[]> petRecords) {
        this.parentView = parentView;
        this.petRecords = petRecords;

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
        boolean fireProof = fireProofCheckBox.isSelected();
        String[] lastPet = petRecords.get(petRecords.size() - 1);

        // 🔹 แทนที่ค่าเก่าด้วยค่าใหม่
        String[] updatedPet = { lastPet[0], lastPet[1], lastPet[2], lastPet[3], fireProof ? "true" : "false" };
        petRecords.set(petRecords.size() - 1, updatedPet); // อัปเดตรายการที่ถูกตรวจสอบแล้ว

        if (fireProof) {
            JOptionPane.showMessageDialog(this, " Phoenix has been accepted into the school!");
        } else {
            JOptionPane.showMessageDialog(this, " Phoenix was rejected (Fireproof certificate is required).");
        }
        dispose();
    }
}
