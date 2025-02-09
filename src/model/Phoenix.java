package src.model;

public class Phoenix extends Pet {
    private boolean fireProofCertificate;

    public Phoenix(String id, String lastHealthCheckDate, int vaccineCount, boolean fireProofCertificate) {
        super(id, lastHealthCheckDate, vaccineCount);
        this.fireProofCertificate = fireProofCertificate;
    }

    public boolean hasFireProofCertificate() {
        return fireProofCertificate;
    }
}
