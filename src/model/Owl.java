package src.model;
public class Owl extends Pet {
    private int flightRange;

    public Owl(String id, String lastHealthCheckDate, int vaccineCount, int flightRange) {
        super(id, lastHealthCheckDate, vaccineCount);
        this.flightRange = flightRange;
    }

    public int getFlightRange() {  //  เพิ่ม getter เพื่อให้สามารถใช้งานตัวแปรนี้ได้
        return flightRange;
    }
}
