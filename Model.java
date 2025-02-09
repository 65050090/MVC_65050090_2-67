import java.io.*;
import java.util.*;

public class Model {
    private static final String FILE_NAME = "pets.csv";

    public List<String[]> loadPets() {
        List<String[]> pets = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                pets.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pets;
    }
}
