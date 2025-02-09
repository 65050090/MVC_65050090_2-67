package view;

import controller.Controller;
import javax.swing.*;
import java.util.List;

// View สำหรับแสดงข้อมูลมังกรที่ผ่านเงื่อนไข
public class DragonView {
    public DragonView(Controller controller) {
        List<String> acceptedPets = controller.getAcceptedPets();
        StringBuilder dragonList = new StringBuilder("Accepted Dragons:\n");

        for (String pet : acceptedPets) {
            if (pet.contains("Dragon")) {
                dragonList.append(pet).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, dragonList.toString(), "Dragon List", JOptionPane.INFORMATION_MESSAGE);
    }
}
