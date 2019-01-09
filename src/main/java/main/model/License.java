package main.model;

public class License {
    private String License;
    private float confidence;

    public License(String license, float confidence) {
        License = license;
        this.confidence = confidence;
    }

    public String getLicense() {
        return License;
    }

    public void setLicense(String license) {
        License = license;
    }

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }
}
