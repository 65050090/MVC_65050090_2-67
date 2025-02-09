
import model.Model;
import model.Phoenix;
import model.Dragon;
import model.Owl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// ตัวควบคุมระบบสัตว์เลี้ยงเวทมนตร์
public class Controller {
    private static final String FILE_NAME = "pets.csv";
    private List<Model> pets = new ArrayList<>();
    private int accepted = 0;
    private int rejected = 0;

    public Controller() {
        loadPetsFromCSV(); // โหลดข้อมูลสัตว์จาก CSV
    }

    private void loadPetsFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    String id = data[0];
                    String type = data[1];
                    String lastCheck = data[2];
                    int vaccines = Integer.parseInt(data[3]);

                    switch (type) {
                        case "Phoenix":
                            addPet(new Phoenix(id, lastCheck, vaccines, Boolean.parseBoolean(data[4])));
                            break;
                        case "Dragon":
                            addPet(new Dragon(id, lastCheck, vaccines, Double.parseDouble(data[4])));
                            break;
                        case "Owl":
                            addPet(new Owl(id, lastCheck, vaccines, Integer.parseInt(data[4])));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPet(Model pet) {
        if (pet.validate()) {
            pets.add(pet);
            accepted++;
        } else {
            rejected++;
        }
    }

    public String getReport() {
        return "Accepted: " + accepted + " | Rejected: " + rejected;
    }

    public List<String> getAcceptedPets() {
        List<String> petList = new ArrayList<>();
        for (Model pet : pets) {
            petList.add(pet.toCSV());
        }
        return petList;
    }
}
