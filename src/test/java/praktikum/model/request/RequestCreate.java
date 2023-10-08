package praktikum.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;


public class RequestCreate {
    @JsonProperty("addition")
    private Addition addition;
    @JsonProperty("importantNumbers")
    private int[] importantNumbers;
    @JsonProperty("title")
    private String title;
    @JsonProperty("verified")
    private boolean verified;
    public RequestCreate() {
    }

    public RequestCreate(Addition addition, int[] importantNumbers, String title, boolean verified) {
        this.addition = addition;
        this.importantNumbers = importantNumbers;
        this.title = title;
        this.verified = verified;
    }

    public Addition getAddition() {
        return addition;
    }

    public void setAddition(Addition addition) {
        this.addition = addition;
    }

    public int[] getImportantNumbers() {
        return importantNumbers;
    }

    public void setImportantNumbers(int[] importantNumbers) {
        this.importantNumbers = importantNumbers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}


