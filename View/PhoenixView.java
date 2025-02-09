package view;

import controller.Controller;
import javax.swing.*;
import java.util.List;

// View สำหรับแสดงข้อมูลนกฟินิกซ์ที่ผ่านเงื่อนไข
public class PhoenixView {
    public PhoenixView(Controller controller) {
        List<String> acceptedPets = controller.getAcceptedPets();
        StringBuilder phoenixList = new StringBuilder("Accepted Phoenix:\n");

        for (String pet : acceptedPets) {
            if (pet.contains("Phoenix")) {
                phoenixList.append(pet).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, phoenixList.toString(), "Phoenix List", JOptionPane.INFORMATION_MESSAGE);
    }
}
