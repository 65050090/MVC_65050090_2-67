package model;

// คลาสสำหรับนกฟินิกซ์
public class Phoenix extends Model {
    private boolean fireProofCertificate;

    public Phoenix(String id, String lastHealthCheck, int vaccineCount, boolean fireProofCertificate) {
        super(id, "Phoenix", lastHealthCheck, vaccineCount);
        this.fireProofCertificate = fireProofCertificate;
    }

    @Override
    public boolean validate() {
        return fireProofCertificate; // ต้องมีใบรับรองกันไฟ
    }

    @Override
    public String toCSV() {
        return id + ",Phoenix," + lastHealthCheck + "," + vaccineCount + "," + fireProofCertificate;
    }
}
