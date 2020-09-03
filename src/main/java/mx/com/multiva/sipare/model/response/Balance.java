package mx.com.multiva.sipare.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Balance {

    private int id;
    @JsonProperty("dispatch_date")
    private String dispatchDate;
    private String type;
    @JsonProperty("file_amounts")
    private Summary fileAmounts;
    @JsonProperty("t24_amounts")
    private Summary t24Amounts;
    private Comparison comparisons;
    private boolean balanced;
    private int status;
    @JsonIgnore
    private int httpResponseCodeStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Summary getFileAmounts() {
        return fileAmounts;
    }

    public void setFileAmounts(Summary fileAmounts) {
        this.fileAmounts = fileAmounts;
    }

    public Summary getT24Amounts() {
        return t24Amounts;
    }

    public void setT24Amounts(Summary t24Amounts) {
        this.t24Amounts = t24Amounts;
    }

    public Comparison getComparisons() {
        return comparisons;
    }

    public void setComparisons(Comparison comparisons) {
        this.comparisons = comparisons;
    }

    public boolean isBalanced() {
        return balanced;
    }

    public void setBalanced(boolean balanced) {
        this.balanced = balanced;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getHttpResponseCodeStatus() {
        return httpResponseCodeStatus;
    }

    public void setHttpResponseCodeStatus(int httpResponseCodeStatus) {
        this.httpResponseCodeStatus = httpResponseCodeStatus;
    }

}
