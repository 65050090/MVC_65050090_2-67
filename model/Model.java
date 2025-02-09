package model;

// คลาสพื้นฐานของสัตว์เลี้ยงเวทมนตร์
public abstract class Model {
    protected String id;
    protected String type;
    protected String lastHealthCheck;
    protected int vaccineCount;

    public Model(String id, String type, String lastHealthCheck, int vaccineCount) {
        this.id = id;
        this.type = type;
        this.lastHealthCheck = lastHealthCheck;
        this.vaccineCount = vaccineCount;
    }

    // ตรวจสอบเงื่อนไขสัตว์แต่ละประเภท
    public abstract boolean validate();

    // แปลงข้อมูลเป็น CSV
    public abstract String toCSV();
}
