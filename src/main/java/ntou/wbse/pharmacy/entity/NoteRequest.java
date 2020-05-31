package ntou.wbse.pharmacy.entity;

public class NoteRequest {

    private String pharmacyId;
    private String note;

    public void setPharmacyId(String pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPharmacyId() {
        return pharmacyId;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "NoteRequest{" +
                "pharmacyId='" + pharmacyId + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
