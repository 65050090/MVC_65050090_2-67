package model;

// คลาสสำหรับนกฮูก
public class Owl extends Model {
    private int flightDistance;

    public Owl(String id, String lastHealthCheck, int vaccineCount, int flightDistance) {
        super(id, "Owl", lastHealthCheck, vaccineCount);
        this.flightDistance = flightDistance;
    }

    @Override
    public boolean validate() {
        return flightDistance >= 100; // ต้องบินได้ไกลกว่า 100 km
    }

    @Override
    public String toCSV() {
        return id + ",Owl," + lastHealthCheck + "," + vaccineCount + "," + flightDistance;
    }
}
