import java.io.*;

public class Database {
    private static final String FILE_NAME = "pets.csv";

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
}
