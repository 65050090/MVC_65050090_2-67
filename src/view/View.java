package src.view;
import javax.swing.*;
import src.controller.Controller;
import java.awt.*;
import java.util.List;

public class View extends JFrame {
    private Controller controller; // เปลี่ยนให้รับ Controller แทน Database
    private JTextField idField;
    private JTextArea reportArea; // ช่องแสดงรายงาน

    // Constructor ที่รับ Controller แทน
    public View(Controller controller) {
        this.controller = controller;

        setTitle("Pet Verification System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ส่วนของการกรอก ID
        JPanel inputPanel = new JPanel(new GridLayout(2, 1));
        idField = new JTextField();
        inputPanel.add(new JLabel("Enter Pet ID:"));
        inputPanel.add(idField);

        JButton submitButton = new JButton("Confirm");
        submitButton.addActionListener(e -> checkID());

        JButton reportButton = new JButton("View Report");
        reportButton.addActionListener(e -> openReportWindow());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(reportButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // เมื่อกด Confirm ให้เรียก Controller เพื่อค้นหา pet ตาม ID
    private void checkID() {
        String id = idField.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a pet ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] petData = controller.findPetByID(id);

        if (petData != null) {
            JOptionPane.showMessageDialog(this, "Pet Information:\n" + "ID: " + petData[0] + "\nType: " + petData[1]
                    + "\nLast Health Check Date: " + petData[2] + "\nVaccines Received: " + petData[3]);

            // เปิดหน้าต่างตรวจสอบตามประเภทของสัตว์
            switch (petData[1]) {
                case "Phoenix":
                    new PhoenixView(controller);
                    break;
                case "Dragon":
                    new DragonView(controller);
                    break;
                case "Owl":
                    new OwlView(controller);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Unknown pet type.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "This pet does not exist. Please enter a new ID.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // เปิดหน้าต่างแสดงรายงาน
    private void openReportWindow() {
        JFrame reportFrame = new JFrame("Pet Report");
        reportFrame.setSize(500, 400);
        reportFrame.setLocationRelativeTo(null);
        reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reportFrame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JButton phoenixButton = new JButton("View Phoenix");
        JButton dragonButton = new JButton("View Dragon");
        JButton owlButton = new JButton("View Owl");

        phoenixButton.addActionListener(e -> showReport("Phoenix"));
        dragonButton.addActionListener(e -> showReport("Dragon"));
        owlButton.addActionListener(e -> showReport("Owl"));

        buttonPanel.add(phoenixButton);
        buttonPanel.add(dragonButton);
        buttonPanel.add(owlButton);

        reportArea = new JTextArea();
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);

        reportFrame.add(buttonPanel, BorderLayout.NORTH);
        reportFrame.add(scrollPane, BorderLayout.CENTER);
        reportFrame.setVisible(true);
    }

    // แสดงรายงานสำหรับ pet ที่เลือก
    private void showReport(String petType) {
        StringBuilder report = new StringBuilder("📊 " + petType + " Report:\n");

        int accepted = 0, rejected = 0;

        // รับ petRecords จาก Controller
        List<String[]> petRecords = controller.getPetRecords();

        for (String[] pet : petRecords) {
            if (pet[1].equals(petType)) {
                report.append("ID: ").append(pet[0]).append("\n")
                        .append("Last Health Check: ").append(pet[2]).append("\n")
                        .append("Vaccines Received: ").append(pet[3]).append("\n");

                if (petType.equals("Phoenix")) {
                    String fireProof = (pet.length > 4) ? pet[4] : "false";
                    report.append("Fireproof Certificate: ").append(fireProof.equals("true") ? "Yes" : "No").append("\n");
                    if (fireProof.equals("true"))
                        accepted++;
                    else
                        rejected++;
                } else if (petType.equals("Dragon")) {
                    int pollution = 0;
                    if (pet.length > 4) {
                        try {
                            pollution = Integer.parseInt(pet[4]);
                        } catch (NumberFormatException e) {
                            pollution = 100; // กรณีข้อมูลผิดพลาด ให้ถือว่าปฏิเสธ
                        }
                    }
                    report.append("Pollution Level: ").append(pollution).append("%\n");
                    if (pollution <= 70)
                        accepted++;
                    else
                        rejected++;
                } else if (petType.equals("Owl")) {
                    int flightRange = 0;
                    if (pet.length > 4) {
                        try {
                            flightRange = Integer.parseInt(pet[4]);
                        } catch (NumberFormatException e) {
                            flightRange = 0;
                        }
                    }
                    report.append("Flight Range: ").append(flightRange).append(" km\n");
                    if (flightRange >= 100)
                        accepted++;
                    else
                        rejected++;
                }
                report.append("\n");
            }
        }

        report.append("Accepted: ").append(accepted).append("\nRejected: ").append(rejected);
        reportArea.setText(report.toString());
    }
}
