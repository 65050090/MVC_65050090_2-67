import javax.swing.*;
import src.model.Model;
import src.controller.Controller;
import src.view.View;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // สร้าง Model แล้วสร้าง Controller จาก Model
            Model model = new Model();
            Controller controller = new Controller(model);
            // ส่ง Controller ไปยัง View
            new View(controller);
        });
    }
}
