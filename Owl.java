public class Owl extends Pet {
    private int flightRange;

    public Owl(String id, String lastHealthCheckDate, int vaccineCount, int flightRange) {
        super(id, lastHealthCheckDate, vaccineCount);
        this.flightRange = flightRange;
    }
}