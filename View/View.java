package view;

import controller.Controller;
import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        frame = new JFrame("Magic Pet Management");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        JButton phoenixButton = new JButton("View Phoenix");
        phoenixButton.addActionListener(e -> new PhoenixView(controller));

        JButton dragonButton = new JButton("View Dragons");
        dragonButton.addActionListener(e -> new DragonView(controller));

        JButton owlButton = new JButton("View Owls");
        owlButton.addActionListener(e -> new OwlView(controller));

        JButton reportButton = new JButton("View Report");
        reportButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, controller.getReport()));

        frame.add(phoenixButton);
        frame.add(dragonButton);
        frame.add(owlButton);
        frame.add(reportButton);
        frame.setVisible(true);
    }
}
