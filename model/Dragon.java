package model;

// คลาสสำหรับมังกร
public class Dragon extends Model {
    private double smokePollution;

    public Dragon(String id, String lastHealthCheck, int vaccineCount, double smokePollution) {
        super(id, "Dragon", lastHealthCheck, vaccineCount);
        this.smokePollution = smokePollution;
    }

    @Override
    public boolean validate() {
        return smokePollution <= 70; // มลพิษต้องไม่เกิน 70%
    }

    @Override
    public String toCSV() {
        return id + ",Dragon," + lastHealthCheck + "," + vaccineCount + "," + smokePollution;
    }
}
