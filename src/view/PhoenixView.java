package src.view;

import javax.swing.*;
import src.controller.Controller;

public class PhoenixView extends JFrame {
    private JCheckBox fireProofCheckBox;
    private Controller controller; // เปลี่ยนจากการรับ parentView และ petRecords มาเป็น Controller

    // Constructor ที่รับ Controller แทน
    public PhoenixView(Controller controller) {
        this.controller = controller;
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
        // ดึงข้อมูลรายการสัตว์ล่าสุดจาก Controller
        String[] lastPet = controller.getLastPetRecord();

        String[] updatedPet;
        if (lastPet.length >= 5) {
            updatedPet = lastPet.clone();
            updatedPet[4] = fireProof ? "true" : "false";
        } else {
            updatedPet = new String[] { lastPet[0], lastPet[1], lastPet[2], lastPet[3], fireProof ? "true" : "false" };
        }
        controller.updateLastPetRecord(updatedPet);

        if (fireProof) {
            JOptionPane.showMessageDialog(this, "Phoenix has been accepted into the school!");
        } else {
            JOptionPane.showMessageDialog(this, "Phoenix was rejected (Fireproof certificate is required).");
        }
        dispose();
    }
}
