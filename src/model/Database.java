package src.model;
import java.io.*;
import java.util.*;

public class Database {
    private static final String FILE_NAME = "data/pets.csv"; //  เปลี่ยนเป็น data/pets.csv

    public Database() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
                writer.println("ID,Type,HealthCheckDate,VaccineCount");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String[] findPetByID(String id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(id)) {
                    return data;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String[]> loadPets() {  
        List<String[]> pets = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                pets.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pets;
    }
}
