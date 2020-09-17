package mx.com.multiva.sipare.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "sipare_balances")
public class SipareBalance {

    @Id
    private int id;
    private String dispatchDate;
    private String type;
    private String paymentDate;
    @JsonIgnore
    private BigDecimal totalRcv;
    @JsonIgnore
    private BigDecimal totalVicAcvImss;
    @JsonIgnore
    private BigDecimal total;
    private int status;
    private String user;
    private String timestamp;

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

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getTotalRcv() {
        return totalRcv;
    }

    public void setTotalRcv(BigDecimal totalRcv) {
        this.totalRcv = totalRcv;
    }

    public BigDecimal getTotalVicAcvImss() {
        return totalVicAcvImss;
    }

    public void setTotalVicAcvImss(BigDecimal totalVicAcvImss) {
        this.totalVicAcvImss = totalVicAcvImss;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}