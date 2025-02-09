import javax.swing.*;
import java.util.List;

public class DragonView extends JFrame {
    private JTextField pollutionField;
    private View parentView;
    private List<String[]> petRecords;

    public DragonView(View parentView, List<String[]> petRecords) {
        this.parentView = parentView;
        this.petRecords = petRecords;
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
            String[] lastPet = petRecords.get(petRecords.size() - 1);

            // 🔹 แทนที่ค่าเก่าด้วยค่าใหม่
            String[] updatedPet = { lastPet[0], lastPet[1], lastPet[2], lastPet[3], String.valueOf(pollution) };
            petRecords.set(petRecords.size() - 1, updatedPet); // อัปเดตรายการที่ถูกตรวจสอบแล้ว

            if (pollution <= 70) {
                JOptionPane.showMessageDialog(this, "Dragon has been accepted into the school!");
            } else {
                JOptionPane.showMessageDialog(this, "Dragon was rejected (Pollution level exceeds 70%).");
            }
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }
}
