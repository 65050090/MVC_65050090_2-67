package src.view;
import javax.swing.*;
import src.controller.Controller;

public class OwlView extends JFrame {
    private JTextField flightRangeField;
    private Controller controller; // เปลี่ยนจากการรับ parentView และ petRecords มาเป็น Controller

    // Constructor ที่รับ Controller แทน
    public OwlView(Controller controller) { 
        this.controller = controller;
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
            // ดึงข้อมูลรายการสัตว์ล่าสุดจาก Controller
            String[] lastPet = controller.getLastPetRecord();

            String[] updatedPet;
            if (lastPet.length >= 5) {
                updatedPet = lastPet.clone();
                updatedPet[4] = String.valueOf(flightRange);
            } else {
                updatedPet = new String[] { lastPet[0], lastPet[1], lastPet[2], lastPet[3], String.valueOf(flightRange) };
            }
            controller.updateLastPetRecord(updatedPet);

            if (flightRange >= 100) {
                JOptionPane.showMessageDialog(this, "Owl has been accepted into the school!");
            } else {
                JOptionPane.showMessageDialog(this, "Owl was rejected (Must fly at least 100 km).");
            }
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }
}
