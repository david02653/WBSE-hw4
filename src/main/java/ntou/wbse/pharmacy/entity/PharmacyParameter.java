package ntou.wbse.pharmacy.entity;

public class PharmacyParameter {
    private String pharmacyName;
    private String zone;

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public String getZone() {
        return zone;
    }

    @Override
    public String toString() {
        return "PharmacyParameter{" +
                "pharmacyName='" + pharmacyName + '\'' +
                ", zone='" + zone + '\'' +
                '}';
    }
}
