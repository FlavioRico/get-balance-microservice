package mx.com.multiva.sipare.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import mx.com.multiva.sipare.model.entity.SipareBalance;
import org.springframework.http.HttpStatus;

public class Balance extends SipareBalance {

    @JsonProperty("file_amounts")
    private Summary fileAmounts;
    @JsonProperty("t24_amounts")
    private Summary t24Amounts;
    private Comparison comparisons;
    private boolean balanced;
    @JsonIgnore
    private HttpStatus httpStatus;

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

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}
