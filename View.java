import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class View extends JFrame {
    private Database database;
    private JTextField idField;
    private JTextArea reportArea;
    private List<String> acceptedPets;
    private List<String> rejectedPets;

    public View(Database database) {
        this.database = database;
        this.acceptedPets = new ArrayList<>();
        this.rejectedPets = new ArrayList<>();

        setTitle("Pet Verification System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 1));
        idField = new JTextField();
        inputPanel.add(new JLabel("Enter Pet ID:"));
        inputPanel.add(idField);

        JButton submitButton = new JButton("Confirm");
        submitButton.addActionListener(e -> checkID());

        JButton reportButton = new JButton("View Report");
        reportButton.addActionListener(e -> showReport());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(reportButton);

        reportArea = new JTextArea();
        reportArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(reportArea), BorderLayout.SOUTH);

        setVisible(true);
    }

    private void checkID() {
        String id = idField.getText();
        String[] petData = database.findPetByID(id);

        if (petData != null) {
            String petType = petData[1];
            String message = "Pet Information:\n" +
                    "ID: " + petData[0] + "\nType: " + petType + "\nLast Health Check Date: " + petData[2] +
                    "\nVaccines Received: " + petData[3];

            JOptionPane.showMessageDialog(this, message);

            switch (petType) {
                case "Phoenix":
                    new PhoenixView(this);
                    break;
                case "Dragon":
                    new DragonView(this);
                    break;
                case "Owl":
                    new OwlView(this);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "This pet does not exist. Please enter a new ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addAcceptedPet(String petType) {
        acceptedPets.add(petType);
    }

    public void addRejectedPet(String petType) {
        rejectedPets.add(petType);
    }

    private void showReport() {
        int phoenixCount = (int) acceptedPets.stream().filter(p -> p.equals("Phoenix")).count();
        int dragonCount = (int) acceptedPets.stream().filter(p -> p.equals("Dragon")).count();
        int owlCount = (int) acceptedPets.stream().filter(p -> p.equals("Owl")).count();

        String report = "📊 Pet Report:\n" +
                "Phoenix: " + phoenixCount + "\n" +
                "Dragon: " + dragonCount + "\n" +
                "Owl: " + owlCount + "\n" +
                "\nAccepted: " + acceptedPets.size() +
                "\nRejected: " + rejectedPets.size();

        reportArea.setText(report);
    }
}
