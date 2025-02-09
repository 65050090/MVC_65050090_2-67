package src.model;
public class Dragon extends Pet {
    private int pollutionLevel;

    public Dragon(String id, String lastHealthCheckDate, int vaccineCount, int pollutionLevel) {
        super(id, lastHealthCheckDate, vaccineCount);
        this.pollutionLevel = pollutionLevel;
    }

    public int getPollutionLevel() {  //  เพิ่ม getter เพื่อให้สามารถใช้งานตัวแปรนี้ได้
        return pollutionLevel;
    }
}

