package src.controller;
import java.util.List;
import src.model.Database;

public class Controller {
    private Database database;

    public Controller(Database database) {
        this.database = database;
    }

    public List<String[]> getPetList() {
        return database.loadPets();  // ใช้ Database ที่อัปเดตแล้ว
    }
}
