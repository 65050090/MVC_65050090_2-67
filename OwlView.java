import javax.swing.*;
import java.util.List;

public class OwlView extends JFrame {
    private JTextField flightRangeField;
    private View parentView;
    private List<String[]> petRecords;

    public OwlView(View parentView, List<String[]> petRecords) {
        this.parentView = parentView;
        this.petRecords = petRecords;
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
            String[] lastPet = petRecords.get(petRecords.size() - 1);

            // เพิ่มข้อมูลระยะบินลงไปในระบบ
            lastPet[4] = String.valueOf(flightRange);

            if (flightRange >= 100) {
                JOptionPane.showMessageDialog(this, " Owl has been accepted into the school!");
            } else {
                JOptionPane.showMessageDialog(this, " Owl was rejected (Must fly at least 100 km).");
            }
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }
}
