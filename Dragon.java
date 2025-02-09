public class Dragon extends Pet {
    private int pollutionLevel;

    public Dragon(String id, String lastHealthCheckDate, int vaccineCount, int pollutionLevel) {
        super(id, lastHealthCheckDate, vaccineCount);
        this.pollutionLevel = pollutionLevel;
    }
}
