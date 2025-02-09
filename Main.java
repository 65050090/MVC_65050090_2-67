import javax.swing.*;

import src.model.Database;
import src.view.View;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Database db = new Database();
            new View(db); // ตรวจสอบว่ามี IView.java และ import ถูกต้อง
        });
    }
}
