package src.model;

import java.io.*;
import java.util.*;

public class Model {
    private static final String FILE_NAME = "data/pets.csv";

    // Constructor ที่รวมหน้าที่ตรวจสอบและสร้างไฟล์ CSV หากไม่มีอยู่
    public Model() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
                // เขียน header ลงในไฟล์ CSV
                writer.println("ID,Type,HealthCheckDate,VaccineCount");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // โหลดข้อมูลสัตว์ทั้งหมดจากไฟล์ CSV
    public List<String[]> loadPets() {
        List<String[]> pets = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                pets.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pets;
    }

    // ค้นหาสัตว์ตาม ID โดยการอ่านข้อมูลจากไฟล์ CSV
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
