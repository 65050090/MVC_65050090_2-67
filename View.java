import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class View extends JFrame {
    private Database database;
    private JTextField idField;
    private List<String[]> petRecords; // เก็บข้อมูลสัตว์ที่ถูกตรวจสอบ
    private JTextArea reportArea; // ช่องแสดงรายงาน

    public View(Database database) {
        this.database = database;
        this.petRecords = new ArrayList<>();

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

    private void checkID() {
        String id = idField.getText();
        String[] petData = database.findPetByID(id);

        if (petData != null) {
            JOptionPane.showMessageDialog(this, "Pet Information:\n" + "ID: " + petData[0] + "\nType: " + petData[1]
                    + "\nLast Health Check Date: " + petData[2] + "\nVaccines Received: " + petData[3]);

            petRecords.add(petData); // เพิ่มข้อมูลสัตว์ที่ถูกตรวจสอบ

            switch (petData[1]) {
                case "Phoenix":
                    new PhoenixView(this, petRecords);
                    break;
                case "Dragon":
                    new DragonView(this, petRecords);
                    break;
                case "Owl":
                    new OwlView(this, petRecords);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, " This pet does not exist. Please enter a new ID.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openReportWindow() {
        // สร้างหน้าต่างแสดงรายงาน
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

    private void showReport(String petType) {
        StringBuilder report = new StringBuilder("📊 " + petType + " Report:\n");

        int accepted = 0, rejected = 0;

        for (String[] pet : petRecords) {
            if (pet[1].equals(petType)) {
                report.append("ID: ").append(pet[0]).append("\n")
                        .append("Last Health Check: ").append(pet[2]).append("\n")
                        .append("Vaccines Received: ").append(pet[3]).append("\n");

                if (petType.equals("Phoenix")) {
                    report.append("Fireproof Certificate: ").append(pet[4].equals("true") ? "Yes" : "No").append("\n");
                    if (pet[4].equals("true"))
                        accepted++;
                    else
                        rejected++;
                } else if (petType.equals("Dragon")) {
                    report.append("Pollution Level: ").append(pet[4]).append("%\n");
                    if (Integer.parseInt(pet[4]) <= 70)
                        accepted++;
                    else
                        rejected++;
                } else if (petType.equals("Owl")) {
                    report.append("Flight Range: ").append(pet[4]).append(" km\n");
                    if (Integer.parseInt(pet[4]) >= 100)
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
