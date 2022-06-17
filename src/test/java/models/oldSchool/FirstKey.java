package models.oldSchool;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FirstKey {
    private SecondKeyData data;
    private SecondKeySupport support;

    public SecondKeyData getData() {
        return data;
    }

    public void setData(SecondKeyData data) {
        this.data = data;
    }

    public SecondKeySupport getSupport() {
        return support;
    }

    public void setSupport(SecondKeySupport support) {
        this.support = support;
    }
}
