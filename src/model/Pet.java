package src.model;
public abstract class Pet {
    protected String id;
    protected String lastHealthCheckDate;
    protected int vaccineCount;

    public Pet(String id, String lastHealthCheckDate, int vaccineCount) {
        this.id = id;
        this.lastHealthCheckDate = lastHealthCheckDate;
        this.vaccineCount = vaccineCount;
    }

    public String getId() {
        return id;
    }
}
