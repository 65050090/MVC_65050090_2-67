package src.controller;

import java.util.ArrayList;
import java.util.List;
import src.model.Model;

public class Controller {
    private Model model;
    private List<String[]> petRecords;

    public Controller(Model model) {
        this.model = model;
        this.petRecords = new ArrayList<>();
    }

    // ใช้ค้นหาสัตว์ตาม ID ผ่าน Model และเพิ่มข้อมูลที่พบเข้าไปใน petRecords
    public String[] findPetByID(String id) {
        String[] petData = model.findPetByID(id);
        if (petData != null) {
            petRecords.add(petData);
        }
        return petData;
    }

    // คืนค่ารายการสัตว์ที่ตรวจสอบทั้งหมด
    public List<String[]> getPetRecords() {
        return petRecords;
    }

    // คืนค่าข้อมูลสัตว์รายการล่าสุดที่เพิ่มเข้ามา
    public String[] getLastPetRecord() {
        if (!petRecords.isEmpty()) {
            return petRecords.get(petRecords.size() - 1);
        }
        return null;
    }

    // อัปเดตรายการสัตว์ล่าสุดด้วยข้อมูลที่แก้ไขแล้ว
    public void updateLastPetRecord(String[] updatedPet) {
        if (!petRecords.isEmpty()) {
            petRecords.set(petRecords.size() - 1, updatedPet);
        }
    }

    // การโหลดข้อมูลสัตว์ทั้งหมดจาก Model
    public List<String[]> getAllPets() {
        return model.loadPets();
    }
}
