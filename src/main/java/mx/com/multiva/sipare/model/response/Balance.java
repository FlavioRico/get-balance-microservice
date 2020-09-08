package mx.com.multiva.sipare.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class Balance {

    private int id;
    @JsonProperty("dispatch_date")
    private String dispatchDate;
    @JsonProperty("payment_date")
    private String paymentDate;
    private String type;
    @JsonProperty("file_amounts")
    private Summary fileAmounts;
    @JsonProperty("t24_amounts")
    private Summary t24Amounts;
    private Comparison comparisons;
    private boolean balanced;
    private int status;
    @JsonIgnore
    private HttpStatus httpStatus;

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

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
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

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}
