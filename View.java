import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// View Class
public class View {
    private JFrame frame;
    private JTextField idField;
    private JButton checkButton;
    private JTextArea outputArea;
    private JButton milkButton;
    private JButton resetButton;
    private JButton addLemonButton;
    private JButton summaryReportButton;

    private JFrame summaryFrame;
    private JTextArea summaryOutputArea;
    private JButton backButton;

    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Cow Milk System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel idLabel = new JLabel("Cow ID:");
        idLabel.setBounds(10, 10, 80, 25);
        frame.add(idLabel);

        idField = new JTextField();
        idField.setBounds(100, 10, 160, 25);
        frame.add(idField);

        checkButton = new JButton("Check Cow");
        checkButton.setBounds(270, 10, 100, 25);
        frame.add(checkButton);

        milkButton = new JButton("Milk Cow");
        milkButton.setBounds(10, 50, 150, 25);
        frame.add(milkButton);

        resetButton = new JButton("Reset BSOD");
        resetButton.setBounds(180, 50, 150, 25);
        frame.add(resetButton);

        
        outputArea = new JTextArea();
        outputArea.setBounds(10, 130, 360, 200);
        outputArea.setEditable(false);
        frame.add(outputArea);

        frame.setVisible(true);

        

        summaryFrame.setVisible(true);
    }
}
