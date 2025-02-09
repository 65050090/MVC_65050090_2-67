import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Database database;
    private JTextField idField;

    public View(Database database) {
        this.database = database;

        setTitle("Enter your pet's ID");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(2, 1));
        idField = new JTextField();
        panel.add(new JLabel("Enter ID:"));
        panel.add(idField);

        JButton submitButton = new JButton("confirm");
        submitButton.addActionListener(e -> checkID());

        add(panel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void checkID() {
        String id = idField.getText();
        String[] petData = database.findPetByID(id);

        if (petData != null) {
            JOptionPane.showMessageDialog(this, "Animal information:\n" +"ID: " + petData[0] + "\nType: " + petData[1] + "\nLast health check date: " + petData[2] + "\nVaccines received: " + petData[3]);

            dispose();
            switch (petData[1]) {
                case "Phoenix":
                    new PhoenixView();
                    break;
                case "Dragon":
                    new DragonView();
                    break;
                case "Owl":
                    new OwlView();
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "This animal does not exist. Please enter a new ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
