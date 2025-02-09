package src.view;
import javax.swing.*;
import src.controller.Controller;

public class DragonView extends JFrame {
    private JTextField pollutionField;
    private Controller controller; // เปลี่ยนจากการรับ parentView และ petRecords มาเป็น Controller

    // Constructor ที่รับ Controller แทน
    public DragonView(Controller controller) { 
        this.controller = controller;
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
            // ดึงข้อมูลรายการสัตว์ล่าสุดจาก Controller
            String[] lastPet = controller.getLastPetRecord();

            // แก้ไขข้อมูลรายการสัตว์โดยอัปเดตค่า pollution ในตำแหน่งที่ 5 (ถ้ายังไม่มี ให้สร้าง array ใหม่)
            String[] updatedPet;
            if (lastPet.length >= 5) {
                updatedPet = lastPet.clone();
                updatedPet[4] = String.valueOf(pollution);
            } else {
                updatedPet = new String[] { lastPet[0], lastPet[1], lastPet[2], lastPet[3], String.valueOf(pollution) };
            }
            // อัปเดตรายการใน Controller
            controller.updateLastPetRecord(updatedPet);

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
