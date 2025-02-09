package view;

import controller.Controller;
import javax.swing.*;
import java.util.List;

// View สำหรับแสดงข้อมูลนกฮูกที่ผ่านเงื่อนไข
public class OwlView {
    public OwlView(Controller controller) {
        List<String> acceptedPets = controller.getAcceptedPets();
        StringBuilder owlList = new StringBuilder("Accepted Owls:\n");

        for (String pet : acceptedPets) {
            if (pet.contains("Owl")) {
                owlList.append(pet).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, owlList.toString(), "Owl List", JOptionPane.INFORMATION_MESSAGE);
    }
}
